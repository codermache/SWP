/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TourDBContext;
import entity.Tour;
import entity.Tour_category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SearchTourController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String searchtour = request.getParameter("search");
//        request.setAttribute("searchtour", searchtour);
//        TourDBContext u = new TourDBContext();
//        ArrayList<Tour> lstTourByName = u.getTourByName(searchtour);
//            String xReport = "Don't have any like your keyword! Find other keywords ";
//            request.setAttribute("report", xReport);
//            request.setAttribute("lstTourByName", lstTourByName);
//            request.setAttribute("report", xReport);
//
//        List<Tour_category> lstTourCate = u.listCategory();
//        request.setAttribute("lstTourCate", lstTourCate);
//
//        request.getRequestDispatcher("./viewsearch.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String searchtour = request.getParameter("search");
        request.setAttribute("searchtour", searchtour);
        TourDBContext u = new TourDBContext();
        ArrayList<Tour> lstTourByName = u.getTourByName(searchtour);
            String xReport = "Don't have any like your keyword! Find other keywords ";
            request.setAttribute("report", xReport);
            request.setAttribute("lstTourByName", lstTourByName);
            request.setAttribute("report", xReport);

        List<Tour_category> lstTourCate = u.listCategory();
        request.setAttribute("lstTourCate", lstTourCate);

        request.getRequestDispatcher("./viewsearch.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
