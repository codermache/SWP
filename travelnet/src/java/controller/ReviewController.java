/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CommentDBContext;
import dao.TourDBContext;
import entity.Comment;
import entity.Tour;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ReviewController extends HttpServlet {

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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          int tid = Integer.parseInt(request.getParameter("id"));
        String comment = request.getParameter("content");
        User a = (User) request.getSession().getAttribute("user");
        int user_id = a.getUser_id();
//       resp.getWriter().println("sa" + comment + "à" + username + "ds" + tid);
        CommentDBContext db = new CommentDBContext();
        db.insertComment(tid, comment, user_id);
        response.sendRedirect("detail");
        
//        TourDBContext tr = new TourDBContext();
//        ArrayList<Tour> tour = tr.list();
//        CommentDBContext com = new CommentDBContext();
//        ArrayList<Comment> cm = com.list();
//        request.setAttribute("comment", cm);
//        request.setAttribute("tour", tour);
//        request.getRequestDispatcher("view_detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
//         int tid = Integer.parseInt(request.getParameter("id"));
//        String comment = request.getParameter("content");
//        User a = (User) request.getSession().getAttribute("user");
//        int user_id = a.getUser_id();
////       resp.getWriter().println("sa" + comment + "à" + username + "ds" + tid);
//        CommentDBContext db = new CommentDBContext();
//        db.insertComment(tid, comment, user_id);
//        response.sendRedirect("detail");
        
        

//        TourDBContext tr = new TourDBContext();
//        ArrayList<Tour> tour = tr.list();
//        CommentDBContext com = new CommentDBContext();
//        ArrayList<Comment> cm = com.list();
//        request.setAttribute("comment", cm);
//        request.setAttribute("tour", tour);
//        request.getRequestDispatcher("../view/view_detail.jsp").forward(request, response);

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
