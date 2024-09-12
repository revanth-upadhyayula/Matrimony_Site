<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Baskervville+SC&family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&family=EB+Garamond:ital,wght@0,400..800;1,400..800&family=Marcellus+SC&family=Playwrite+CU:wght@100..400&family=SUSE:wght@100..800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.1.1/css/boxicons.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-Up</title>
    <link rel="stylesheet" href="sign-up.css"> <!-- Link to your CSS file -->
</head>
<body>
    <div class="container">
        <div class="logo-container">
            <img src="logo.png" alt="Logo" class="logo">
        </div>
        <div class="left-side">
            <div>
                <img class="left1" src="left1.jpg" alt="image">
            </div>
        </div>
        <div class="right-side">
            <div>
                <h2>Welcome to Our Platform</h2>
                <p>Join us and start your journey today.</p>
            </div>
            <div class="form-container">
                <h2>Sign Up</h2>
                <form action="SignUpServlet" method="POST"> <!-- Update the action to your backend handler -->
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" placeholder="Enter your username" required>

                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="Enter your email" required>

                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" required>

                    <input type="submit" value="Sign Up">
                </form>

                <div class="or-divider">
                   <span>or</span>
                </div>

                <div class="social-icons">
                    <a href="#" class="social-icon" onclick="signInWithGoogle()"><i class='bx bxl-google'></i></a>
                    <a href="#" class="social-icon" onclick="signInWithMicrosoft()"><i class='bx bxl-microsoft'></i></a>
                    <a href="#" class="social-icon" onclick="signInWithApple()"><i class='bx bxl-apple'></i></a>
                    <a href="#" class="social-icon" onclick="signInWithFacebook()"><i class='bx bxl-facebook'></i></a>
                </div>
                <p>Already have an account? <a href="login.html">Login</a></p> <!-- Link to the login page -->
            </div>
        <!-- </div>
        <section class="footer">
            <p>&copy; 2024 Your Company. All rights reserved.</p>
        </section> -->
    </div>
</body>
</html>
