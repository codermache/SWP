/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ConversationDBContext;
import entity.Conversation;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author win
 */
public class CreateConversationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           request.getRequestDispatcher("../conversation/customer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null != user) {
            Conversation conversation = new Conversation();
            conversation.setUser_id(user.getUser_id());
            conversation.setEmail(request.getParameter("email"));
            conversation.setPhone_number(request.getParameter("phone"));
            conversation.setTitle(request.getParameter("title"));
            conversation.setContent(request.getParameter("content"));
            conversation.setStatus(false);
            ConversationDBContext conversationDBcontext = new ConversationDBContext();
            conversationDBcontext.insert(conversation);
        }

    }

}
