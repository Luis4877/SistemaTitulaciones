package sistema.model;

public class User {
    /************************************************************
    * Atributos de la clase
    ************************************************************/
    String username, passwd, rol;
    
    /************************************************************
    * Construtores
    ************************************************************/
    public User(){}
    
    /************************************************************
    * Métodos
    ************************************************************/
    //username
    public String getUsername()
    {
        return this.username;
    }
    public void setUsername(String uname)
    {
        this.username = uname;
    }
    //passwd
    public String getPasswd()
    {
        return this.passwd;
    }
    public void setPasswd(String psw)
    {
        this.passwd = psw;
    }
    //Rol
    public String getRol()
    {
        return this.rol;
    }
    public void setRol(String r)
    {
        this.rol = r;
    }
}
