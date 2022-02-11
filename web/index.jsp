<%-- 
    Document   : index
    Created on : Oct 16, 2020, 12:17:10 PM
    Author     : pmoreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <title>Login</title>
        <style type="text/css">
          html{background: no-repeat center/170% url("/sistemaKardex/CSS/UAEM2.jpg")}
     #form{
            background-color: white;
            margin-top: 15%;
            margin-left: 35%;
            margin-right: 35%;
            border-radius: 30px;
            width: auto;
            height: auto;
            padding: 2%;
            opacity: 70%
          }
          label{
            font-family: bold Arial, sans-serif;
          }
          h2{
            font-family: bold Arial, sans-serif;
          }
          .a:hover{
            cursor: pointer;
          }
          button:hover{
            cursor: pointer;
          }
        </style>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <!-- El formulario ibnvoca al sevlet llamado controlAdmin -->
      <center><div id="form">
        <form method="post" action="controlAdmin">
                <input type="hidden" name="action" value="login">
                <h2>Login</h2>
                <label for="User">Usuario</label><br>
                <input type="text" name="usuario" placeholder="Usuario" autofocus required/>
                <br><br>
                <label for="passwd">Contraseña</label><br>
                <input id="pass1" type="password" name="password" placeholder="Contraseña" required/>
                <button type="button" name="button" onclick="mostrarContraseña()"><span class="fa fa-eye-slash icon"></span></button>
                <br><br>
                <input class="a" type="submit" value="Login" />
                <input class="a" type="reset" value="Reset" />

                <script type="text/javascript" src="mostrarContra.js"></script>
            </form>
        </div></center>

        <!--
        <%
            //la var msg guarda el valor que contiene el atributo "mensaje" de la sesion
            String msg = (String)session.getAttribute("mensaje");
            //si el mesnaje no esta vacio
            if(!(msg==null))
            {
                //imprimir el mensaje en pantalla desde el JSP
                out.println(msg);
                //se pone a null el valor del atributo "mensaje"
                session.setAttribute("mensaje", null);
            }
        %>
      -->
    </body>
</html>  
