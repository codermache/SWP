/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Product;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.FeedBack;
import model.Product;
import model.Service;
import model.User;

/**
 *
 * @author Asus
 */
public class ViewStore extends HttpServlet {

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
            out.println("<title>Servlet ViewStore</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewStore at " + request.getContextPath() + "</h1>");
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
        ProductDAO dao = new ProductDAO();
        User u = new User();
        String page_raw = request.getParameter("page");
        String userId_raw = request.getParameter("userid");
        int userid = Integer.parseInt(userId_raw);

        u = dao.getUserById(userid); // get user by id

        List<Product> listProductSellByUser = new ArrayList<>();
        List<Service> services = new ArrayList<>();
        listProductSellByUser = dao.getAllProductSellByUser(userid); // get all product sell by user
        services = dao.getServicesCreateByUser(userid); // get all services

        List<FeedBack> feedbacks = new ArrayList<>();
        feedbacks = dao.getAllFeedBackOfSeller(listProductSellByUser);
        float rating;
        int totalRate = 0;
        for (FeedBack feedback : feedbacks) {
            totalRate += feedback.getRating();
        }
        rating = (float) totalRate / feedbacks.size();
        DecimalFormat df = new DecimalFormat("#.#");
        int numFeddBack = feedbacks.size();

        //------------------------Paging---------------------------------
        int page = 0;
        if (page_raw.isEmpty()) {
            page = 1;
        } else {
            try {
                page = Integer.parseInt(page_raw);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        int numPerPage = 6;
        int size = listProductSellByUser.size();
        int start = (page - 1) * numPerPage;
        int end = Math.min(page * numPerPage, size);
        int numPage = (size % numPerPage == 0) ? (size / numPerPage) : ((size / numPerPage) + 1);
        List<Product> listProductSellByUserPerPage = new ArrayList<>();
        listProductSellByUserPerPage = dao.getProductSellByUserPerPage(listProductSellByUser, start, end);
        //------------------------End Paging---------------------------------
        
        //------------------------Get Day Participate------------------------------------
        String dayParticipate = "";
        Date createDate = u.getCreate_at();
        java.util.Date utilDate = new java.util.Date(createDate.getTime());
        LocalDateTime dayCreateAccount = LocalDateTime.ofInstant(utilDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime currentTime = LocalDateTime.now();
        long years = ChronoUnit.YEARS.between(dayCreateAccount, currentTime);
        long months = ChronoUnit.MONTHS.between(dayCreateAccount, currentTime);
        long weeks = ChronoUnit.WEEKS.between(dayCreateAccount, currentTime);
        long days = ChronoUnit.DAYS.between(dayCreateAccount, currentTime);
        if (years > 0) {
            dayParticipate = years + " year(s) ago.";
        } else if (months > 0) {
            dayParticipate = months + " month(s) ago.";
        } else if (weeks > 0) {
            dayParticipate = weeks + " week(s) ago.";
        } else {
            dayParticipate = days + " day(s) ago.";
        }
        System.out.println(dayParticipate);
        //------------------------End Get Day Participate---------------------------------

        request.setAttribute("productList", listProductSellByUserPerPage);
        request.setAttribute("totalProduct", listProductSellByUser.size());
        request.setAttribute("numPage", numPage);
        request.setAttribute("page", page);
        request.setAttribute("user", u);
        request.setAttribute("services", services);
        request.setAttribute("rating", df.format(rating));
        request.setAttribute("feedbacks", numFeddBack);
        request.setAttribute("participate", dayParticipate);
        request.getRequestDispatcher("view-store.jsp").forward(request, response);
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
        processRequest(request, response);
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
