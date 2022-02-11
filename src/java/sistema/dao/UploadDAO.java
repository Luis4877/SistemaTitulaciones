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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.*;
import sistema.controller.*;
import sistema.model.*;
import sistema.dao.*;
import sistema.util.Database;

//upload para la titulacion por promedio donde solo se requiere un documento (Certificado)

public class UploadDAO {
      private Connection connection;

    public UploadDAO() {
        
        connection=Database.getConnection();     
    }
    
        public void subirDocumentos(String archivo,int ids) throws SQLException 
    {
        
        
        /*
        
        hacemos un tipo tigger donde seleccionamos el id de la modalidad que registramos para agregar 
        sus datos a la tabla intermedia que es titulaciones
        
        */
    
         int n=0;  
     try{  
         
        // connection.setAutoCommit(false);
      ResultSet rs;
        PreparedStatement pstm = connection.prepareStatement("select idTramite from certificado where matricula=?");
      pstm.setInt(1,ids);
      rs = pstm.executeQuery();
      while(rs.next()){
          n=rs.getInt("idTramite");
      }
      //sacamos su id del certificado xD
      
        PreparedStatement preparedStatement = connection.prepareStatement("insert into promedio(certificado,Evidencia_certificado,status_tramite,matricula,modalidad) values(?,?,?,?,?);");
        preparedStatement.setInt(1,n);//insertamos el numero de tramite de certificado
        preparedStatement.setString(2,archivo);
        preparedStatement.setInt(3,0);
        preparedStatement.setInt(4,ids);
        preparedStatement.setString(5,"PROMEDIO");
        preparedStatement.executeUpdate();


        
     }catch(SQLException e){
        e.printStackTrace();
     
     }  
    }
}
