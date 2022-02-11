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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.model.Certificado;
import sistema.model.Diplomado;
import sistema.util.Database;
public class DiplomadoDAO {
 private Connection con=null;//variable para la conexion a la BD
public int matricula=0;
    public DiplomadoDAO() {
      con = Database.getConnection();
    }
    
    
    public String insertar(Object obj,int mat){
        Diplomado d = (Diplomado) obj;
        
        String sql="select idTramite from certificado where matricula=?;";
        int dato=0;
        String respuesta="";
        ResultSet rs = null;
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,mat);
            rs = pstm.executeQuery();
            while(rs.next()){
                dato=rs.getInt("idTramite");
            }
            
            
            PreparedStatement preparedStatement = con.prepareStatement("insert into diplomado (matricula,certificado,evidencia_certificado,BoletaOficial,evidencia_boletaOficial,Status,observaciones,Fotostamaño_diploma,evidencia_fotos,modalidad,Status_tramite) values(?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, mat);
            preparedStatement.setInt(2,dato);
              preparedStatement.setString(3,d.getEvidencia_certificado());
             preparedStatement.setInt(4,d.getBoletaOficial());
              preparedStatement.setString(5,d.getEvidenciaBoletaOficial());
              preparedStatement.setString(6,d.getStatus());
               preparedStatement.setString(7,d.getObservaciones());
            preparedStatement.setInt(8,d.getFotos());
            preparedStatement.setString(9,d.getEvidencia_fotos());
            preparedStatement.setString(10,d.getModalidad());
            preparedStatement.setInt(11,d.getStatus_tramite());
            preparedStatement.executeUpdate();
            respuesta="todo ok";
            
        } catch (Exception e) {
        }
    
    
    return respuesta;
    }
    
    //metodo para consultar los diplomados en revision
    
    public List<Diplomado> consultar(){
        List<Diplomado> datos = new ArrayList();
        String sql="select * from diplomado where Status_tramite=0";//traemos los que no estan revisados
              
        try{
        PreparedStatement pstm = null;
                 ResultSet rs = null;
                 pstm = con.prepareStatement(sql);
                 rs = pstm.executeQuery();
                 while(rs.next()){
                     datos.add( new Diplomado(  
                     //aqui insertamos 1 por 1 los datos de los diplomados
                             rs.getInt("matricula"),
                             rs.getInt("id_Modalidad"),
                             rs.getInt("certificado"),
                             rs.getString("evidencia_certificado"),
                             rs.getInt("BoletaOficial"),
                             rs.getString("evidencia_boletaOficial"),
                             rs.getString("Status"),
                             rs.getString("observaciones"),
                             rs.getInt("Fotostamaño_diploma"),
                             rs.getString("evidencia_fotos"),
                             rs.getString("modalidad"),
                             rs.getInt("Status_tramite")
                     
                     
                     
                     ));
                 }
        
        }catch(Exception e){
        }     
               
        return datos;
    }
    
    public void aprobar(int id,String observaciones){
        String sql="update diplomado set status =? ,observaciones=?,Status_tramite=? where matricula=?";
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = con.prepareStatement(sql);
            //EMPEZAMOS A HACER UN SET A LOS ATRIUTOS
            pstm.setString(1,"FINALIZADO");
            pstm.setString(2,observaciones);
            pstm.setInt(3,1);
            pstm.setInt(4, id);
            
            pstm.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
    public void rechazar(int id,String observaciones){
     String sql="update diplomado set status =? ,observaciones=?,Status_tramite=? where matricula=?";
        PreparedStatement pstm;
        ResultSet rs;
        try {
            pstm = con.prepareStatement(sql);
            //EMPEZAMOS A HACER UN SET A LOS ATRIUTOS
            pstm.setString(1,"RECHAZADO");
            pstm.setString(2,observaciones);
            pstm.setInt(3,0);
            pstm.setInt(4, id);
            
            pstm.executeUpdate();
            
        } catch (Exception e) {
        }
    
    
    
    
    
}

  public boolean revisarDiplomado(int matricula){
        boolean respuesta=false;
        
       PreparedStatement pstm=null;
       ResultSet rs=null;
        try {
            pstm=con.prepareStatement("select  matricula from diplomado where matricula =?");
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            while(rs.next()){
                respuesta=true;
            }
                 
        } catch (Exception e) {
        }
        
       
        
        return respuesta;
       
    }















}
