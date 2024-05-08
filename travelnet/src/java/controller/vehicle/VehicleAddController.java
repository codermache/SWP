/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.vehicle;

import dao.VehicleDBContext;
import entity.Vehicle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author User
 */
public class VehicleAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../vehicle/add.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");  // search tieng viet
        
        Vehicle v = new Vehicle();
        v.setVehicle_name(request.getParameter("name"));
        v.setVehicle_address(request.getParameter("address"));
        v.setVehicle_supplier(request.getParameter("supplier"));
        v.setV_email(request.getParameter("email"));
        v.setV_phonenumber(request.getParameter("phone"));
        v.setV_description(request.getParameter("description"));
        v.setV_rate(Integer.parseInt(request.getParameter("rate")));

        VehicleDBContext DB = new VehicleDBContext();
        DB.insert(v);
        response.getWriter().println("Created a Restaurant successful!");
        response.sendRedirect("list");
        
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
