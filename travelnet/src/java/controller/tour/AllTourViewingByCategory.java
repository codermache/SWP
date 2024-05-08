/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.tour;

import entity.Tour_category;
import entity.Tour;
import dao.*;
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
//@WebServlet(name = "AllTourViewingByCategory", urlPatterns = {"/listtourbycategory"})
public class AllTourViewingByCategory extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TourDBContext u = new TourDBContext();   
        int categoryId = Integer.parseInt(request.getParameter("categoryid"));        
        List<Tour> p=u.getTourByCategoryId(categoryId);
        List<Tour_category> lstTourCate=u.listCategory();
        request.setAttribute("lstTourCate", lstTourCate);
        request.setAttribute("lst", p);
        
        request.getRequestDispatcher("/tour/tourCate.jsp").forward(request, response);
    }
}
