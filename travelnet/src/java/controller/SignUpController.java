/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.QuestionDBContext;
import dao.UserDBContext;
import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;

/**
 *
 * @author admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SignUpController extends HttpServlet {

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
            out.println("<title>Servlet SignUpController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QuestionDBContext qs = new QuestionDBContext();
        ArrayList<Question> ques = qs.list();
        request.setAttribute("ques", ques);
        request.getRequestDispatcher("/view/account.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();
            byte[] buffer = IOUtils.toByteArray(fileContent); // sử dụng thư viện Apache Commons IO
            String fileString = Base64.getEncoder().encodeToString(buffer); // mã hóa nội dung file sang dạng Base64

// Lưu tệp vào ổ đĩa
//            InputStream is = new ByteArrayInputStream(buffer);

String uploadPath = "E:/SWP391_project/swp391_2023_spring_se1645_group3_Ver1/swp391_project_main/web/image/Avatar/"; // Đường dẫn tới thư mục lưu trữ file
Path filePath = Paths.get(uploadPath + fileName); // Đường dẫn tuyệt đối của file

// Lưu file vào thư mục trên ổ đĩa
InputStream is = new ByteArrayInputStream(buffer);
Files.copy(is, filePath);




// Lưu thông tin của file vào cơ sở dữ liệu
//User user = new User();
//user.setAvatar(filePath.toString()); // Lưu đường dẫn tuyệt đối của file vào đối tượng User
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String address = request.getParameter("address");
            boolean gender = request.getParameter("gender").equals("male");
            String phone = request.getParameter("phone");
            Date dob = Date.valueOf(request.getParameter("dob"));
            String email = request.getParameter("email");
            String nationality = request.getParameter("nationality");
            String national_id = request.getParameter("national_id");
            String answer = request.getParameter("answer");

            
            
            User user = new User();
            user.setUsername(username.trim());
            user.setPassword(password.trim());
            user.setFirstname(firstname.trim());
            user.setLastname(lastname.trim());
            user.setAddress(address.trim());
            user.setGender(gender);
            user.setPhone_number(phone.trim());
            user.setDob(dob);
            user.setEmail(email.trim());
            user.setNationality(nationality.trim());
            user.setNational_id(national_id.trim());
            user.setAnswer(answer);
            user.setAvatar("../image/Avatar/"+fileName);
            UserDBContext us = new UserDBContext();
            us.insert(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/swp391_project/view/home");

        } catch (IllegalStateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
