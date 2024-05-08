/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDBContext;
import dao.TourDBContext;
import dao.UserDBContext;
import dao.VoucherDBContext;
import entity.Order;
import entity.Tour;
import entity.User;
import entity.Voucher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class PaymentController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaymentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String id = request.getParameter("id");
        int price = Integer.parseInt(request.getParameter("price"));
        VoucherDBContext vc = new VoucherDBContext();
        double percent_dis = vc.discount(id);
        String discount = Double.toString(price - (price * percent_dis / 100));

        response.getWriter().write(discount);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        int tour_id =  (int) session.getAttribute("tid");
//        TourDBContext tourDB = new TourDBContext();
//        Tour tour = tourDB.get(tour_id);
//        User us = (User) request.getSession().getAttribute("user");
//        int user_id = us.getUser_id();
//
//        String cus_name = request.getParameter("cus_name");
//        String cus_phone = request.getParameter("cus_phone");
//        String cus_email = request.getParameter("cus_address");
//        String cus_address = request.getParameter("cus_phone");
//        String cus_note = request.getParameter("cus_note");
//        String selectedVoucher = request.getParameter("mySelect");
//        VoucherDBContext vc = new VoucherDBContext();
//        double percent_dis = vc.discount(selectedVoucher);
//        int tour_price = tour.getTour_price();
//        double price_payment = tour_price - tour_price * percent_dis / 100;
//        OrderDBContext or = new OrderDBContext();
//        Order o = new Order();
//        o.setTour_id(tour_id);
//        o.setUser_id(user_id);
//        o.setCus_name(cus_name);
//        o.setCus_phone(cus_phone);
//        o.setCus_email(cus_email);
//        o.setCus_adddress(cus_address);
//        o.setCus_note(cus_note);
//        o.setVoucher_id(Integer.parseInt(selectedVoucher));
//        o.setPrice(price_payment);
//        or.insert(o);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
