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
public class CertificadoDAO {
    private Connection con=null;//variable para la conexion a la BD
public int matricula=0;

    public CertificadoDAO() {
   con = Database.getConnection();

    }
    
    
    
    //AQUI RECIBIMOS EL OBJECTO TIPO OBJECTO GENERICO Y HACEMOS UN CASTING A UN OBJECTO TIPO CERTIFICADO
     public String insertar(Object obj) {
       Certificado c = (Certificado) obj;
       String respuesta="Ninguna";
     try {
         //PREPARA TU SENTENCIA SQL
         PreparedStatement preparedStatement = con.prepareStatement("insert into certificado (matricula,fotos,prueba_fotos,recibo_Pago,prueba_reciboPago,constanciaBibioteca,evidencia_constanciaBiblioteca,constancia_noadeudo,evidencia_constanciaNoadeudo,actaNacimiento,evidencia_actaNacimiento,status_tramite,Tramite_Finalizado) values(?,?,?,?,?,?,?,?,?,?,?,?,0)");
         //empezamos con los SET para la sentencia preparada 
   
         
         
         
         // IMPORTANTE QUE COMPRUEBES EL ORDEN DE TU INSERT 
        preparedStatement.setInt(1,c.getMatricula());
      preparedStatement.setBoolean(2,c.isFotos());
      preparedStatement.setString(3,c.getPrueba_fotos());
      preparedStatement.setBoolean(4,c.isRecibo_pago());
      preparedStatement.setString(5,c.getPrueba_recibopago());
      preparedStatement.setBoolean(6,c.isConstancia_biblioteca());
      preparedStatement.setString(7,c.getConstancia_bibliotecaPrueba());
       preparedStatement.setBoolean(8,c.isConstancia_noAdeudo());
       preparedStatement.setString(9,c.getPrueba_constanciaNoadeudo());
       preparedStatement.setBoolean(10,c.isActa_nacimiento());
       preparedStatement.setString(11,c.getPrueba_Actanacimiento());
       preparedStatement.setString(12,c.getStatus_tramite());
              int filas = preparedStatement.executeUpdate();
            
     respuesta="Accion completa,registrados "+filas+"\t documentos";       
     } catch (SQLException ex) {
           try {
               Logger.getLogger(CertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
               
               con.rollback();
           } catch (SQLException ex1) {
               Logger.getLogger(CertificadoDAO.class.getName()).log(Level.SEVERE, null, ex1);
           }
          
     }
  
       
    return respuesta;
    }
     
     //revisar
    public boolean revisarCertificado(int matricula){
        boolean respuesta=false;
        
       PreparedStatement pstm=null;
       ResultSet rs=null;
        try {
            pstm=con.prepareStatement("select Tramite_Finalizado from Certificado where (matricula=?)");
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            while(rs.next()){
                respuesta=rs.getBoolean("Tramite_Finalizado");
            }
                 
        } catch (Exception e) {
        }
        
        if(respuesta==true){
            return true;
        }else{
            return false;
        }
        
        
       
    }
    
    public List<Certificado> consultar() {
        List<Certificado> datos = new ArrayList();
        String sql="select *  from certificado where Tramite_Finalizado=0";
        PreparedStatement pstm = null; 
                
           ResultSet rs = null;
           try {
             pstm = con.prepareStatement(sql);
        
           rs = pstm.executeQuery();//ejecutar el query 
           while(rs.next()){
               //sacamos los datos de la tabla xd
               datos.add(
                       
               new Certificado(
               
               rs.getInt("matricula"),
               rs.getBoolean("fotos"),
               rs.getString("prueba_fotos"),
                       
                  rs.getBoolean("recibo_Pago"),
               rs.getString("prueba_reciboPago"),
                       
                    rs.getBoolean("constanciaBibioteca"),
               rs.getString("evidencia_constanciaBiblioteca"),
                       
                    rs.getBoolean("constancia_noadeudo"),
               rs.getString("evidencia_constanciaNoadeudo"),
              
                       rs.getBoolean("actaNacimiento"),
               rs.getString("evidencia_actaNacimiento"),
                       
                       rs.getString("status_tramite")
                      
             )
               
               
               
               );
                       
                       
           }
        } catch (Exception e) {
        }
        
      
        
        
        return datos;
    }
    
    
    
public void noAprobar(int matricula,String observaciones){
         String sql="update certificado set status_tramite='NO APROBADO',observaciones=?,Tramite_Finalizado=0 where matricula=?";
        String respuesta="ok";
          PreparedStatement pstm = null; 
           ResultSet rs = null;
           try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1,observaciones);
            pstm.setInt(2, matricula);
            pstm.executeUpdate();
           } catch (Exception e) {
        }
    
    }
    public void aprobar(int matricula,String observaciones){
        String sql="update certificado set status_tramite='FINALIZADO',observaciones=?,Tramite_Finalizado=1 where matricula=?";
        String respuesta="ok";
          PreparedStatement pstm = null; 
           ResultSet rs = null;
           try {
            pstm=con.prepareStatement(sql);
            pstm.setString(1,observaciones);
            pstm.setInt(2, matricula);
            pstm.executeUpdate();
           } catch (Exception e) {
        }
    
    }
    
    
    public boolean revisarCert(int ids){
          boolean respuesta=false;
        int f=-1;
       String sql="select  idTramite  from certificado where matricula=?";
         PreparedStatement pstm = null; 
           ResultSet rs = null;
           try {
             pstm = con.prepareStatement(sql);
             pstm.setInt(1,ids);
             rs=pstm.executeQuery();
             while(rs.next()){
                 f=rs.getInt("idTramite");
             }
               
        } catch (Exception e) {
        }
           if(f>0){
               respuesta=true;
           }
           return respuesta;
    }
    
    
    public int obtenerMatricula(int m){
      
        matricula=m;
        
        return matricula;
    }
      public boolean consult(int matricula) throws SQLException{
        //List<P> datos  = new ArrayList();
        String sql="select * from certificado where matricula = ?;";
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
    

}
