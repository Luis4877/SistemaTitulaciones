<%-- 
    Document   : Diplomado
    Created on : 23/12/2020, 04:17:38 AM
    Author     : Valdez
--%>

<%@page import="sistema.dao.DiplomadoDAO"%>
<%@page import="sistema.dao.CertificadoDAO"%>
<%@page import="sistema.dao.restriccionesDAO"%>
<%@page import="sistema.dao.PreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page   import="sistema.dao.PromedioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO DE DOCUMENTOS PARA LA TITULACION POR DIPLOMADO</title>
        <link rel="stylesheet" href="/sistemaKardex/CSS/certificado.css">

    </head>
    <section id="main-header">



    <header>

      <nav class="navegacion">
    <ul class="menu">
      <li><a href="#">Reportes</a>
        <ul class="submenu">
        
        </ul>
      </li>
        <li><a href="${pageContext.request.contextPath}/Titulaciones/Alumno/pre_registro.jsp">PRE_REGISTRO</a></li>
      <LI><a href="${pageContext.request.contextPath}/Titulaciones/Alumno/Certificado.jsp">CERTIFICADO</a></LI>
    
      <li><a href="${pageContext.request.contextPath}/Titulaciones/Alumno/promedio.jsp">Promedio</a></li>
      <li><a href="${pageContext.request.contextPath}/Titulaciones/Alumno/Diplomado.jsp">DIPLOMADO</a></li>
      
    </ul>
  </nav>

    </header>
    </section>
  
    <body>
    
        <h1>registro de documentos para el DIPLOMADO</h1><BR><BR><BR>
      
        
        
        
        
        <%
 
int f;

  PreDAO pre = new PreDAO();
            PromedioDAO p = new PromedioDAO();
            DiplomadoDAO diplomado = new DiplomadoDAO();

           restriccionesDAO revisar = new restriccionesDAO();
           CertificadoDAO certificado = new CertificadoDAO();
    
         
            int ID_Per  = (int)session.getAttribute("idpersona");
            int ID_Us = (int)session.getAttribute("iduser");
            String nom = (String)session.getAttribute("nombre");
            String apep = (String)session.getAttribute("apellidop"); 
            int matricula = p.buscarMat(ID_Per);
            String apem = (String)session.getAttribute("apellidom");
            String usernombre = (String)session.getAttribute("usuario");
            session.setAttribute("matricula",matricula);
      // boolean crs=cr.revisarCert(matricula);
       //objeto para hacer el reporte xd
      
        // pz=prd.consultar(matricula);
        boolean respuesta0 = pre.consultar1(matricula);//ocupamos este para que se vea que esta aprobado el pre_registro
        boolean respuesta1 = certificado.revisarCertificado(matricula);//revisar el certificado DEBE SER TRUE PARA PODER TITULARSE DE ALGUNA MANERA
        boolean respuesta2 = diplomado.revisarDiplomado(matricula);//revisar que no exista la titulacion por diplomado
        boolean respuesta3 = p.revisarPromedio(matricula);//revisar que no exista la titulacion por promedio
        boolean respuesta4 = revisar.revisar(matricula);//revisamos las restricciones minimas para titularse

        /*
        TRUE
        TRUE
        FALSE
        FALSE
        TRUE
        */

      
%>

     
     
     
            <div style="text-align:center;">
   <div class="formulario">
       <%
       if(respuesta0==true && respuesta1==true && respuesta2==false && respuesta3==false && respuesta4==true){
           %>
       
        
    
      <form method="post" action="${pageContext.request.contextPath}/SERVDiplomado" enctype="multipart/form-data" name="action">
        <p> EVIDENCIA CERTIFICADO: </p> <input type="file" name="file" size="60" required="" />
        <p> Boleta Oficial: </p> <input type="file" name="file" size="60" required="" />
        <p> Fotos tamaño diploma: </p> <input type="file" name="file" size="60" required="" />
       



        <br><br>
        <input type="submit" class="btnRequis" value="Subir" /><br><br>

     
      </form>
  

    </div>
   
       
       <%
           
  }
       
       %>
       
       <center>
           
           <br>  <button class="botonRojo" type="button" name="back" onclick="history.back()">REGRESAR</button>
           
       </center>
   </div>



    </body> <center>    
        <br><br>
     <a class="botonRojo" href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>
    </center>
   
  <div id="main-footer">
              <footer


        <p> FCAEI UAEM &copy; </p>





      </footer>
    </div>
</html>
