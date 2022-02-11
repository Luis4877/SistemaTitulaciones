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


//Clases importar
import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;

//Imports para subir multiples archivos

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
//librerias de Apache Commons Upload para subir multiples arhivos
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sistema.dao.DiplomadoDAO;
import sistema.model.Diplomado;
/**
 *
 * @author Valdez
 */
@WebServlet(name ="SERVDiplomado", urlPatterns = {"/SERVDiplomado"})
public class SERVDiplomado extends HttpServlet {
    String fileNameUploaded = null;//almacenar el nombre del archivo 
    String nombreArchivo=null;//almacena nombre temporalmente
    private static final String UPLOAD_DIRECTORY = "images";//carpeta donde se guardaran los archivos    
    private static final int THRESHOLD_SIZE     = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
    
    private DiplomadoDAO diplo = new DiplomadoDAO();
    private Diplomado mandar = new Diplomado();
      private List<String> lista = new ArrayList<>();

    public SERVDiplomado() {
    super();
    diplo = new  DiplomadoDAO();//CREAR OBJETO TIPO DIPLOMADO
            
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Request: La solicitud no contiene datos de upload");
            writer.flush();
            return;
        }
      
            // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
         
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
         
        // constructs the directory path to store upload file
        String uploadPath = getServletContext().getRealPath("")
            + File.separator + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //AQUI SE SACA EL NOMBRE DEL ARCHIVO Y AQUI DEBEMOS HACER EL OBJETO
        try {
               
            
            
            // parses the request's content to extract file data
            List formItems = upload.parseRequest(request);
            Iterator iter = formItems.iterator();
            //guardamos los nombres en el List de tipo String
             while (iter.hasNext()) {
                
                
                
                FileItem item = (FileItem) iter.next();
                // processes only fields that are not form fields
               if (!item.isFormField()) {
                String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;                    
                    fileNameUploaded = fileName;
                    File storeFile = new File(filePath);
                    
                    //Almacenar PATH en la BD
                    //fusionar el nombre de la carpeta + nombre-archivo                    
                    nombreArchivo = UPLOAD_DIRECTORY + "/" + fileNameUploaded;    
                    
                    
                    
                   lista.add(nombreArchivo); //LINEA IMPORTANTE DONDE SE AGREGA EN LA LISTA DINAMICA
                   /*
                   
                   Se mandan en orden para evitar confuncion 
                   empieza desde 0 hasta N
                   */
                    
                    // saves the file on disk
                    item.write(storeFile);
                    
                }
            }
             //aqui debemos llenar el objeto tipo diplomado y mandarlo xd
              int f = (Integer)request.getSession().getAttribute("matricula");
              mandar.setCertificado(0);
              mandar.setEvidencia_certificado(lista.get(0));//evidencia certificado primer archivo
              mandar.setBoletaOficial(1);
              mandar.setEvidenciaBoletaOficial(lista.get(1));//segundo archivo
              mandar.setStatus("EN PROCESO");
              mandar.setObservaciones("NINGUNA");
              mandar.setFotos(1);
              mandar.setEvidencia_fotos(lista.get(2));//tercer archivo
              mandar.setModalidad("DIPLOMADO");
              mandar.setStatus_tramite(0);
              
              diplo.insertar(mandar,f);
              request.setAttribute("message", "Upload has been done successfully!" + fileNameUploaded);
             
        } catch (Exception ex) {
              request.setAttribute("message", "There was an error: " + ex.getMessage());
        }
    
    
  getServletContext().getRequestDispatcher("/alumno.jsp").forward(request, response);
  
    
    }
    
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
