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
import sistema.dao.PromedioDAO;
import sistema.model.Persona;


/**
 *
 * @author Valdez
 */
public class controlProm extends HttpServlet {
    Persona x = new Persona();
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
        String respuesta="ok";
       PromedioDAO p = new PromedioDAO();
    //   String forward="";//almacena la ruta a la que debe redireccionar al usuario
       RequestDispatcher rd =null;
        try {
            if(request.getParameter("BTNAPROBAR") !=null){
                p.aprobar(Integer.parseInt(request.getParameter("txtId")));
                
            }else if(request.getParameter("BTNRECHAZAR") !=null){
                p.aprobar(Integer.parseInt(request.getParameter("txtId")));
                
            }
            
            
             request.setAttribute("respuesta",respuesta);
                rd = request.getRequestDispatcher("/Titulaciones/Admin/rev_prom.jsp");
        } catch (Exception e) {
        }
             rd.forward(request, response);
        
        //aqui se hara la revision del promedio y todo eso xd
        
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
