/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.UserDBContext;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 *
 * @author win
 */
public class AddStaffController extends HttpServlet {

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
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();
        String address = request.getParameter("address").trim();
        boolean gender = request.getParameter("gender").equals("male");
        String phone = request.getParameter("phone").trim();
        Date dob = Date.valueOf(request.getParameter("dob"));
        String email = request.getParameter("email").trim();
        String nationality = request.getParameter("nationality").trim();
        String national_id = request.getParameter("national_id").trim();
        String avatar = request.getParameter("avatar");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAddress(address);
        user.setGender(gender);
        user.setPhone_number(phone);
        user.setDob(dob);
        user.setEmail(email);
        user.setNationality(nationality);
        user.setNational_id(national_id);
        user.setAvatar(avatar);
        UserDBContext userDBContext = new UserDBContext();
        try {
            userDBContext.insertStaff(user);
            response.sendRedirect("list");
        } catch (Exception e) {
            response.getWriter().print("insert fail!");
        }

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
