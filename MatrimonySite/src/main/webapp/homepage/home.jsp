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
    <script type="module" src="https://cdn.jsdelivr.net/npm/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://cdn.jsdelivr.net/npm/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <title>TwoHalves</title>
    <link rel="stylesheet" href="home.css">
</head>
<body>
    <header class="header">
        <a href="#" class="logo-container"><img src="logo2.png" class="logo img" alt="Logo"></a>        
        <nav class="navbar">
            <button id="Login">
                Log-In
            </button>
            <button id="connectButton">Get Started</button>
        </nav>
    </header>
    <section class="main-content">
        <div class="container">
            <div class="item item2">
                <div class="text">
                    <h1 class="type"></h1>
                    <p class="p">— unite through <b><span class="pink">Two</span><span class="blue">Halves</span></b></p>
                    <button>Get Started</button>
                </div>
            </div>
            <div class="item item3">
                <img src="light.jpg" class="main-photo">
            </div>
        </div>
    </section>

    <!-- Features Section -->
    <section class="features">
        <div class="containers">
            <h2>Features</h2>
            <div class="feature-grid">
                <div class="feature-item">
                    <h3>Feature One</h3>
                    <p>Description of Feature One.</p>
                </div>
                <div class="feature-item">
                    <h3>Feature Two</h3>
                    <p>Description of Feature Two.</p>
                </div>
                <div class="feature-item">
                    <h3>Feature Three</h3>
                    <p>Description of Feature Three.</p>
                </div>
                <div class="feature-item">
                    <h3>Feature Three</h3>
                    <p>Description of Feature Three.</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Testimonials Section -->
    <section class="testimonials">
        <div class="containers">
            <h2>Testimonials</h2>
            <div class="testimonial-slider">
                <div class="testimonial-item">
                    <p>"This is an amazing platform! It has greatly helped me."</p>
                    <p><strong>- User Name</strong></p>
                </div>
                <div class="testimonial-item">
                    <p>"TwoHalves has changed  a the way I approach my goals."</p>
                    <p><strong>- Happy Customer</strong></p>
                </div>
                <div class="testimonial-item">
                    <p>"A fantastic experience! Highly recommended."</p>
                    <p><strong>- Another User</strong></p>
                </div>
                <div class="testimonial-item">
                    <p>"TwoHalves has changed thsee way I approach my goals."</p>
                    <p><strong>- Happy Customer</strong></p>
                </div>
                <div class="testimonial-item">
                    <p>"A fantastic experience! Highly vry recommended."</p>
                    <p><strong>- Another User</strong></p>
                </div>
                <div class="testimonial-item">
                    <p>"TwoHalves has changed the ht way I approach my goals."</p>
                    <p><strong>- Happy Customer</strong></p>
                </div>
                <div class="testimonial-item">
                    <p>"A fantastic experience!?? Highly recommended."</p>
                    <p><strong>- Another User</strong></p>
                </div>
            </div>
        </div>
    </section>


    <!-- Contact Section -->
    <section class="contact">
        <div class="containers">
            <h2>Contact Us</h2>
            <form action="#" method="POST">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="Enter your name" required>

                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>

                <label for="message">Message</label>
                <textarea id="message" name="message" placeholder="Enter your message" rows="4" required></textarea>

                <input type="submit" value="Send Message">
            </form>
        </div>
    </section>

    <section class="footer">
        <div class="item item4"></div>
    </section>
    
    <script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>
    <script>
        var typed = new Typed(".type",{
            strings: ["Two Souls,"," One Destiny"],
            typeSpeed: 70,
            backSpeed: 70,
            loop: true,
            onStringTyped: function(pos, self) {
                if (pos === 0) {
                    self.el.style.color = 'rgb(160 188 229)'; // Set color for "Two souls," in light mode
                } else if (pos === 1) {
                    self.el.style.color = 'rgb(222 118 131)'; // Set color for "one destiny" in light mode
                }
            }
        });
    </script>
    <script src="home.js"></script>
</body>
</html>
