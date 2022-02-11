<%-- 
    Document   : rev_prom
    Created on : 20/12/2020, 01:15:08 PM
    Author     : Valdez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sistema.dao.PromedioDAO" %>
<%@page  import="java.util.*" %>
<%@page  import="sistema.controller.controlProm"%>
<%@page import="sistema.model.Promedio"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revision Promedio</title>
          <link rel="stylesheet" type="text/css" href="/sistemaKardex/CSS/promedio.css"/>
    </head>
    <%
        
        PromedioDAO dao = new PromedioDAO();
        List<Promedio> datos = new ArrayList();
        
        
        %>


    <body>
   
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
       <center>
           <table  class="contenido-tabla">
               <thead>
                   <tr>
                       <td> ID Persona</td>
                       <td>ID User</td>
                       <td>Username</td>
                       <td>Nombre </td>
                       <td>A.Paterno </td>
                       <td>A.Materno</td>
                   </tr>
                   
               </thead>
              
                   <tr> 
                        <tbody>
                       <td> <%out.println(ID_Per);%></td>
                       <td><%out.println(ID_Us);%> </td>
                       <td><%out.println(usernombre);%> </td>
                       <td><%out.println(nom);%>  </td>
                       <td><%out.println(apep);%> </td>
                       <td> <% out.println(apem);%></td>
                          </tbody>
                   </tr>
                   
            
        </table>
      
        <br><br>
        <br><br>    
        <br>
        <form method="POST"  name="APROBAR" action="${pageContext.request.contextPath}/controlProm">
        <label>Aceptar promedio por MATRICULA:</label>
        <input type="text" placeholder="ID" name="txtId" ><br>
        <input  type="submit" value="APROBAR" id="btnAprobar" name="BTNAPROBAR">
        <input type="submit" value="RECHAZAR" id="btnAprobar" name="BTNRECHAZAR">
        </form>
        <br><br>    
        <hr>
        <table class="contenido-tabla">
            <thead> 
                <tr><td>ID Promedio </td><td>Certificado </td>  <td>Evidencia Certificado</td> <td>Status tramite</td> <td>Matricula</td>                    </tr>
            </thead>
                <%
                    //mostrar las solicitudes que no han sido aceptadas xd
                    datos = dao.consultar();
                    
                    for(Promedio p : datos){
                        %>
                        
                        <tr>
                        <tbody> 
                            <td><%= p.getID_modalidad() %></td>
                            <td><%= p.isCertificado()   %></td> 
                            <td><%=p.getEvidencia_certificado()%></td>
                            <td><%= p.isStatus_tramite() %></td>
                            <td><%=p.getMatricula()%></td>
        </tbody>    
                        </tr>
                     
                        
                        <%
                    }
                    
                    
                    
                    %>
                
                
                
                
                
            
            
            
            
            
        </table>
        </center>
        
        
    <center> <br><br>
                    <button type="button" class="botonRojo" name="back" onclick="history.back()">REGRESAR</button> <br>  <br>
                    <br>
          <a class="botonRojo" href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>
    </body>
</center>
    <div id="main-footer">
      <footer


<p> FCAEI UAEM &copy; </p>





</footer>
</div>     