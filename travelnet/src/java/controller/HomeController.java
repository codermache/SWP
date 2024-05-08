/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TourDBContext;
import dao.UserDBContext;
import entity.Tour;
import entity.Tour_category;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            TourDBContext tourDB = new TourDBContext();
            int count = tourDB.getTotalTour();
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<Tour> list = tourDB.pagingTour(index);
            List<Tour_category> listCate=tourDB.listCategory();
            request.setAttribute("listA", list);
            request.setAttribute("endP", endPage);
            HttpSession session = request.getSession();
                    session.setAttribute("lstCate",listCate);
     
            request.getRequestDispatcher("/view/homepage.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDBContext usDB = new UserDBContext();
            User user = usDB.get(email, password);
            try {
                if (user == null) {
                    response.getWriter().println("Login fail! Please input username and password");
//                    request.getRequestDispatcher("/view/homepage.jsp").forward(request, response);
                    response.sendRedirect("/swp391_project_main/view/home");

                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);                    
                    // tao Cookie lay thong tin cua nguoi dung de nho lai
                    Cookie user1 = new Cookie("user", user.getEmail());
                    Cookie pass1 = new Cookie("pass", user.getPassword());
                    if (request.getParameter("remember_information") != null) {
                        user1.setMaxAge(60 * 60 * 24);
                        pass1.setMaxAge(60 * 60 * 24);

                    } else {
                        user1.setMaxAge(0);
                        pass1.setMaxAge(0);
                    }
                    response.addCookie(user1);
                    response.addCookie(pass1);

               response.sendRedirect("/swp391_project_main/view/home");

                    }        
            } catch (NullPointerException e) {
            }
        } catch (IOException e) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
