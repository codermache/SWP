/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDBContext;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import util.Validate;

/**
 *
 * @author win
 */

public class EditProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        request.getRequestDispatcher("../profile/editProfile.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Validate validate = new Validate();
        boolean check = true;
        String messFirstName = "";
        messFirstName = validate.checkLengthName(request.getParameter("firstname").trim());
        // Check first name valid
        if ("Valid".equals(messFirstName)) {
            user.setFirstname(request.getParameter("firstname").trim());
        } else {
            request.setAttribute("messFirstName", messFirstName);
            check = false;
        }
        // Check Last name valid
        messFirstName = validate.checkLengthName(request.getParameter("lastname").trim());
        if ("Valid".equals(messFirstName)) {
            user.setLastname(request.getParameter("lastname").trim());
        } else {
            request.setAttribute("messLastName", messFirstName);
            check = false;
        }
        // Gender
        user.setGender(request.getParameter("gender").equals("male"));
        // Check address Valid
        user.setAddress(request.getParameter("address").trim());
        // Email
        user.setEmail(request.getParameter("email").trim());
        // Check phone number valid 
        user.setPhone_number(request.getParameter("phonenumber").trim());

        user.setDob(Date.valueOf(request.getParameter("dob").trim()));

        user.setNational_id(request.getParameter("national_id").trim());

        user.setNationality(request.getParameter("nationality").trim());

        if (check) {
            UserDBContext db = new UserDBContext();
            db.update(user);
            response.sendRedirect("view");
        } else {
            User userF = new User();
            UserDBContext db = new UserDBContext();
            user = db.get(user.getUser_id());
            request.setAttribute("user", userF);
            request.getRequestDispatcher("../profile/editProfile.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
