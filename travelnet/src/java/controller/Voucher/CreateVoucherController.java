/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Voucher;

import dao.VoucherDBContext;
import entity.Voucher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 *
 * @author win
 */
public class CreateVoucherController extends HttpServlet {

    

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
       VoucherDBContext voucherDBContext = new VoucherDBContext();
       Voucher voucher = new Voucher();
       
       int id = Integer.parseInt(request.getParameter("id").trim());
       String name = request.getParameter("name").trim();
       int quantity = Integer.parseInt(request.getParameter("quantity").trim());
       int discount = Integer.parseInt(request.getParameter("discount").trim());
       Date start = Date.valueOf(request.getParameter("create_date"));
       Date end = Date.valueOf(request.getParameter("end_date"));
       boolean status = request.getParameter("status").equals("on");
       String des = request.getParameter("description").trim();
       int point = Integer.parseInt(request.getParameter("point").trim());
       
       voucher.setVoucher_id(id);
       voucher.setVoucher_name(name);
       voucher.setQuantity(quantity);
       voucher.setDiscount(discount);
       voucher.setCreate_date(start);
       voucher.setEnd_date(end);
       voucher.setStatus(status);
       voucher.setDescription(des);
       voucher.setPoint(point);
       
        try {
            voucherDBContext.createVoucher(voucher);
            response.sendRedirect("list");
        } catch (Exception e) {
            
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
