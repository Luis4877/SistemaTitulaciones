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
import sistema.dao.CertificadoDAO;

/**
 *
 * @author Valdez
 */
public class ControlCert extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      //    response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       CertificadoDAO c = new CertificadoDAO();
       String respuesta="ok";
             RequestDispatcher rd =null;
       try {
            if(request.getParameter("btnAprobar") !=null){
                c.aprobar(Integer.parseInt(request.getParameter("txtMatricula")),request.getParameter("txtObservaciones"));
            }
            if(request.getParameter("btnNoAprobar") != null){
            c.noAprobar(Integer.parseInt(request.getParameter("txtMatricula")),request.getParameter("txtObservaciones"));
            }
          
            
            
            request.setAttribute("respuesta",respuesta);
             
            
            
            
            
            rd = request.getRequestDispatcher("/Titulaciones/Admin/rev_cert.jsp");
        } catch (Exception e) {
        }
             rd.forward(request, response);
        }
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
