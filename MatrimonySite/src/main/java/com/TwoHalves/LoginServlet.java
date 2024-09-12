package com.TwoHalves;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twohalves", "root", "revanth@2003");
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
            	int userId = rs.getInt("id");
                
                // Store both email and userId in the session
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("userId", userId);
                response.sendRedirect("../dashboard/homepage.html"); // Redirect to a welcome page or dashboard
//                request.getRequestDispatcher("homepage/home.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                System.out.print("sign-up failed1");
                request.getRequestDispatcher("login.html").forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred. Please try again.");
            System.out.print("sign-up failed2"+ e.getMessage());
            request.getRequestDispatcher("login.html").forward(request, response);
            
        }
    }
}

