<%-- 
    Document   : logout
    Created on : Oct 19, 2020, 10:58:53 PM
    Author     : pmoreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body>
        <h1>Cerrando sesion</h1>
        <%
            //Este JSP garantiza que la sesion se termina y el usuario ya no podra navegar mas en la App
            //poner en NULL los atributos de la sesion
            session.setAttribute("idpersona", null);
            session.setAttribute("iduser", null);
            session.setAttribute("nombre", null);
            session.setAttribute("apellidop", null);
            session.setAttribute("apellidom", null);            
            //invalidar la sesion
            session.invalidate();
            //redireccionar a la página principal
            response.sendRedirect("../index.jsp");
        %>
    </body>
</html>

