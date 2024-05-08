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

/**
 *
 * @author User
 */
public class VehicleUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VehicleDBContext DB = new VehicleDBContext();
        Vehicle vehicle = DB.get(id);
        request.setAttribute("vehicle", vehicle);
        request.getRequestDispatcher("../vehicle/update.jsp").forward(request, response);
    }

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
        v.setVehicle_id(Integer.parseInt(request.getParameter("id")));

        VehicleDBContext DB = new VehicleDBContext();
        DB.update(v);
        
        response.sendRedirect("list");
        response.getWriter().println("Created a Restaurant successful!");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
