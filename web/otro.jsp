<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/sistemaKardex/CSS/otro.css">
    </head>
    <body>

      <section id="main-header">



   <header>
<%
            //JSP por default del usuario con base en el campo url de la BD
            //Crear variables locales y asignarles los valores almacenados en los atributos de la sesion
            int ID_Per  = (int)session.getAttribute("idpersona");
            int ID_Us = (int)session.getAttribute("iduser");
            String nom = (String)session.getAttribute("nombre");
            String apep = (String)session.getAttribute("apellidop");
            String apem = (String)session.getAttribute("apellidom");
            //la variable usernombre es para mantener el username durante la navegacion
            String usernombre = (String)session.getAttribute("usuario");
        %> 
     
   
 

     <nav class="navegacion">
   <ul class="menu">

     <li><a href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a></li>
     <li> <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_pre.jsp">Revisar PreRegistro</a> </li>  
    <li>  <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_cert.jsp">Revisar Certificado</a>   </li> 
    <li>   <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_prom.jsp">Revisar Titulacion Por promedio</a>    </li> 
     <li>   <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_dip.jsp">Revisar Diplomado</a> </li> 
   
   
   
   </ul>
 </nav>

 


   </header>


   </section>
        <h1>Datos de la Persona relacionada al Usuario</h1>
        


        <section id="main-content">


        <!-- imprimir en pantalla del JSp los valores almacenados en las vars locales -->
        <h2>username: <%out.println(usernombre);%> </h2>
        <h2>ID Persona: <%out.println(ID_Per);%> </h2>
        <h2>ID User <%out.println(ID_Us);%> </h2>
        <h2>Nombre: <%out.println(nom);%> </h2>
        <h2>A. Paterno: <%out.println(apep);%> </h2>
        <h2>A. Materno: <% out.println(apem);%> </h2>

        </section>







        <h1>Permisos del usuario</h1>



        <!--
        <%
            //crear vars locales para almacenar los permisos del usuario
            //para condicionar las acciones que el usuario puede hacer en el JSP
            boolean isAdmin  = (boolean)session.getAttribute("admin");
            boolean k_select = (boolean)session.getAttribute("CyT_s");
            boolean k_insert = (boolean)session.getAttribute("CyT_i");
            boolean k_update = (boolean)session.getAttribute("CyT_u");
            boolean k_delete = (boolean)session.getAttribute("CyT_d");
            //si el usuario es Administrador, imprimir en panatlla del JSP un mensaje
            if (isAdmin == true)
            {
                out.println("El usuario es administrador");

        %> -->
        <!-- lo que está en la etiqueta <script> es para usar javaScriot en el JSP -->
        <script>
            //var val = 10001;
            //var val="<%out.println(ID_Us);%>";
            //var loc = "controlAdmin?action=buscarPersona&usuario="+val;
            //document.write('<a href="' + loc + '">Ver Persona</a>');
        </script>

        <!-- el link de abajo invoca al metodo GET del servlet por default a menos que se indique explicitamente que se invoque al metodo POST -->



        <!--
        <%
            //${pageContext.request.contextPath} regresa el path absoluto del proyecto, ejemplo-> c:/NetBeans/sistema/
            }else{ //si no es Admin, se muestran en pantalla sus permisos
            //USAR LOS PERMISOS PARA PERMITIR NAVEGAR AL USUARIO EN LA APP WEB
            //ES DECIR, PARA QUE REALICE SOLO LAS ACCIONES PERMITIDAS
        %> -->


        <section id="main-content">
        <h2>Permiso de select: <% out.println(k_select); %></h2>
        <h2>Permiso de insert: <% out.println(k_insert); %></h2>
        <h2>Permiso de update: <% out.println(k_update); %></h2>
        <h2>Permiso de delete: <% out.println(k_delete); %></h2>


        </section>

        Menú Admin: <a href="controlAdmin?action=buscarPersona&usuario=<%out.println(usernombre);%>">Ver Persona en otro JSP</a>

        <br/>
              <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_cert.jsp">Revisar Certificado</a><br>
        <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_prom.jsp">Revisar Titulacion Por promedio</a><br>
        <a href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>

        <br/>
        <a href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>

        <!--
        <%
            out.println("<a href='../moduloLogin/logout.jsp'>Salir</a>");
            }
        %> -->
    </body>

    <div id="main-footer">
      <footer

          <p> FCAEI UAEM &copy; </p>





        </footer>
      </div>
</html>
