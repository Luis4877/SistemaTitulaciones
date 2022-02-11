<%-- 
    Document   : error
    Created on : Oct 16, 2020, 8:59:57 PM
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
        <h1>Error.jsp</h1>
          <%
            int useid = (int)session.getAttribute("userid");
            String nom = (String)session.getAttribute("usuario");
            if (useid > 0){
                out.println(useid);
                out.println(nom);

            }
        %>
    </body>
</html>
