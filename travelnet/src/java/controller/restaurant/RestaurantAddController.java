/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.restaurant;

import dao.ConsciousDBContext;
import dao.PlaceDBContext;
import dao.RestaurantDBContext;
import entity.Conscious;
import entity.Place;
import entity.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class RestaurantAddController extends HttpServlet {

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
            out.println("<title>Servlet RestaurantAddController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RestaurantAddController at " + request.getContextPath() + "</h1>");
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
        PlaceDBContext db = new PlaceDBContext();
        ArrayList<Place> places = db.list();
        request.setAttribute("places", places);
        ConsciousDBContext cdb = new ConsciousDBContext();
        ArrayList<Conscious> consciouses = cdb.list();
        request.setAttribute("consciouses", consciouses);
        request.getRequestDispatcher("../restaurant/add.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");  // search tieng viet
        Restaurant r = new Restaurant();
        Place p = new Place();
        p.setPlace_id(Integer.parseInt(request.getParameter("pid")));
        r.setRes_name(request.getParameter("name"));
        r.setRes_address(request.getParameter("address"));
        r.setRes_image(request.getParameter("image"));
        r.setRes_phone(request.getParameter("phone"));
        r.setAverage_price(Integer.parseInt(request.getParameter("price")));
        r.setIntroduction(request.getParameter("introduction"));
        r.setPlace(p);
        RestaurantDBContext rDB = new RestaurantDBContext();
        rDB.insert(r);
        response.getWriter().println("Created a Restaurant successful!");
        response.sendRedirect("list");
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
