package com.TwoHalves;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileCheckServlet")
public class ProfileCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "User ID not found in session");
            return;
        }

        String jdbcURL = "jdbc:mysql://localhost:3306/twohalves";
        String dbUser = "root";
        String dbPassword = "revanth@2003";

        boolean isProfileComplete = true; // Flag to check if profile is complete
        StringBuilder userDetails = new StringBuilder(); // To store the profile details

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Fetch profile details
            String sql = "SELECT name, email, phone, gender, city, dob, height, weight, fathers_name, mothers_name, community, address, company_name, position, salary, job_location, instagram, linkedin, facebook, youtube, profile_completed FROM user_profiles WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Add profile data to the response manually
                userDetails.append("{");
                userDetails.append("\"name\":\"").append(rs.getString("name")).append("\",");
                userDetails.append("\"email\":\"").append(rs.getString("email")).append("\",");
                userDetails.append("\"phone\":\"").append(rs.getString("phone")).append("\",");
                userDetails.append("\"gender\":\"").append(rs.getString("gender")).append("\",");
                userDetails.append("\"city\":\"").append(rs.getString("city")).append("\",");
                userDetails.append("\"dob\":\"").append(rs.getString("dob")).append("\",");
                userDetails.append("\"height\":\"").append(rs.getString("height")).append("\",");
                userDetails.append("\"weight\":\"").append(rs.getString("weight")).append("\",");
                userDetails.append("\"fathers_name\":\"").append(rs.getString("fathers_name")).append("\",");
                userDetails.append("\"mothers_name\":\"").append(rs.getString("mothers_name")).append("\",");
                userDetails.append("\"community\":\"").append(rs.getString("community")).append("\",");
                userDetails.append("\"address\":\"").append(rs.getString("address")).append("\",");
                userDetails.append("\"company_name\":\"").append(rs.getString("company_name")).append("\",");
                userDetails.append("\"position\":\"").append(rs.getString("position")).append("\",");
                userDetails.append("\"salary\":\"").append(rs.getString("salary")).append("\",");
                userDetails.append("\"job_location\":\"").append(rs.getString("job_location")).append("\",");
                userDetails.append("\"instagram\":\"").append(rs.getString("instagram")).append("\",");
                userDetails.append("\"linkedin\":\"").append(rs.getString("linkedin")).append("\",");
                userDetails.append("\"facebook\":\"").append(rs.getString("facebook")).append("\",");
                userDetails.append("\"youtube\":\"").append(rs.getString("youtube")).append("\",");

                // Check if profile is marked as completed in the database
                isProfileComplete = rs.getBoolean("profile_completed");

                // Check if any required fields are null or incomplete
                if (rs.getString("name") == null || rs.getString("email") == null || rs.getString("phone") == null
                        || rs.getString("city") == null || rs.getString("dob") == null || rs.getString("height") == null
                        || rs.getString("weight") == null || rs.getString("community") == null || rs.getString("address") == null) {
                    isProfileComplete = false; // If any required field is missing, profile is incomplete
                }

                userDetails.append("\"profileCompleted\":").append(isProfileComplete).append("}");
            }
            
            String profilePhotoSql = "SELECT photo_path FROM profile_photos WHERE id=?";
            PreparedStatement profilePhotoStmt = conn.prepareStatement(profilePhotoSql);
            profilePhotoStmt.setInt(1, userId);
            ResultSet profilePhotoRs = profilePhotoStmt.executeQuery();

            if (profilePhotoRs.next()) {
                String profilePhoto = profilePhotoRs.getString("photo_url");
                userDetails.append("\"profilePhoto\":\"").append(profilePhoto).append("\",");
            } else {
                userDetails.append("\"profilePhoto\":null,");
            }

            // Fetch additional photos from additional_photos table
            String additionalPhotosSql = "SELECT photo_path FROM additional_photos WHERE id=?";
            PreparedStatement additionalPhotosStmt = conn.prepareStatement(additionalPhotosSql);
            additionalPhotosStmt.setInt(1, userId);
            ResultSet additionalPhotosRs = additionalPhotosStmt.executeQuery();

            List<String> additionalPhotos = new ArrayList<>();
            while (additionalPhotosRs.next()) {
                additionalPhotos.add(additionalPhotosRs.getString("photo_url"));
            }

            // Convert the additional photos list to JSON array
            userDetails.append("\"additionalPhotos\":[");
            for (int i = 0; i < additionalPhotos.size(); i++) {
                userDetails.append("\"").append(additionalPhotos.get(i)).append("\"");
                if (i < additionalPhotos.size() - 1) {
                    userDetails.append(",");
                }
            }
            userDetails.append("]}");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
            return;
        }

        // Set response type and encoding
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Send the response with profile details
        PrintWriter out = response.getWriter();
        out.print(userDetails.toString());
        out.flush();
    }
}
