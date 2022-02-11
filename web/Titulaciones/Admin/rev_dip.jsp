<%-- 
    Document   : rev_dip
    Created on : 23/12/2020, 04:28:34 AM
    Author     : Valdez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sistema.dao.DiplomadoDAO"%>
<%@page  import="sistema.model.Diplomado"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REVISION DIPLOMADO </title>
           <link rel="stylesheet" type="text/css" href="/sistemaKardex/CSS/certificado.css"/>
    </head>
    
    
    
    <body>
        <h1>REVISION DE DIPLOMADO</h1>
         <div id="main-header">
        <nav class="navegacion">
      <ul class="menu">
        <li><a href="#">Revision</a>
          <ul class="submenu">
            <li><a href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a></li>
     <li> <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_pre.jsp">Revisar PreRegistro</a> </li>  
    <li>  <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_cert.jsp">Revisar Certificado</a>   </li> 
    <li>   <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_prom.jsp">Revisar Titulacion Por promedio</a>    </li> 
     <li>   <a href="${pageContext.request.contextPath}/Titulaciones/Admin/rev_dip.jsp">Revisar Diplomado</a> </li> 
          </ul>
        </li>
      </ul>
    </nav>

      </div>
        <% 
        //JSP por default del usuario con base en el campo url de la BD
            //Crear variables locales y asignarles los valores almacenados en los atributos de la sesion
            int ID_Per  = (int)session.getAttribute("idpersona");
            int ID_Us = (int)session.getAttribute("iduser");
            String nom = (String)session.getAttribute("nombre");
            String apep = (String)session.getAttribute("apellidop");
            String apem = (String)session.getAttribute("apellidom");
      //      String relativa="C:/Users/Valdez/Documents/istemaKardex/build/web/images";
            //la variable usernombre es para mantener el username durante la navegacion
            String usernombre = (String)session.getAttribute("usuario");
            DiplomadoDAO dao = new DiplomadoDAO();
            List<Diplomado>  datos = new ArrayList();
            

        
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
                   
            
         </table>  </center> 
         
          <section id="main-content">
        <form method="POST" name="APROBAR" action="${pageContext.request.contextPath}/ControlDiplo" > 
               <label>APROBAR USUARIO POR MATRICULA</label><br>
               <label> Matricula:</label>
               <input type="text" name="txtMatricula" placeholder="MATRICULA" required=""><BR>
               <label>OBSERVACIONES</label>
               <input type="text" name="txtObservaciones" placeholder="AGREGAR OBSERVACION" required="  "><BR><BR>    
               <input type="submit" name="btnAprobar" value="APROBAR">
               <input type="submit" name="btnNoAprobar" value="RECHAZAR">
           
           </form>
          </section>
               <center>     
               <table class="contenido-tabla">
                   <thead> 
                   
                   <tr> 
                       <td>Matricula</td>
                       <td>Certificado</td>
                       <td>Evidencia</td>
                       <td>Boleta oficial</td>
                       <td>Evidencia</td>
                       <td>Fotos diploma</td>
                       <td>Evidencia</td>
                       <td>Status</td>
                   </tr>
                   </thead>
                   <%
                       datos = dao.consultar();
                       
                       for(Diplomado c : datos){
                       
                       
                    %><tbody>
                       <tr>
                           <td><%= c.getMatricula()%></td>
                         <td><%= c.getCertificado() %></td>
                         <td><%= c.getEvidencia_certificado() %></td>
                         <td><%= c.getBoletaOficial() %></td>
                         <td><%= c.getEvidenciaBoletaOficial() %></td>
                         <td><%= c.getFotos() %></td>
                         <td><%= c.getEvidencia_fotos()  %></td>
                         <td><%= c.getStatus() %></td>
                         
                         
                           
                           
                       </tr> </tbody>
                        
                <%
            }
            
            %>
                   
               </table></center>


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
   
</html>
