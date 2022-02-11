/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sistema.dao.PreDAO;
import sistema.model.Pre_registro;

/**
 *
 * @author Valdez
 */
public class SERVSolicitud extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           //AQUI DEBEMOS RECIBIR LOS DATOS Y MANDARLOS AL DAO CORRESPONDIENTE
           PreDAO pre = new PreDAO();
           int mat;
           Pre_registro dato = new Pre_registro();
           String respuesta="todo OK";
            RequestDispatcher rd =null;
            try {
                if(request.getParameter("btnRegistrar") !=null){
                    //llenar el objeto de tipo pre_registro para luego mandar todo el objeto xd
                    dato.setNivel_academico(request.getParameter("txtNivel"));
                    dato.setCarrera(request.getParameter("txtCarrera"));
                    dato.setMatricula(Integer.parseInt(request.getParameter("txtMatricula")));
                    dato.setNacimiento(request.getParameter("txtLugarnacimiento"));
                    dato.setCurp(request.getParameter("txtCurp"));
                    dato.setNombre(request.getParameter("txtNombres"));
                    dato.setPaterno(request.getParameter("txtPaterno"));
                    dato.setMaterno(request.getParameter("txtMaterno"));
                    dato.setSexo(request.getParameter("txtSexo"));
                    dato.setFecha_nacimiento(request.getParameter("txtfecha"));
                    
                    dato.setCorreo(request.getParameter("txtCorreo"));
                    pre.mandar(dato);
                      request.setAttribute("respuesta",respuesta);
              
                   rd = request.getRequestDispatcher("alumno.jsp");rd.forward(request, response);
                }
                
                
                
                if(request.getParameter("btnAprobar")!=null){
                    mat  = (Integer.parseInt(request.getParameter("txtMatricula")));
                   pre.aprobar(mat);
                     request.setAttribute("respuesta",respuesta);
                       rd = request.getRequestDispatcher("Titulaciones/Admin/rev_pre.jsp");rd.forward(request, response);
                }
                
             
            } catch (Exception e) {
                
            }
           
           
            
           
           
        }
        
        
        
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
