/************************************************************
* En el backend, esta clase permite acceder a la capa de datos
************************************************************/
package sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.util.ResourceBundle;

public class Database {
    /************************************************************
    * Atributos/Variables
    ************************************************************/
    private static final long serialVersionUID = 1L;
    private static Connection con = null;
    
    /************************************************************
    * Métodos: función que crea una conexión al BDMS
    ************************************************************/
    public static Connection getConnection()
    {
        try
        {
            if(con == null)
            {
                // con esto determinamos cuando finalize el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                //ResourceBundle rb = ResourceBundle.getBundle("sistema.util.jdbc"); 
                //String driver=rb.getString("driver");
                //String url=rb.getString("url");
                //String pwd=rb.getString("pwd");
                //String usr=rb.getString("usr");
                String usr="root";
                String pwd="Luis4877";
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/proyecto?serverTimezone=UTC";
                Class.forName(driver);
                con = DriverManager.getConnection(url,usr,pwd);
            }
            return con;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Error al abrir la conexion",ex);
        }
    }
    
    /************************************************************
    * listener (escuchador) 
    ************************************************************/
    static class MiShDwnHook extends Thread
    {
	// justo antes de finalizar el programa la JVM invocara 
	// a este metodo donde podemos cerrar la conexion
	@Override
	public void run()
	{
            try
            {
		Connection con = Database.getConnection(); 
		con.close();
            }catch(Exception ex){
		ex.printStackTrace();
		throw new RuntimeException(ex);
            }
	}
    }
    
    /************************************************************
    * función para cerrar la conexión al BDMS
    ************************************************************/
    public static void close(Connection con)
    {
        try{
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Error al cerrar la conexion",ex);
        }
        
    }
}
