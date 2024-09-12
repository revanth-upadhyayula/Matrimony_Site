<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Baskervville+SC&family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&family=EB+Garamond:ital,wght@0,400..800;1,400..800&family=Marcellus+SC&family=Playwrite+CU:wght@100..400&family=SUSE:wght@100..800&family=Trochut:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Edit</title>
    <link rel="stylesheet" href="profile.css">
</head>
<body>
    <div class="form-container">
        <div class="heading">
            <div class="heading1">
                <h2>Welcome to the Matrimony Site</h2>
                <p>Complete your profile to find the best matches.</p>
            </div>
        </div>
        <form action="ProfileSubmitServlet" method="post" enctype="multipart/form-data">
            <h2>Basic Info</h2>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter your Full Name">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter E-mail">

            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" placeholder="Enter Phone Number">

            <label for="profile_photo">Profile Photo:</label>
            <input type="file" id="profile_photo" name="profile_photo" accept="image/*">

            <label for="additional_photos">Additional Photos:</label>
            <input type="file" id="additional_photos" name="additional_photos" accept="image/*" multiple>

            <h2>Advanced Bio</h2>

            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" placeholder="Male/Female">

            <label for="city">City:</label>
            <input type="text" id="city" name="city" placeholder="Enter City">

            <label for="dob">Date of birth:</label>
            <input type="date" id="dob" name="dob">

            <label for="height">Height:</label>
            <input type="text" id="height" name="height" placeholder="Enter Height">

            <label for="weight">Weight:</label>
            <input type="text" id="weight" name="weight" placeholder="Enter weight">

            <label for="father_name">Father's name:</label>
            <input type="text" id="father_name" name="father_name" placeholder="Enter Father's name">

            <label for="mother_name">Mother's name:</label>
            <input type="text" id="mother_name" name="mother_name" placeholder="Enter Mother's name">

            <label for="community">Community:</label>
            <input type="text" id="community" name="community" placeholder="Enter Community">

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter address">

            <h2>Job Details</h2>

            <label for="company">Company name:</label>
            <input type="text" id="company" name="company" placeholder="Enter company name">

            <label for="position">Position:</label>
            <input type="text" id="position" name="position" placeholder="Enter position">

            <label for="salary">Salary:</label>
            <input type="text" id="salary" name="salary" placeholder="Enter salary">

            <label for="job_location">Job location:</label>
            <input type="text" id="job_location" name="job_location" placeholder="Enter job location">

            <h2>Social Media Details</h2>

            <label for="instagram">Instagram:</label>
            <input type="url" id="instagram" name="instagram" placeholder="Enter Instagram URL">

            <label for="linkedin">LinkedIn:</label>
            <input type="url" id="linkedin" name="linkedin" placeholder="Enter LinkedIn URL">

            <label for="facebook">Facebook:</label>
            <input type="url" id="facebook" name="facebook" placeholder="Enter Facebook URL">

            <label for="youtube">YouTube:</label>
            <input type="url" id="youtube" name="youtube" placeholder="Enter YouTube URL">

            <input type="submit" value="Save">
        </form>
    </div>
</body>
</html>
