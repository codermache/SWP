/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.tour;

import entity.Tour;
import dao.*;
import entity.Tour_category;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewTourDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourDBContext u= new TourDBContext();               
                
        int tourId = Integer.parseInt(request.getParameter("tourid"));        
        Tour p = u.getByTourId(tourId); 
        ArrayList lstTour=u.getAllTour();
        request.setAttribute("tour", p);
        List<Tour_category> lstTourCate=u.listCategory();
        request.setAttribute("lstTourCate",lstTourCate);
        request.setAttribute("lstTour",lstTour);
        request.getRequestDispatcher("tourDetail.jsp").forward(request, response);
    }
}
