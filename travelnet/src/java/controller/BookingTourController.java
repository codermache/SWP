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
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class BookingTourController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookingTourController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookingTourController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int tour_id = Integer.parseInt(request.getParameter("tid"));
            TourDBContext tourDB = new TourDBContext();
            Tour tour = tourDB.get(tour_id);
            request.setAttribute("tr", tour);

            User us = (User) request.getSession().getAttribute("user");
            int user_id = us.getUser_id();
            VoucherDBContext qs = new VoucherDBContext();
            ArrayList<Voucher> voucher = qs.list(user_id);
            request.setAttribute("voucher", voucher);
            UserDBContext u = new UserDBContext();
            User u1 = u.get(user_id);
            request.setAttribute("wallet", u1);
            request.getRequestDispatcher("../view/booking.jsp").forward(request, response);

        } catch (Exception e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             Order o = new Order();
            User us = (User) request.getSession().getAttribute("user");
            int user_id = us.getUser_id();
            int tour_id = Integer.parseInt(request.getParameter("id"));
            TourDBContext tourDB = new TourDBContext();
            Tour tour = tourDB.get(tour_id);
            String selectedVoucher = request.getParameter("mySelect");
            VoucherDBContext vc = new VoucherDBContext();
            double percent_dis = vc.discount(selectedVoucher);
            int tour_price = tour.getTour_price();
            double price_payment = tour_price - tour_price * percent_dis / 100;
            o.setTour_id(tour_id);
            o.setUser_id(user_id);
            o.setCus_name(request.getParameter("cus_name"));
            o.setCus_phone(request.getParameter("cus_phone"));
            o.setCus_email(request.getParameter("cus_email"));
            o.setCus_address(request.getParameter("cus_address"));
            o.setCus_note(request.getParameter("cus_note"));
            o.setVoucher_id(Integer.parseInt(selectedVoucher));
            o.setPrice(price_payment);
            OrderDBContext or = new OrderDBContext();            
            or.insert(o);
           response.sendRedirect("");

            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
