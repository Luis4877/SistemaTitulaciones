<%-- 
    Document   : pre_registro
    Created on : 20/12/2020, 01:13:52 PM
    Author     : Valdez
--%>

<%@page import="sistema.dao.PromedioDAO"%>
<%@page import="sistema.dao.PreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Titulo electronico</title>
    <link rel="stylesheet" type="text/css" href="/sistemaKardex/CSS/pre.css" />
 
       
</head>
<%
    
    //Codigo java para poder verificar como medida de seguridad que no este registrado
          int ID_Per  = (int)session.getAttribute("idpersona");
           PromedioDAO p = new PromedioDAO();
            int ID_Us = (int)session.getAttribute("iduser");
            String nom = (String)session.getAttribute("nombre");
            String apep = (String)session.getAttribute("apellidop"); 
            int matricula = p.buscarMat(ID_Per);
            String apem = (String)session.getAttribute("apellidom");
            String usernombre = (String)session.getAttribute("usuario");
            session.setAttribute("matricula",matricula);
     PreDAO pre = new PreDAO();
 boolean respuesta1 = pre.consultar(matricula);//revisar el pre_registro QUE NO EXISTA tiene que ser true para registrar el certificado
    %>
    
    
    
    
<body>
<% 
if(respuesta1==false){
    %>
       <section class="form " id="main-content">
       
        <h1> Titulo electronico pre-registro</h1>

           <form name="formulario1" action="${pageContext.request.contextPath}/SERVSolicitud" method="POST">
            <select class="sep2" name="txtNivel">
                <option value="NIVEL">Seleccione su nivel academico</option>
                <option value="LICENCIATURA">Licenciatura</option>
            </select>



            <div>
                <select class="sep2" name="txtCarrera">
                <option value="nadaxd">
                <option  value="LICENCIATURA EN INFORMATICA">Licenciado .en informatica</option>
             </select>
               </div>







                <span>Matricula</span>
                <input type="text" required="required" name="txtMatricula" type="text" >


                <span>Lugar de nacimiento</span>
                  <select required id="selectLugarNacimiento" name="txtLugarnacimiento" class="sep2">
                <option value="NADA">Seleccione su lugar de nacimiento</option>
                <option value="MORELOS">MORELOS</option>
                </select>



                <span>Curp</span>
                <input id="curp" type="text" required="true" name="txtCurp"
                    pattern="([A-Z]{4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[A-Z]{3}[0-9A-Z]\d)">








                <span>Nombre</span>
                <input type="text" required="required" name="txtNombres">






                <span> Apellido Paterno </span>
                <input type="text" required="required" name="txtPaterno" >





            <div class="sep">
              <span> Apellido Materno </span>
                <input type="text" required="required" name="txtMaterno">

            </div>


                <span>Sexo</span>
                <select required id="selectLugarNacimiento" name="txtSexo" class="sep2´">
                    <option value="MASCULINO"> MASCULINO </option>
                    <option value="FEMENINO">FEMENINO</option>

                </select>


            <br> <span> Fecha: </span>

                <input type="text" required maxlength="10" placeholder="yyyy/mm/dd" name="txtfecha" id="txtfecha">




                  <span> e-mail</span>
                <input type="email" required="required" name="txtCorreo" type="text">





                <input type="submit" class="botonSubmit" name="btnRegistrar" value="Enviar pre-registro" >
                  <button type="button" class="botonRojo" name="back" onclick="history.back()">REGRESAR</button>

        </form>

    </section>
    
    
    
    
    
    <%
}else{
%>
<h3>TRAMITE FINALIZADO</h3>
    <%
}

%>
 
            <button type="button" name="back" onclick="history.back()">REGRESAR</button> 
</body>

</html>
