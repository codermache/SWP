/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.tour;

import entity.Tour_category;
import entity.Tour;
import dao.TourDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author pc
 */
//@WebServlet(name = "TourArrangement", urlPatterns = {"/arrangement"})

public class TourArrangement extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String xSort = request.getParameter("sort");
        TourDBContext u = new TourDBContext();
        List<Tour> lstTour = u.getSortedTour(xSort);
        List<Tour_category> lstTourCate = u.listCategory();
        request.setAttribute("lstTourCate", lstTourCate);
        request.setAttribute("lstTour", lstTour);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
