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
import java.util.List;
import sistema.model.Promedio;
import sistema.util.Database;

public class PromedioDAO {
private Connection con=null;//variable para la conexion a la BD

    public PromedioDAO() {
        
          con = Database.getConnection();
          
    }
    
    public void aprobar(int ids){
          String respuesta="";
       String sql="update promedio  set status_tramite=true where matricula=?";
                PreparedStatement pstm = null; 
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
          pstm.setInt(1,ids);
           pstm.executeUpdate();//ejecutar el query 
    }catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        }
    
    public void rechar(int ids){
            String respuesta="";
       String sql="update promedio  set certificado=false,status_tramite=false where matricula=?";
                PreparedStatement pstm = null; 
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
          pstm.setInt(1,ids);
           pstm.executeUpdate();//ejecutar el query 
    }catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        
    }
    
    public List<Promedio> consultar() {
      //Este es el metodo para cargar alumnos de la bd con revision de promedio pendiente xd
       List<Promedio> datos = new ArrayList();
        String sql="select * from promedio where status_tramite=0; ";
                PreparedStatement pstm = null; 
                
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
        
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
             datos.add(new Promedio (rs.getInt("ID_modalidad"),
                     rs.getBoolean("certificado"),
                     rs.getString("Evidencia_certificado"),
                     rs.getBoolean("status_tramite"),
                     rs.getInt("matricula")
             
             ) );
               
               
               
        }}catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
      
      
      
      
      return datos;
        
        
    }


    
    public int buscarMat(int id){
        int matricula=0;
     String sql="select matricula from alumno where ID_Persona=?";
                PreparedStatement pstm = null; 
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
          pstm.setInt(1, id);
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
               matricula =  rs.getInt("Matricula");
               
               
               
        }}catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        
        
        
        return matricula;
    }
    public double obtenerGeneral(int matricula){
        String sql="SELECT CalificacionesCursos.Calificacion FROM CalificacionesCursos JOIN Kardex ON (CalificacionesCursos.ID_Kardex = Kardex.ID_Kardex) JOIN Cursos ON (CalificacionesCursos.Folio = Cursos.Folio) WHERE (Kardex.Matricula = ?) & (Cursos.Estado = 'FINALIZADO');";
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
               
               
        }}catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        for(int i=0;i<datos.size();i++){
            finale = finale + datos.get(i);j++;
        }
        
        promedioFinal = finale / j;
        
       promedioFinal= formatearDecimales(promedioFinal);
        
        
        
        return promedioFinal;
        
        
        
    }
    public static Double formatearDecimales(Double numero ) {
        Integer numeroDecimales=3;
return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
}
    
    
    
    
    public boolean revisarPromedio(int ids){
        boolean respuesta=false;
        int f=0;
       String sql="select (ID_modalidad) from promedio where matricula=?";
         PreparedStatement pstm = null; 
           ResultSet rs = null;
           try {
             pstm = con.prepareStatement(sql);
          pstm.setInt(1,ids);
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
        respuesta=true;
               
               
        }
               
        } catch (Exception e) {
        }
     
        
        
        return respuesta;
    }
public boolean revisarPromedios(int ids){
        boolean respuesta=false;
        int f=0;
       String sql="select (status_tramite) from promedio where matricula=?";
         PreparedStatement pstm = null; 
           ResultSet rs = null;
           try {
             pstm = con.prepareStatement(sql);
          pstm.setInt(1,ids);
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
        respuesta=rs.getBoolean("status_tramite");
               
               
        }
               
        } catch (Exception e) {
        }
     
        
        
        return respuesta;
    }





}
