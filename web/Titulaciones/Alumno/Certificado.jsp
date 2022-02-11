<%-- 
    Document   : certificado
    Created on : 20/12/2020, 01:14:06 PM
    Author     : Valdez
--%>

<%@page import="sistema.dao.CertificadoDAO"%>
<%@page import="sistema.dao.restriccionesDAO"%>
<%@page import="sistema.dao.PromedioDAO"%>
<%@page import="sistema.dao.PromedioDAO"%>
<%@page import="sistema.dao.DiplomadoDAO"%>
<%@page import="sistema.dao.PreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO DE DOCUMENTOS PARA EL CERTIFICADO</title>
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
      <li><a href="${pageContext.request.contextPath}/Titulaciones/Alumno/pre_registro.jsp">Pre registro</a></li>
      <li><a href="#">Promedio</a></li>
      <li><a href="#">Diploma</a></li>
    </ul>
  </nav>

    </header>
<%
    //Codigo java para poder restringir que entre sin tener su pre-registro
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
        boolean respuesta0 = pre.consultar1(matricula);//ocupamos esta xd TRUE
        boolean respuesta1 = certificado.consult(matricula);//DEBE SER FALSE
    
    %>

    </section>

    <body>
  <h1>

    Debes subir todos los documentos

  </h1>
    <%
    if(respuesta0==true && respuesta1==false){
    %>
  
<section id="main-content">



    <div style="text-align:center;">

      <form method="post" action="${pageContext.request.contextPath}/MultipleUpload" enctype="multipart/form-data" name="action">
        <p> 4 fotos tamaño infantil: </p> <input type="file" name="file" size="60" required="" />
        <p> Evidencia del recibo de pago: </p> <input type="file" name="file" size="60" required="" />
        <p> Constancia No adeudo a biblioteca: </p> <input type="file" name="file" size="60" required="" />
        <p> Constancia No adeudo a contabilidad: </p> <input type="file" name="file" size="60" required="" />
        <p> Acta de Nacimiento: </p> <input type="file" name="file" size="60" required="" />



        <br><br>
        <input class="botonSubmit" type="submit" class="enviar" value="Subir Documentos" /><br><br>


      </form>


    </div>
        <center>    <a href="${pageContext.request.contextPath}/Titulaciones/Alumno/requisitos.jsp" class="btnRequis" value="" name="">REQUISITOS DE LOS DOCUMENTOS</a><br>
        <br>  <button class="botonRojo" type="button" name="back" onclick="history.back()">REGRESAR</button>
        </center>


            </section>

    
    
    
    <%
        }else{
%>

<h3>Tramite FINALIZADO</h3>
    <%
}
    
    %>
        
        
    





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