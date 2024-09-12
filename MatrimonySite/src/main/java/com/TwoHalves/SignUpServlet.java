package com.TwoHalves;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            // Proceed with storing the user details in the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twohalves", "root", "revanth@2003");
                String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, username);
                pst.setString(2, email);
                pst.setString(3, password);
                int result = pst.executeUpdate();
                con.close();

                if (result > 0) {
                    response.sendRedirect("login.html"); // Redirect to login page after successful sign-up

                } else {
                    request.setAttribute("errorMessage", "Sign-Up Failed. Please try again.");
                    System.out.print("sign-up failed1");
                    request.getRequestDispatcher("/signup-login/sign-up.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "An error occurred. Please try again.");
                System.out.print("sign-up failed2"+ e.getMessage());
                request.getRequestDispatcher("/signup-login/sign-up.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Invalid email format.");
            System.out.print("sign-up failed3");
            request.getRequestDispatcher("/signup-login/sign-up.jsp").forward(request, response);
        }
    }
}
