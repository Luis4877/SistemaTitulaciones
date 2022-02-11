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
import sistema.util.Database;

import sistema.model.Pre_registro;

public class PreDAO {
      private Connection con=null;//variable para la conexion a la BD

    public PreDAO() {
       con = Database.getConnection();
        
    }
    
    public String aprobar(int mat){
        String respuesta = "OK";
                String sql="update pre_registro set status_tramite = 1 where matricula=?";
                 PreparedStatement pstm = null; 
           ResultSet rs = null;
           try {
            pstm=con.prepareStatement(sql);
         
            pstm.setInt(1,mat);
            pstm.executeUpdate();
           } catch (Exception e) {
               
               
        }
    
               return respuesta;
            
    }
                
                    
    
    
    
     public String mandar(Object obj){
        Pre_registro pre = (Pre_registro) obj;
        String sql="insert into pre_registro(nivel_academico,carrera,matricula,nacimiento,curp,nombre,paterno,materno,sexo,fecha_nacimiento,correo) values(?,?,?,?,?,?,?,?,?,?,?)";
        
        String respuesta="";
        try {
             PreparedStatement preparedStatement = con.prepareStatement("insert into pre_registro(nivel_academico,carrera,matricula,nacimiento,curp,nombre,paterno,materno,sexo,fecha_nacimiento,correo,status_tramite) values(?,?,?,?,?,?,?,?,?,?,?,?)");
             //empezamos a hacer set a la sentencia ya preparada anteriormente
             
              preparedStatement.setString(1,pre.getNivel_academico());
                preparedStatement.setString(2,pre.getCarrera());
                preparedStatement.setInt(3,pre.getMatricula());
                 preparedStatement.setString(4,pre.getNacimiento());
                  preparedStatement.setString(5,pre.getCurp());
                   preparedStatement.setString(6,pre.getNombre());
                    preparedStatement.setString(7,pre.getPaterno());
                     preparedStatement.setString(8,pre.getMaterno());
                      preparedStatement.setString(9,pre.getSexo());
                       preparedStatement.setString(10,pre.getFecha_nacimiento());
                        preparedStatement.setString(11,pre.getCorreo());
                        preparedStatement.setBoolean(12,pre.isStatus_tramite());
                             int filas = preparedStatement.executeUpdate();
                              respuesta="Accion completa,registrados "+filas+"\t documentos";     
                              
        } catch (SQLException ex) {
       
        }
        
        
        
        return respuesta;
    }
    
       public boolean consultar(int matricula) throws SQLException{
        List<Pre_registro> datos  = new ArrayList();
        String sql="select * from pre_registro where matricula=?; ";
                PreparedStatement pstm = null; 
                boolean respuesta=false;
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
         pstm.setInt(1,matricula);
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
           respuesta=true;
              
        }
           
         
      
         }catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        
        
        
        return respuesta;
    }
    
    public boolean consultar1(int matricula) throws SQLException{
        List<Pre_registro> datos  = new ArrayList();
        String sql="select  status_tramite from pre_registro where matricula=?";
                PreparedStatement pstm = null; 
                boolean respuesta=false;
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
         pstm.setInt(1,matricula);
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
           respuesta= rs.getBoolean("status_tramite");
              
        }
           
         
      
         }catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        
        
        
        return respuesta;
    }
       public List<Pre_registro> consult() {
        List<Pre_registro> datos  = new ArrayList();
        String sql="select * from pre_registro  where status_tramite=0 ;";
             PreparedStatement pstm = null; 
                
           ResultSet rs = null;
         try{
           pstm = con.prepareStatement(sql);
         
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
               datos.add( new Pre_registro(
                       rs.getInt("id"),
                    rs.getString("nivel_academico"),
              rs.getString("carrera"),
              rs.getInt("matricula"),
              rs.getString("nacimiento"),
                        rs.getString("curp"),
                        rs.getString("nombre"),
                       rs.getString("paterno"),
                        rs.getString("materno"),
                        rs.getString("sexo"),
                        rs.getString("fecha_nacimiento"),
                        rs.getString("correo"),
                       rs.getBoolean("status_tramite")
               
               ));
                       
              
        }
           
         
      
         }catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        
        
        
          return datos;
    }
      
    
    
    
    
}
