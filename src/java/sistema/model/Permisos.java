package sistema.model;

public class Permisos {
    /************************************************************
    * Atributos de la clase
    ************************************************************/
    //almacena los tipos de permisos segun el Rol del usuario
  private boolean kardex_select, kardex_update, kardex_insert, kardex_delete;
     private boolean CyT_select, 
  CyT_Update,
  CyT_Insert,
  CyT_Delete;
    //identifica si el usuario es el Admin/soporte
    private boolean isAdmin;
    
    /************************************************************
    * Construtores
    ************************************************************/
    public Permisos(){}
    
    /************************************************************
    * Métodos
    ************************************************************/
    public void setAdmin(boolean a)
    {
        this.isAdmin = a;
    }
    public boolean getAdmin()
    {
        return this.isAdmin;
    }

    public boolean isCyT_select() {
        return CyT_select;
    }

    public void setCyT_select(boolean CyT_select) {
        this.CyT_select = CyT_select;
    }

    public boolean isCyT_Update() {
        return CyT_Update;
    }

    public void setCyT_Update(boolean CyT_Update) {
        this.CyT_Update = CyT_Update;
    }

    public boolean isCyT_Insert() {
        return CyT_Insert;
    }

    public void setCyT_Insert(boolean CyT_Insert) {
        this.CyT_Insert = CyT_Insert;
    }

    public boolean isCyT_Delete() {
        return CyT_Delete;
    }

    public void setCyT_Delete(boolean CyT_Delete) {
        this.CyT_Delete = CyT_Delete;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
  
}
