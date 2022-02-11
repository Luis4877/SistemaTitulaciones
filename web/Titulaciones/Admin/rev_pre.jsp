<%-- 
    Document   : rev_pre
    Created on : 20/12/2020, 01:14:48 PM
    Author     : Valdez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sistema.dao.PreDAO"%>
<%@page import="sistema.model.Pre_registro"%>
<%@page import ="sistema.util.Database" %>

<%@page  import="java.util.*" %>
<%@page  %>


<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revision del PRE_REGISTRO</title>
        <link rel="stylesheet" href="/sistemaKardex/CSS/pre_registro.css">
    </head>
    
    
    
    <body>
        <%
            PreDAO p = new PreDAO();
            List<Pre_registro>  datos = new ArrayList();
         
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
                          <div>
                              
                               <form method="POST" name="APROBAR" action="${pageContext.request.contextPath}/SERVSolicitud" > 
               <label>APROBAR USUARIO POR MATRICULA</label><br>
               <label> Matricula:</label>
               <input type="text" name="txtMatricula" placeholder="MATRICULA" required=""><BR>
               
               <input type="submit" name="btnAprobar" value="APROBAR">

           
           </form>
                              
                              
                              
                              
                              
                              
                              
                          </div>              
                         
        
        
        
        <table>
            <thead>
                <tr>
                    <td>NIVEL ACADEMICO</td>
                       <td>CARRERA</td>
                          <td>MATRICULA</td>
                             <td> LUGAR NACIMIENTO</td>
                                <td>CURP</td>
                                   <td>NOMBRE</td>
                                   <Td>A.Paterno</Td>
                                   <td>A.Materno</td>
                                   <td>SEXO</td>
                                   <TD>Fecha Nacimiento</TD>
                                   <td>Correo</td>
                               
                    
                    
                    
                </tr>
                
                
                
            </thead>
             <%
                    //mostrar las solicitudes que no han sido aceptadas xd
                //    datos = p.
                    datos = p.consult();
                    for(Pre_registro o : datos){
                        %>
                        <tr>
                        <tbody>
                        <td><%= o.getNivel_academico()%></td>
                        <td><%= o.getCarrera()%></td>
                        <td><%=o.getMatricula() %></td>
                              <td><%=o.getNacimiento() %></td>
                                    <td><%=o.getCurp() %></td>
                                          <td><%=o.getNombre() %></td>
                                                <td><%=o.getPaterno() %></td>
                                                      <td><%=o.getMaterno() %></td>
                                                            <td><%=o.getSexo() %></td>
                                                                  <td><%=o.getFecha_nacimiento()%></td>
                                                                        <td><%=o.getCorreo()%></td>
                                                                       
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
</html>
