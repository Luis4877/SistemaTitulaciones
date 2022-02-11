/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;//objeto para generar respuestas en texto
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//importar las siguientes
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;//objeto para generar respuestas binarias, en este caso el reporte es binario
import javax.servlet.http.Part;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletResponse;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//importar las clases de JasperReports
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JREmptyDataSource; 
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JasperExportManager; 
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.*;
//para almacenar logs
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sistema.dao.PreDAO;
import sistema.model.Pre_registro; 
import sistema.util.Database;
     
/**
 *
 * @author Valdez
 */

@WebServlet(name = "ReportsController", urlPatterns = {"/ReportsController"})
public class ReportsController extends HttpServlet {

    private static final Log logger = LogFactory.getLog(ReportsController.class);

    public ReportsController() {
        super();
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
      
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int mat=0;
            
            //traemos informacion del dao para pasar los parametros al reporte xd
            
        String action = request.getParameter("action");
            ServletContext context = this.getServletConfig().getServletContext();
            // get a database connection
            Connection conn = Database.getConnection();
            response.setContentType("application/pdf");
            
         if(action.equalsIgnoreCase("descargar"))
            {
                try{
       //        int ID_Per  = (int)session.getAttribute("idpersona");
        int matricula = Integer.parseInt(request.getParameter("matricula"));
       
                 //   int idcategoria = Integer.parseInt(request.getParameter("categoryid"));
                    String jasperFilePath = context.getRealPath("REPORTES/PEDRO.jasper");//reportesUsuarios/categories.jasper"); //request.getSession().getServletContext().getRealPath("/reportesUsuarios/Usuarios.jrxml");
                    String jrxmlFilePath = context.getRealPath("REPORTES/PEDRO.jrxml");//reportesUsuarios/categories.jrxml");
                    File reportFile = new File(jasperFilePath);
                    // create a map of parameters to pass to the report.
               //    matricula= Integer.parseInt(request.getParameter("matricula"));
                    Map<String,Object> parametros = new HashMap<String,Object>();
                    parametros.put("MATRICULA",Integer.valueOf(matricula));//error aqui xd
               

                    // If compiled file is not found, then compile XML template
                    if (!reportFile.exists()) 
                    {
                        // load JasperDesign from XML and compile it into JasperReport
                        JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFilePath);
                        // load JasperReport from .jasper file
                        JasperCompileManager.compileReportToFile(jasperDesign, jasperFilePath);
                    }
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
                    // fill JasperPrint using fillReport() method
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
                    if(jasperPrint != null)
                    {
                        //response.setHeader("Content-Disposition","filename=abonos"+fechaInicio+"-"+fechaFin+".pdf;");
                        response.setHeader("Content-Disposition","inline; filename=reporte.pdf");
                        response.setContentType("application/pdf");
                        ServletOutputStream outputStream = response.getOutputStream();  
                        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);        
                        outputStream.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();                
                }
            } else if(action.equalsIgnoreCase("descargar1")){
                            try{
       //        int ID_Per  = (int)session.getAttribute("idpersona");
       int matricula = Integer.parseInt(request.getParameter("matricula"));
                 //   int idcategoria = Integer.parseInt(request.getParameter("categoryid"));
                    String jasperFilePath = context.getRealPath("REPORTES/CERTIFICADOS.jasper");//reportesUsuarios/categories.jasper"); //request.getSession().getServletContext().getRealPath("/reportesUsuarios/Usuarios.jrxml");
                    String jrxmlFilePath = context.getRealPath("REPORTES/CERTIFICADOS.jrxml");//reportesUsuarios/categories.jrxml");
                    File reportFile = new File(jasperFilePath);
                    // create a map of parameters to pass to the report.
               //    matricula= Integer.parseInt(request.getParameter("matricula"));
                    Map<String,Object> parametros = new HashMap<String,Object>();
                    parametros.put("MATRICULAS",Integer.valueOf(matricula));//error aqui xd
               

                    // If compiled file is not found, then compile XML template
                    if (!reportFile.exists()) 
                    {
                        // load JasperDesign from XML and compile it into JasperReport
                        JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFilePath);
                        // load JasperReport from .jasper file
                        JasperCompileManager.compileReportToFile(jasperDesign, jasperFilePath);
                    }
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
                    // fill JasperPrint using fillReport() method
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
                    if(jasperPrint != null)
                    {
                        //response.setHeader("Content-Disposition","filename=abonos"+fechaInicio+"-"+fechaFin+".pdf;");
                        response.setHeader("Content-Disposition","inline; filename=reportes.pdf");
                        response.setContentType("application/pdf");
                        ServletOutputStream outputStream = response.getOutputStream();  
                        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);        
                        outputStream.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();                
                }
        
        
        
            }else if(action.equalsIgnoreCase("descargas")){
                 try{
       //        int ID_Per  = (int)session.getAttribute("idpersona");
        int matricula = Integer.parseInt(request.getParameter("matricula"));
       
                 //   int idcategoria = Integer.parseInt(request.getParameter("categoryid"));
                    String jasperFilePath = context.getRealPath("REPORTES/FINALE.jasper");//reportesUsuarios/categories.jasper"); //request.getSession().getServletContext().getRealPath("/reportesUsuarios/Usuarios.jrxml");
                    String jrxmlFilePath = context.getRealPath("REPORTES/FINALE.jrxml");//reportesUsuarios/categories.jrxml");
                    File reportFile = new File(jasperFilePath);
                    // create a map of parameters to pass to the report.
               //    matricula= Integer.parseInt(request.getParameter("matricula"));
                    Map<String,Object> parametros = new HashMap<String,Object>();
                    parametros.put("MATRICULA1",Integer.valueOf(matricula));//error aqui xd
               

                    // If compiled file is not found, then compile XML template
                    if (!reportFile.exists()) 
                    {
                        // load JasperDesign from XML and compile it into JasperReport
                        JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFilePath);
                        // load JasperReport from .jasper file
                        JasperCompileManager.compileReportToFile(jasperDesign, jasperFilePath);
                    }
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
                    // fill JasperPrint using fillReport() method
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
                    if(jasperPrint != null)
                    {
                        //response.setHeader("Content-Disposition","filename=abonos"+fechaInicio+"-"+fechaFin+".pdf;");
                        response.setHeader("Content-Disposition","inline; filename=reporte.pdf");
                        response.setContentType("application/pdf");
                        ServletOutputStream outputStream = response.getOutputStream();  
                        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);        
                        outputStream.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();                
                }
                
            }
    
    
    
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
