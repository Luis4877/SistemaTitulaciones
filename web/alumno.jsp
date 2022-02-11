<%-- 
    Document   : alumno
    Created on : 20/12/2020, 01:04:55 PM
    Author     : Valdez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="sistema.dao.*" %>
<%@page import="sistema.*" %>
<%@page  import="sistema.controller.*" %>
<%@page import="sistema.model.*" %>


<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="/sistemaKardex/css/table.css"/>
        <title>Alumnos</title>
        <link rel="stylesheet" href="/sistemaKardex/CSS/alumno.css">
    </head>
    
   
  


    
    
   

    <body onload="verificar()">
  
        <h1>Bienvenido alumno</h1>
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
        boolean respuesta0 = pre.consultar1(matricula);
        boolean respuesta1 = pre.consultar(matricula);//revisar el pre_registro QUE NO EXISTA tiene que ser true para registrar el certificado
        boolean respuesta2 = certificado.revisarCertificado(matricula);//revisar el certificado DEBE SER TRUE PARA PODER TITULARSE DE ALGUNA MANERA
        boolean respuesta3 = diplomado.revisarDiplomado(matricula);//revisar que no exista la titulacion por diplomado
        boolean respuesta4 = p.revisarPromedio(matricula);//revisar que no exista la titulacion por promedio
        boolean rest = revisar.revisar(matricula);//revisamos las restricciones minimas para titularse
        boolean respuesta5=certificado.revisarCert(matricula);
        %>
        <br>
   <center>
       <table>
           <thead>
               <tr>
              
                  
               
                   <td>Nombre</td>
                   <td>A.Paterno</td>
                   <td>A.Materno</td>
                   <td>MATRICULA</td>
               </tr>


           </thead>
           <tr>
           <tbody>

            
            
               <td><%out.println(nom);%></td>
               <td><%out.println(apep);%> </td>
               <td><% out.println(apem);%></td>
               <td><%out.println(matricula);%></td>




           </tbody>
            </tr>


       </table>
                   </center>
       <BR>
       
       <%
           if(rest==true){
               %>
               <center>
                    <section id="main-content">
                        <h3>¡FELICIDADES YA PUEDES INICIAR EL PROCESO DE FIN DE CARRERA!</h3>
                         <a href="${pageContext.request.contextPath}/Titulaciones/Alumno/Reporte1.jsp">REPORTES LIBERADOS</a><BR> <br><br>
            <br><br>
              <%-- 
               DIV PARA LA PARTE DE PRE-REGISTRO,SINO ESTA REGISTRADO ENTONCES APARECE EL BOTON PARA REGISTRARSE
               --%>
           <% 
           if(respuesta1==false){
               %>
                <div>
              <a href="${pageContext.request.contextPath}/Titulaciones/Alumno/pre_registro.jsp">PRE-REGISTRO</a><BR>
                   <BR><BR>
          
            </div>
               <%
           }
//restriccion para no poder registrar mas de 1 de cada uno y pasar al siguiente nivel
           if(respuesta0==true && respuesta5==false){
%>


                    <BR>
                      <h3>Felicidades,ya puedes obtener tu certificado</h3>
                       <a href="${pageContext.request.contextPath}/Titulaciones/Alumno/Certificado.jsp">Obtener Certificado </a>



            <%
}
//restriccion para evitar que registre 2 veces alguna partexd

    if(respuesta2==true && respuesta3==false && respuesta4==false ){
%>
<div>
    <h3>¡TU CERTIFICADO FUE APROBADO,ESCOGE UNA FORMA DE TITULARTE!</h3>
    <a href="${pageContext.request.contextPath}/Titulaciones/Alumno/Diplomado.jsp">TITULACION POR DIPLOMADO</a><BR><BR><BR><BR>
    <a name="probar" id="probar"onclick="verificar(this)" href="${pageContext.request.contextPath}/Titulaciones/Alumno/promedio.jsp">TITULACION POR PROMEDIO</a>
</div>



                       <%
}else{
%>
                       

                       <%
}




           %>
              
                        
                        
                        
                        
                 </section>
           <a class="botonRojo" href="${pageContext.request.contextPath}/moduloLogin/logout.jsp">Salir</a>
              </center>
               <%
           }
           %>
    




         
       </body>
</html>