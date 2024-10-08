package com.handloomfashion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get the username and password from the login form
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");

        // Simple validation (you can implement actual authentication logic here)
        if ("admin".equals(username) && "admin123".equals(password)) {
            // Creating session and setting attributes
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to welcome page on successful login
            response.sendRedirect("welcome.jsp");
        } else {
            // Redirect back to login with an error message
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
