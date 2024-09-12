package com.TwoHalves;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
public class ProfileSubmitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        
        if (userId == null) {
            response.sendRedirect("../signup-login/login.html"); // Redirect to login if not logged in
            return;
        }
        System.out.println(userId);
        String jdbcURL = "jdbc:mysql://localhost:3306/twohalves";  // Updated DB info
        String dbUser = "root";
        String dbPassword = "revanth@2003";

         // Example user ID. Replace with dynamic user session ID.

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Retrieve form data
            String name = getOrDefault(request.getParameter("name"), "");
            String email = getOrDefault(request.getParameter("email"), "");
            String phone = getOrDefault(request.getParameter("phone"), "");
            String gender = getOrDefault(request.getParameter("gender"), "");
            String city = getOrDefault(request.getParameter("city"), "");
            String dobStr = getOrDefault(request.getParameter("dob"), "1970-01-01");
            String heightStr = getOrDefault(request.getParameter("height"), "0");
            String weightStr = getOrDefault(request.getParameter("weight"), "0");
            String fatherName = getOrDefault(request.getParameter("father_name"), "");
            String motherName = getOrDefault(request.getParameter("mother_name"), "");
            String community = getOrDefault(request.getParameter("community"), "");
            String address = getOrDefault(request.getParameter("address"), "");
            String company = getOrDefault(request.getParameter("company"), "");
            String position = getOrDefault(request.getParameter("position"), "");
            String salaryStr = getOrDefault(request.getParameter("salary"), "0");
            String jobLocation = getOrDefault(request.getParameter("job_location"), "");
            String instagram = getOrDefault(request.getParameter("instagram"), "");
            String linkedin = getOrDefault(request.getParameter("linkedin"), "");
            String facebook = getOrDefault(request.getParameter("facebook"), "");
            String youtube = getOrDefault(request.getParameter("youtube"), "");
            boolean profileCompleted = true;

            // Convert string to numeric values
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);
            float salary = Float.parseFloat(salaryStr);
            java.sql.Date dob = java.sql.Date.valueOf(dobStr);

            // Handle file uploads
            Part profilePhotoPart = request.getPart("profile_photo");
            Part[] additionalPhotosParts = request.getParts().stream()
                .filter(part -> part.getName().startsWith("additional_photos"))
                .toArray(Part[]::new);

            String profilePhotoPath = saveFile(profilePhotoPart, request);
            String[] additionalPhotosPaths = new String[additionalPhotosParts.length];
            for (int i = 0; i < additionalPhotosParts.length; i++) {
                additionalPhotosPaths[i] = saveFile(additionalPhotosParts[i], request);
            }

            // Update user profile details
            String insertOrUpdateProfileSQL = "INSERT INTO user_profiles (id, name, email, phone, gender, city, dob, height, weight, fathers_name, mothers_name, community, address, company_name, position, salary, job_location, instagram, linkedin, facebook, youtube, profile_completed) " +
            	    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
            	    "ON DUPLICATE KEY UPDATE " +
            	    "name = VALUES(name), " +
            	    "email = VALUES(email), " +
            	    "phone = VALUES(phone), " +
            	    "gender = VALUES(gender), " +
            	    "city = VALUES(city), " +
            	    "dob = VALUES(dob), " +
            	    "height = VALUES(height), " +
            	    "weight = VALUES(weight), " +
            	    "fathers_name = VALUES(fathers_name), " +
            	    "mothers_name = VALUES(mothers_name), " +
            	    "community = VALUES(community), " +
            	    "address = VALUES(address), " +
            	    "company_name = VALUES(company_name), " +
            	    "position = VALUES(position), " +
            	    "salary = VALUES(salary), " +
            	    "job_location = VALUES(job_location), " +
            	    "instagram = VALUES(instagram), " +
            	    "linkedin = VALUES(linkedin), " +
            	    "facebook = VALUES(facebook), " +
            	    "youtube = VALUES(youtube), " +
            	    "profile_completed = VALUES(profile_completed)";

            	PreparedStatement profileStmt = conn.prepareStatement(insertOrUpdateProfileSQL);
            	profileStmt.setInt(1, userId);  // Use session userId
            	profileStmt.setString(2, name);
            	profileStmt.setString(3, email);
            	profileStmt.setString(4, phone);
            	profileStmt.setString(5, gender);
            	profileStmt.setString(6, city);
            	profileStmt.setDate(7, dob);
            	profileStmt.setFloat(8, height);
            	profileStmt.setFloat(9, weight);
            	profileStmt.setString(10, fatherName);
            	profileStmt.setString(11, motherName);
            	profileStmt.setString(12, community);
            	profileStmt.setString(13, address);
            	profileStmt.setString(14, company);
            	profileStmt.setString(15, position);
            	profileStmt.setFloat(16, salary);
            	profileStmt.setString(17, jobLocation);
            	profileStmt.setString(18, instagram);
            	profileStmt.setString(19, linkedin);
            	profileStmt.setString(20, facebook);
            	profileStmt.setString(21, youtube);
            	profileStmt.setBoolean(22, profileCompleted);

            	// Execute the query
            	profileStmt.executeUpdate();
            System.out.print(name);
            System.out.print(email);
            System.out.print(salary);
            System.out.print(profileCompleted);
            System.out.print(userId);
            // Insert profile photo record
            if (profilePhotoPath != null) {
                String insertProfilePhotoSQL = "INSERT INTO profile_photos (user_id, photo_path) VALUES (?, ?)";
                PreparedStatement photoStmt = conn.prepareStatement(insertProfilePhotoSQL);
                photoStmt.setInt(1, userId);
                photoStmt.setString(2, profilePhotoPath);
                photoStmt.executeUpdate();
            }

            // Insert additional photos records
            for (String photoPath : additionalPhotosPaths) {
                if (photoPath != null) {
                    String insertAdditionalPhotoSQL = "INSERT INTO additional_photos (user_id, photo_path) VALUES (?, ?)";
                    PreparedStatement additionalPhotoStmt = conn.prepareStatement(insertAdditionalPhotoSQL);
                    additionalPhotoStmt.setInt(1, userId);
                    additionalPhotoStmt.setString(2, photoPath);
                    additionalPhotoStmt.executeUpdate();
                }
            }

            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            System.out.print(e);
//            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }
        
        // Redirect to profile page or another appropriate page
        response.sendRedirect("../profilepage/p.jsp");
    }

    private String getOrDefault(String value, String defaultValue) {
        return (value == null || value.trim().isEmpty()) ? defaultValue : value.trim();
    }

    private String saveFile(Part filePart, HttpServletRequest request) throws IOException {
        if (filePart == null || filePart.getSize() == 0) {
            return null;
        }

        String fileName = filePart.getSubmittedFileName();
        String uploadDir = request.getServletContext().getRealPath("/uploads");

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdir();
        }

        String filePath = uploadDir + File.separator + fileName;
        filePart.write(filePath);

        return filePath;
    }
}
