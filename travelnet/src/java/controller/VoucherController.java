/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import filter.TourValidation;
import dao.*;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
//@WebServlet(name = "VoucherController", urlPatterns = {"/createvoucher"})
public class VoucherController extends HttpServlet {

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
        request.getRequestDispatcher("tour/createVoucher.jsp").forward(request, response);
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
        TourValidation t=new TourValidation();
        PrintWriter pr=response.getWriter();
        VoucherDBContext u=new VoucherDBContext();
        String xName=request.getParameter("name");
        String xStart=request.getParameter("starttime");
        String xEnd=request.getParameter("endtime");
        String xQuantity=request.getParameter("quantity");
        String xDiscount=request.getParameter("discount");
        String xDescription=request.getParameter("description");
        if(t.checkEmptyInput(xName)==false||t.checkEmptyInput(xStart)==false||
           t.checkEmptyInput(xQuantity)==false||t.checkEmptyInput(xDiscount)||
           t.checkEmptyInput(xDescription)==false){
            pr.print("<h1>Create false</h1>");
                request.getRequestDispatcher("tour/createVoucher.jsp").include(request, response);        
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
