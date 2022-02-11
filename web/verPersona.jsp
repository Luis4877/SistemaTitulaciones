<%-- 
    Document   : verPersona
    Created on : Oct 19, 2020, 11:25:43 PM
    Author     : pmoreno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>verPersona.jsp</h1>
        <%
            //Este JSP en invocado desde otro.jsp para comprobar que ambos JSP comparten información 
            //variables locales
            int ID_Per  = (int)session.getAttribute("idpersona");
            int ID_Us = (int)session.getAttribute("iduser");
            String nom = (String)session.getAttribute("nombre");
            String apep = (String)session.getAttribute("apellidop");
            String apem = (String)session.getAttribute("apellidom");
        %>
        <!--imprimir en pantalla del JSP la info del usuario -->
        <br/>
        <h2>ID Persona: <%out.println(ID_Per);%> </h2>         
        <h2>ID User <%out.println(ID_Us);%> </h2>             
        <h2>Nombre: <%out.println(nom);%> </h2>       
        <h2>A. Paterno: <%out.println(apep);%> </h2> 
        <h2>A. Materno: <% out.println(apem);%> </h2>
        <br/>
        <!-- enlace para regresar al JSP anterior durante la navegacion del usuario -->
        <a href="${pageContext.request.contextPath}/otro.jsp">Regresar</a>
        <br/>
        <!-- enlace para termianr la sesion del usuario -->
        <a href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>
    </body>
</html>
