/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.staff;

import dao.UserDBContext;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author win
 */
public class SearchStaffByNameController extends HttpServlet {

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
        UserDBContext userDBContext = new UserDBContext();
        ArrayList<User> staffList = null;
        String txt = request.getParameter("txt").trim();
        staffList = userDBContext.getStaffListByName(txt);
        int index = 0;
        for (User o : staffList) {        
            index += 1;
            String sex = null;
            if (o.isGender()) {
                sex = "Male";
            } else {
                sex = "Female";
            }
            response.getWriter().print("<tr>\n"
                    + "                                                    <th scope=\"row\"> <a href=\"#\" class=\"question_content\">" + index + "</a></th>\n"
                    + "                                                    <td>" + o.getUser_id() + "</td>\n"
                    + "                                                    <td class=\"name\">" + o.getUsername() + "</td>                                                    \n"
                    + "\n"
                    + "                                                    <td>" + o.getFirstname() + " " + o.getLastname() + "</td>\n"
                    + "\n"
                    + "                                                    <td> " + sex + "                                                     \n"
                    + "                                                        </td>\n"
                    + "                                                    <td>" + o.getPhone_number() + "</td>\n"
                    + "                                                    <td>" + o.getAddress() + "</td>\n"
                    + "                                                    <td>" + o.getEmail() + "</td>   \n"
                    + "                                                    <td>\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#" + o.getUser_id() + "\">\n"
                    + "                                                            <i class=\"fa-solid fa-pen-to-square\" ></i>\n"
                    + "                                                        </button>\n"
                    + "                                                        <button style=\"background-color: red\" type=\"button\" class=\"btn btn-primary\" onclick=\"removeStaff(" + o.getUser_id() + ")\" >\n"
                    + "                                                            <i class=\"fa-regular fa-trash-can\"></i>\n"
                    + "                                                        </button>\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#" + o.getUser_id() + "-details\">\n"
                    + "                                                            i\n"
                    + "                                                        </button>  \n"
                    + "                                                    </td>\n"
                    + "\n"
                    + "                                                </tr>");
        }
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
