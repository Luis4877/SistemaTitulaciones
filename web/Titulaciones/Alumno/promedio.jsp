<%-- 
    Document   : promedio
    Created on : 20/12/2020, 01:14:15 PM
    Author     : Valdez
--%>

<%@page import="sistema.dao.PreDAO"%>
<%@page import="sistema.dao.CertificadoDAO"%>
<%@page import="sistema.dao.restriccionesDAO"%>
<%@page import="sistema.dao.DiplomadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="sistema.dao.PromedioDAO"%>
<%@page import="sistema.dao.PromedioDAO" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
                  <link rel="stylesheet" type="text/css" href="/sistemaKardex/CSS/promedio.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
              PreDAO pre = new PreDAO();
            PromedioDAO obj = new PromedioDAO();
        request.getAttribute("message");
             DiplomadoDAO diplomado = new DiplomadoDAO();
                  restriccionesDAO revisar = new restriccionesDAO();
           CertificadoDAO certificado = new CertificadoDAO();
           
             int ID_Per  = (int)session.getAttribute("idpersona");
            int matricula = obj.buscarMat(ID_Per);
            double  promedioFinal = obj.obtenerGeneral(matricula);
              String nom = (String)session.getAttribute("nombre");
            String apep = (String)session.getAttribute("apellidop");
            String apem = (String)session.getAttribute("apellidom");

            session.setAttribute("matricula",matricula);
            boolean respuesta0 = pre.consultar1(matricula);//ocupamos este para que se vea que esta aprobado el pre_registro
        boolean respuesta1 = certificado.revisarCertificado(matricula);//revisar el certificado DEBE SER TRUE PARA PODER TITULARSE DE ALGUNA MANERA
        boolean respuesta2 = diplomado.revisarDiplomado(matricula);//revisar que no exista la titulacion por diplomado
        boolean respuesta3 = obj.revisarPromedio(matricula);//revisar que no exista la titulacion por promedio
        boolean respuesta4 = revisar.revisar(matricula);//revisamos las restricciones minimas para titularse

        /*
        TRUE
        TRUE
        FALSE
        FALSE
        TRUE
        */
            %>
    <center>      
        <h2>Bienvenido : <%out.println(nom);%> <%out.println(apep);%> <%out.println(apem);%>  </h2>
            </center>  
    
    <table class="contenido-tabla"  > 
        <thead> 
        
        <td>ID PERSONA</td>
        <td>MATRICUAL</td>
        <td>PROMEDIO GENERAL</td>
        
        </thead>
        <tr>  
        <tbody> 
            <td> <%out.println(ID_Per);%></td>
            <td>   <%out.println(matricula);  %>  </td>
            <td><%out.println(promedioFinal);   %>    </td>
        </tbody>
        </tr>
    
    
    
    </table>
        
        <%
          if(respuesta0==true && respuesta1==true && respuesta2==false && respuesta3==false && respuesta4==true){
      
        %>
        <section id="main-content">
          <form method="POST" action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data">
           Prueba del certificado: <input required="" type="file" name="file" size="20" /><br />
            <br /> <input type="submit" value="subir" />

        </form><hr>
        <button type="button" name="back" onclick="history.back()">REGRESAR</button> 
                   </section>
           <% 
               } 
           %>
    </body>
    <center>    
        <br><br>
     <a class="botonRojo" href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>
    </center>
      <div id="main-footer">
      <footer>


      <p> FCAEI UAEM &copy; </p>



      </footer>
</div>
</html>
