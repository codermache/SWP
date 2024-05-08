/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.tour;

import entity.Tour;
import dao.*;
import entity.Tour_category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author pc
 */
//@WebServlet(name = "TourSearching", urlPatterns = {"/search"})
public class TourSearching extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String xTourName = request.getParameter("tourname");
        String xReport = "Don't have any like your keyword";
        TourDBContext u = new TourDBContext();
        List<Tour> lstTourByName = u.getTourByName(xTourName);

        request.setAttribute("report", xReport);
        List<Tour_category> lstTourCate = u.listCategory();
        request.setAttribute("lstTourCate", lstTourCate);
        request.setAttribute("lstTourByName", lstTourByName);
        request.getRequestDispatcher("searchTour.jsp").forward(request, response);

    }

}
