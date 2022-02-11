package sistema.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/************************************************************
* clases adicionales importadas para este proyecto
************************************************************/
import sistema.dao.AdminDAO;
import sistema.model.User;
import sistema.model.Permisos;
import sistema.model.Persona;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import sistema.dao.PromedioDAO;

//Para ver mas sobre annotations leer = https://www.arquitecturajava.com/el-concepto-de-java-annotations/
@WebServlet(name = "controlAdmin", urlPatterns = {"/controlAdmin"})
public class controlAdmin extends HttpServlet {
    /************************************************************
    * Variables locales
    ************************************************************/
    private AdminDAO admin;//declarar objeto de tipo AdminDAO
    /************************************************************
    * constructor
    ************************************************************/
    public controlAdmin()
    {
        super();//invocar métodos de la clase padre
        admin = new AdminDAO();//crear objetos de tipo AdminDAO
    }
    
    /************************************************************
    * Metodo GET
    ************************************************************/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //el metodo GET recibe todas las llamadas no especificadas en el JSP/HTML como POST 
        String forward="";//almacena la ruta a la que debe redireccionar al usuario
        String action = request.getParameter("action");//obtiene el valor del campo 'action' desde el JSP
        //si el parametro action = buscarPersona hacer lo siguiente
        if (action.equalsIgnoreCase("buscarPersona"))
        {            
            //crear la var buscar y alamacer al parametros "usuario" que viene del JSP para buscar los datos Persona de ese usuario
            String buscar = request.getParameter("usuario");
            //crear una objeto Persona para almacenar los datos de ese usuario
            Persona x = new Persona();
            //Ejecutar el query en la BD para obtener los datos Persona del usuario
            x = admin.getPersona(buscar);
            //almacenbar los datos Persona del usuario en atributos de la sesion por si se llegan a usar mas adelante
            request.getSession().setAttribute("idpersona", x.getIdPersona());
            request.getSession().setAttribute("iduser", x.getIdUser());
            request.getSession().setAttribute("nombre", x.getNombre());
            request.getSession().setAttribute("apellidop", x.getApellidoP());
            request.getSession().setAttribute("apellidom", x.getApellidoM());
            //asignar la pagina JSP a la que se redireccionara al usuario
            forward = "verPersona.jsp"; //podria buscarse la url desde la BD asi: admin.getURLMenu(buscar);
            //usar el metodo de redireccion creado por el programador 
            this.redireccionar(forward, request, response);
        }
    }

    /************************************************************
    * Metodo POST 
    ************************************************************/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward="";//almacena la ruta a la que debe redireccionar al usuario
        String action = request.getParameter("action");//obtiene el valor del campo 'action' del JSP
        response.setContentType("text/plain; charset=UTF-8");//establece el tipo de contenido de la respuesta 'text' en unicode UTF8
        PrintWriter out = response.getWriter();//devuelve un objeto PrintWriter para imprimir (enviar) texto en la página del navegador (cliente)
        
        if(action.equalsIgnoreCase("login"))//si el campo value de 'action' que viene del JSP es = login 
        {
            String user = request.getParameter("usuario");//<input type="text" name="usuario" /> de index.jsp
            String passwd = request.getParameter("password");//<input type="password" name="password"/> de index.jsp
            if (admin.login(user, passwd))//funcion boolean para obtener true si el login es valido
            {
                //si el login es valido se consulta en la BD la url a redireccionar al usuario
                forward = admin.getURLMenu(user);//obtener url para redireccionar al usuario       
                //obtener datos del usuario
                int id_usuario = admin.getusuarioPorNombre(user);//obtener el ID_User de la tabla Usuario
                int id_rol = admin.getRolByUsuario(id_usuario);//obtener el ID_Rol de la tabla Usuario
                //asignar los siguientes atributos al HashMap de la sesion
                request.getSession().setAttribute("usuario", user);//agrega el unername al hashmap          
                request.getSession().setAttribute("userid", id_usuario);
                request.getSession().getAttribute("usuario");
                //Cargar permisos del usuario en un objeto de tipo Permisos
                Permisos pp = admin.obtenerPermisos(user);//obtener permisos del usuario                                
                //asignar  los pernmisos del usuario como atributos de la sesion para el control de navegacion del usuairo en la App               
                this.agregaPermiso(pp, request);
                //registrar la actividad de inicio de sesion del usuario en la bitacora
                admin.registroEnBitacora(id_usuario, id_rol);
                
            }else{
                //si el login falla, se redirecciona a login.jsp y se muestra un mensaje
                forward = "index.jsp";
                //asignar un texto al atributo mensaje 
                request.getSession().setAttribute("mensaje", "Usuario o contraseña no validos");
            } 
            //si el login es true, se crea un objeto de tipo persona para obtener los datos del usuario
            Persona x = new Persona();
            //invocar al metodo getPerosna del DAO para ejecutar el query
            x = admin.getPersona(user);
            //asignar algunos atributos a la sesion por si se ocupan mas adelante
                   PromedioDAO s = new PromedioDAO();
            s.buscarMat(x.getIdPersona());
            request.getSession().setAttribute("matricula",s);
         //Metodo para buscar su matricula ya que se utiliza mas adelante en TITULACIONESXD
         
            
            
            
            request.getSession().setAttribute("idpersona", x.getIdPersona());
            request.getSession().setAttribute("iduser", x.getIdUser());
            request.getSession().setAttribute("nombre", x.getNombre());
            request.getSession().setAttribute("apellidop", x.getApellidoP());
            request.getSession().setAttribute("apellidom", x.getApellidoM());
        
            
           
            
/*
            //las dos lineas comentadas es la manera tradicional de redireccionar y enviar los objetos request y response
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
*/
            //funcion personalizada para reenviar al usuario a la pagina ciontenida en "forward"
            this.redireccionar(forward, request, response);//enviar la url a redireccionar, y los objetos por la sesion
            
        }else if (action.equalsIgnoreCase("buscarPersona"))
        {
            //hacer algo cuando al parametro action contenga la palabra "buscarPersona"
/*            
            //System.out.println("Imprimiendo desde buscarPersona"+request.getSession().getAttribute("idpersona"));
            String buscar = request.getParameter("usuario");
            Persona x = new Persona();
            x = admin.getPersona(buscar);
            request.getSession().setAttribute("idpersona", x.getIdPersona());
            request.getSession().setAttribute("iduser", x.getIdUser());
            request.getSession().setAttribute("nombre", x.getNombre());
            request.getSession().setAttribute("apellidop", x.getApellidoP());
            request.getSession().setAttribute("apellidom", x.getApellidoM());
            forward = "verPersona.jsp";
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            this.redireccionar(forward, request, response);
*/
            }else if (action.equalsIgnoreCase("alta_usuario"))
        {
            // hacer algo ......
        }else if(action.equalsIgnoreCase("modificar_usuario"))
        {
            //hacer algo ......
        }
        
    }//fin doPost
    /************************************************************
    * Otros metodos de la clase 
    ************************************************************/
    public void agregaPermiso(Permisos p, HttpServletRequest req)
    {        
        //agrega permisos del modulo de Kardex a la sesion
     //agrega permisos del modulo de Kardex a la sesion
        req.getSession().setAttribute("admin",p.isIsAdmin());
              req.getSession().setAttribute("CyT_s", p.isCyT_select());
               req.getSession().setAttribute("CyT_u",p.isCyT_Update());
        req.getSession().setAttribute("CyT_i",p.isCyT_Insert());
       
        req.getSession().setAttribute("CyT_d",p.isCyT_Delete());
    }
    
    public void redireccionar(String forward,HttpServletRequest request,HttpServletResponse response) 
            throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    

}
