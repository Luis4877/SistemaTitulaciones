<%-- 
    Document   : Reporte1
    Created on : 20/12/2020, 09:01:23 PM
    Author     : Valdez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page  import="sistema.dao.*" %>
<%@page import="sistema.*" %>
<%@page  import="sistema.controller.*" %>
<%@page import="sistema.model.*" %>
<!DOCTYPE html>
<html>
     <head>
    <meta charset="utf-8">
    <title>Reportes</title>
    <link rel="stylesheet" href="sistemaKardex/CSS/reportes.css">
  </head>
    <body>
           <%
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
        boolean respuesta3 = p.revisarPromedios(matricula);//revisar que no exista la titulacion por promedio
        boolean respuesta4 = revisar.revisar(matricula);//revisamos las restricciones minimas para titularse

        /*
        TRUE
        TRUE
        FALSE
        FALSE
        TRUE
        */

        //error en el primer reporte guapo xd
        %>
        <% 
        if(respuesta0==true){
            
       
        
        
        %>
        <div> 
         <form name="frmReportexd" action="${pageContext.request.contextPath}/ReportsController">
        <input type="hidden" value="descargar" class="botonSubmit" name="action">
        
       
        <input type="hidden" name="matricula" value="<%=matricula %>">
        
         <input type="submit" name="Aceptar" class="botonSubmit" value="REPORTE DE PREREGISTRO">
        </form>
        
        </div>
        <%
             }%>
        
             <%
                 if(respuesta1==true){
                     
                 
                 
                 
                 %>
        <div> 
        
           <form name="frmReportexd" action="${pageContext.request.contextPath}/ReportsController">
        <input type="hidden" value="descargar1" name="action">
        
       
        <input type="hidden" name="matricula" value="<%=matricula%>">
        
         <input type="submit" name="Aceptar" value="REPORTE DEL CERTIFICADO">
        </form>
        
        </div>
        <%}%>
        
        <% 
            if(respuesta2==true || respuesta3==true){
            %>
        <div> 
         <form name="frmReportexd" action="${pageContext.request.contextPath}/ReportsController">
        <input type="hidden" value="descargas" class="botonSubmit" name="action">
        
       
        <input type="hidden" name="matricula" value="<%=matricula %>">
        
         <input type="submit" name="Aceptar" class="botonSubmit" value="TITULO">
        </form>
        </div>
        <%}%>
        
    </body>
</html>
