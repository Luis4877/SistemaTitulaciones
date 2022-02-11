/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

/**
 *
 * @author Valdez
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sistema.util.Database;
public class restriccionesDAO {
    private Connection con=null;//variable para la conexion a la BD
    public restriccionesDAO() {
        
        
         con = Database.getConnection();
    }
  public boolean revisar(int matricula){
       boolean respuesta=false;
       int semestre=0;
       String s="select Semestre_Actual from alumno where Matricula=?";
        String sql="SELECT CalificacionesCursos.Calificacion FROM CalificacionesCursos JOIN Kardex ON (CalificacionesCursos.ID_Kardex = Kardex.ID_Kardex) JOIN Cursos ON (CalificacionesCursos.Folio = Cursos.Folio) WHERE (Kardex.Matricula = ?) & (Cursos.Estado = 'FINALIZADO');";
       String practicas="select FinishP from Practicas where matricula=?";
       String servicio="select FinishS from Servicio where matricula=?";
        boolean P=false,S=false;
        double promedioFinal=0;
        double finale=0;
        int j=0;
          PreparedStatement pstm = null; 
           ResultSet rs = null;
         ArrayList<Integer> datos= new ArrayList();
         try{
             
             
           pstm = con.prepareStatement(sql);
          pstm.setInt(1, matricula);
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
          datos.add(rs.getInt("Calificacion"));
               
               
        }
         pstm=con.prepareStatement(s);
         pstm.setInt(1,matricula);
         rs = pstm.executeQuery();
         while(rs.next()){
             semestre= rs.getInt("Semestre_Actual");
         }
         //aqui verificamos que tenga las practicas en orden xD y el servicio OK PARA PODER GRADUARSE
         
         pstm=con.prepareStatement(practicas);
         pstm.setInt(1,matricula);
         rs=pstm.executeQuery();
         while(rs.next()){
             P = rs.getBoolean("FinishP");
         }
         
         pstm=con.prepareStatement(servicio);
        pstm.setInt(1,matricula);
        rs=pstm.executeQuery();
        while(rs.next()){
            S=rs.getBoolean("FinishS");
        }
         
         
         }
         
         catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
         
        for(int i=0;i<datos.size();i++){
            finale = finale + datos.get(i);j++;
        }
        
        promedioFinal = finale / j;
        
       promedioFinal= formatearDecimales(promedioFinal);
        //aqui se comprueba que tenga su semestre actual en el 8vo ,su promedio se mayor a 6 y sus practicas y servicio esten completos
       if(promedioFinal>6.0 && semestre==8 && P==true && S==true){
           respuesta = true;
       }else{
          respuesta = false;
       }
        
        
        
        return respuesta;
    }
    
  
  
  // Funcion para tener menos decimales del promedio 
       public static Double formatearDecimales(Double numero ) {
        Integer numeroDecimales=3;
return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
}
}


