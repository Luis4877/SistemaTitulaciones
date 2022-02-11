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

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import sistema.dao.*;


/**
 *
 * @author Valdez
 */

@WebServlet("/Upload") //se pone /Upload por el campo value=Upload en el form(JSP)
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB


public class UploadServlet extends HttpServlet {
   String fileNameUploaded = null; 
   private UploadDAO dato;
    private static final String SAVE_DIR = "images"; //carpeta donde se guardaran los archivos

    public UploadServlet() {
    dato = new UploadDAO();
    
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //el metodo GET recibe todas las llamadas no especificadas en el JSP/HTML como POST 
        String forward="";//almacena la ruta a la que debe redireccionar al usuario
        String action = request.getParameter("action");
        
       

            forward = "alumno.jsp";
            this.redireccionar(forward, request, response);
            
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           String forward="";//almacena la ruta a la que debe redireccionar al usuario
           String action = request.getParameter("action");//obtiene el valor del campo 'action' del JSP
           response.setContentType("text/plain; charset=UTF-8");//establece el tipo de contenido de la respuesta 'text' en unicode UTF8
           PrintWriter out = response.getWriter();
           
           
           
           //obtener la ruta absoluta de la AppWeb
           String appPath = request.getServletContext().getRealPath("");
           //construir la ruta donde se almacenara el archivo
           String savePath = appPath + File.separator + SAVE_DIR;
           
           /****** crear el directorio images en caso de que no exista *******/
           File fileSaveDir = new File(savePath);
           if (!fileSaveDir.exists()) {
               fileSaveDir.mkdir();
           }
           
           for (Part part : request.getParts()) {
               String fileName = extractFileName(part);
               // refines the fileName in case it is an absolute path
               fileName = new File(fileName).getName();
               part.write(savePath + File.separator + fileName);
               fileNameUploaded = fileName;
           }
           
           //fusionar el nombre de la carpeta + nombre-archivo
           String nombreArchivo = SAVE_DIR + "/" + fileNameUploaded;
           
           dato.subirDocumentos(nombreArchivo,(int) request.getSession().getAttribute("matricula"));
           
           
           request.setAttribute("message", "Upload has been done successfully!  " + savePath + "/" +fileNameUploaded);
           forward = "alumno.jsp";
           this.redireccionar(forward, request, response);
       } catch (SQLException ex) {
           Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /*** metodo que extrae el nombre del archivo del header HTTP content-disposition ***/
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    public void redireccionar(String forward,HttpServletRequest request,HttpServletResponse response) 
            throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }    


    /*** metodo que extrae el nombre del archivo del header HTTP content-disposition ***/
   

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
