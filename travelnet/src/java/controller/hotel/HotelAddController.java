/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.hotel;

import dao.ConsciousDBContext;
import dao.HotelDBContext;
import dao.PlaceDBContext;
import entity.Conscious;
import entity.Hotel;
import entity.Place;
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
public class HotelAddController extends HttpServlet {

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
            out.println("<title>Servlet HotelAddCotroller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HotelAddCotroller at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");  // search tieng viet
        PlaceDBContext db = new PlaceDBContext();
        ArrayList<Place> places = db.list();
        request.setAttribute("places", places);
        ConsciousDBContext cdb = new ConsciousDBContext();
        ArrayList<Conscious> consciouses = cdb.list();
        request.setAttribute("consciouses", consciouses);
        request.getRequestDispatcher("../hotel/add.jsp").forward(request, response);
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
        Hotel h = new Hotel();
        Place p = new Place();
//        Conscious c = new Conscious();
        p.setPlace_id(Integer.parseInt(request.getParameter("pid")));
//        c.setC_id(Integer.parseInt(request.getParameter("cid")));
        h.setHotel_name(request.getParameter("name"));
        h.setHotel_address(request.getParameter("address"));
        h.setHotel_img(request.getParameter("image"));
        h.setHotel_phone(request.getParameter("phone"));
        h.setHotel_description(request.getParameter("description"));
        h.setHotel_type(Integer.parseInt(request.getParameter("type")));
        h.setHotel_rate(Integer.parseInt(request.getParameter("rate")));
        h.setPlace(p);
        HotelDBContext db = new HotelDBContext();
        db.insert(h);
        response.getWriter().println("Created a Hotel successful!");
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
