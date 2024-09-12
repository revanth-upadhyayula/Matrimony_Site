<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Baskervville+SC&family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&family=EB+Garamond:ital,wght@0,400..800;1,400..800&family=Marcellus+SC&family=Playwrite+CU:wght@100..400&family=SUSE:wght@100..800&family=Trochut:ital,wght@0,400;0,700;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.1/css/boxicons.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Layout 1</title>
    <link rel="stylesheet" href="p.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="profile-picture">
                <img id="profilePic" src="profile.jpg" alt="Profile Picture">
            </div>
			<div class="header-info">
				<h1 id="header-name">  </h1>
				<p id="header-info">
					<span id="header-position">  </span><span class="at"> at </span><span id="company_name"></span>
					<br>
					<span id="location" class="location">  </span>
				</p>
			</div>
		</div>
        <button id="editProfile" class="editprofile">Loading...</button>

        <div class="profile-details">1
            <div class="photo-gallery" id="additional-photos">
                <h3>Gallery</h3>
                <div class="photos">
                    <img src="photo1.jpg" alt="Photo 1" onclick="openLightbox(this)">
                    <img src="photo2.jpg" alt="Photo 2" onclick="openLightbox(this)">
                    <!-- Add more photos as needed -->
                </div>
            </div>
            
            <!-- Lightbox -->
            <div id="lightbox" class="lightbox" onclick="closeLightbox()">
                <span class="close" onclick="closeLightbox()">&times;</span>
                <img id="lightbox-img" src="" alt="Expanded Photo">
            </div>

            <div class="information-section">
                <div class="section">
			        <h2>Personal Info</h2>
			        <p><strong>Name:</strong> <span id="name">  </span></p>
			        <p><strong>Father's name:</strong> <span id="fathers_name">  </span></p>
			        <p><strong>Mother's name:</strong> <span id="mothers_name">  </span></p>
			        <p><strong>Date of Birth:</strong> <span id="dob">  </span></p>
			        <p><strong>Gender:</strong> <span id="gender">  </span></p>
			        <p><strong>Weight:</strong> <span id="weight">  </span></p>
			        <p><strong>Height:</strong> <span id="height">  </span></p>
			        <p><strong>Community:</strong> <span id="community">  </span></p>
			        <p><strong>Salary:</strong> <span id="salary">  </span></p>
			    </div>
			
			    <div class="section">
			        <h2>Contact Info</h2>
			        <p><strong>Email:</strong> <span id="email">  </span></p>
			        <p><strong>Phone:</strong> <span id="phone">  </span></p>
			        <p><strong>City:</strong> <span id="city">  </span></p>
			        <p><strong>Address:</strong> <span id="address">  </span></p>
			    </div>

        </div>
        <!-- <h2>Social Media</h2> -->
        <div class="social-media">
            <a href="" id="facebook"><i class='bx bxl-facebook'></i></a>
            <a href="" id="twitter"><i class='bx bxl-twitter'></i></a>
            <a href="" id="linkedin"><i class='bx bxl-linkedin-square'></i></a>
            <a href="" id="instagram"><i class='bx bxl-instagram'></i></a>
        </div>
        </div>
    </div>
</body>
<script src="p.js"></script>
</html>
