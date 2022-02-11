package sistema.model;

public class Persona {
    /************************************************************
    * Atributos de la clase
    ************************************************************/
    int ID_Persona, ID_User;
    String Nombre, apellidoPaterno, apellidoMaterno;
    
    /************************************************************
    * Construtores
    ************************************************************/
    public Persona(){}
    
    /************************************************************
    * Métodos
    ************************************************************/
    //setters && getters de tipo int
    public int getIdPersona()
    {
        return this.ID_Persona;
    }
    public void setIdPersona(int a)
    {
        this.ID_Persona = a;
    }
    public int getIdUser()
    {
        return this.ID_User;
    }
    public void setIdUser(int a)
    {
        this.ID_User = a;
    }
    //setters && getters de tipo int
    public String getNombre()
    {
        return this.Nombre;
    }
    public void setNombre(String uname)
    {
        this.Nombre = uname;
    }
    public String getApellidoP()
    {
        return this.apellidoPaterno;
    }
    public void setApellidoP(String uname)
    {
        this.apellidoPaterno = uname;
    }
    public String getApellidoM()
    {
        return this.apellidoMaterno;
    }
    public void setApellidoM(String uname)
    {
        this.apellidoMaterno = uname;
    }
    
}
