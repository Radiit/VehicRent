<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Vehic Rent</title>
    <link rel="icon" href="img/logo.svg" type="image/png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/style/style2.css">
  </head>

  <body>

    <section id="header">
        <a href="#"><img src="${pageContext.request.contextPath}resources/img/logo.svg" class="logo"></a>
        <div>
            <ul id="navbar">
                <li><a class="active" href="${pageContext.request.contextPath}/regent">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/list-regent">Vehicle List</a></li>
                <!-- <li><a href="${pageContext.request.contextPath}/history-regent">Rental History</a></li> -->
                <li><a href="${pageContext.request.contextPath}/register-vehicle">Register Vehicle</a></li>
                <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
                <li>
                    <input type="text" placeholder="Search here " ><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
                </li>
                <li id="lg-bag"><a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a></li>
                <li><a href="notif.html"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
                <li><a href="profile.html"><i class="fa-regular fa-user" style="color: #000000;"></i></a><li>
                <li><a href="/logout">Logout</a></li>
                <a href="#" id="close"><i class="fa-solid fa-xmark" style="color: #000000;"></i></a>
            </ul>
        </div>
        <div id="mobile">           
            <a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
            <i  id="bar" class="fas fa-outdent"></i>"></i>
        </div>
    </section>
    
    <div id="blur">
        <section id="hero">
            <h4>Trade-in-offer</h4>
            <h2>Super deals</h2>
            <h1>OUR SERVICE</h1>
            <p>Unlock new opportunities by joining our platform. 
            <br>Expand your reach with our user-friendly listing process. 
            <br>Competitive fees and promotional support for your products.
            <br>Maximize sales and partner with us for success.<br>
            <strong>YOU WILL BE COMPLETELY SATISFIED.</strong></p>
            <a href="/register-vehicle"><button><b>Add Now</button></a>
        </section>

        <section id="feature" class="seksi-p1">
            <div class="fe-box">
                <img src="${pageContext.request.contextPath}resources/img/mobilkeluarga.jpg" alt="">
                <h5>Mobil Keluarga</h5>
                <h6>Read More</h6>
            </div>
            <div class="fe-box">
                <img src="${pageContext.request.contextPath}resources/img/mobiltravel.jpg" alt="">
                <h5>Mobil Travel</h5>
                <h6>Read More</h6>
            </div>
            <div class="fe-box">
                <img src="${pageContext.request.contextPath}resources/img/mobilangkut.jpg" alt="">
                <h5>Mobil Angkut</h5>
                <h6>Read More</h6>
            </div>
            <div class="fe-box">
                <img src="${pageContext.request.contextPath}resources/img/mobilmewah.jpg" alt="">
                <h5>Mobil Mewah</h5>
                <h6>Read More</h6>
            </div>
            <div class="fe-box">
                <img src="${pageContext.request.contextPath}resources/img/motor.jpg" alt="">
                <h5>Sepeda Motor</h5>
                <h6>Read More</h6>
            </div>
            <div class="fe-box">
                <img src="${pageContext.request.contextPath}resources/img/motormewah.jpg" alt="">
                <h5>Motor Mewah</h5>
                <h6>Read More</h6>
            </div>

        </section>

        <section id="product1" class="seksi-p1">
            <h2>Your Cars</h2>
            <hr class="section-divider">
            <div class="pro-container">
                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/mobilkeluarga.jpg" alt="">
                    <div class="de">
                        <h5>Toyota Avanza New</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(4.9)</i>
                        </div>
                        <h4>Rp 188.000</h4>
                        <span>Ordered: 3</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/m3.jpg" alt="">
                    <div class="de">
                        <h5>New Avanza G Type</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(5)</i>
                        </div>
                        <h4>Rp 200.000</h4>
                        <span>Ordered : 1</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/m1.jpg" alt="">
                    <div class="de">
                        <h5>BMW X6 2020</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(4.7)</i>
                        </div>
                        <h4>Rp 500.000</h4>
                        <span>Ordered : 4</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/m4.jpg" alt="">
                    <div class="de">
                        <h5>New Innova G Type</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(4.7)</i>
                        </div>
                        <h4>Rp 300.000</h4>
                        <span>Ordered: 2</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/b1.jpg" alt="">
                    <div class="de">
                        <h5>Beat CBS 2018</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(4.3)</i>
                        </div>
                        <h4>Rp 80.000</h4>
                        <span>Ordered: 10</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/m7.jpg" alt="">
                    <div class="de">
                        <h5>Daihatsu Gran Max</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(4.4)</i>
                        </div>
                        <h4>Rp 250.000</h4>
                        <span>Ordered: 6</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/b3.jpg" alt="">
                    <div class="de">
                        <h5>Vespa Primavera</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(4.2)</i>
                        </div>
                        <h4>Rp 150.000</h4>
                        <span>Ordered: 5</span>
                    </div>
                </div>

                <div class="pro">
                    <img src="${pageContext.request.contextPath}resources/img/kendaraan/b2.jpg" alt="">
                    <div class="de">
                        <h5>Scoopy Fashion</h5>
                        <div class="star">
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i class="fas fa-star"></i>
                            <i>(3.9)</i>
                        </div>
                        <h4>Rp 88.000</h4>
                        <span>Ordered: 4</span>
                    </div>
                </div>

            </div>

        </section>

        <footer class="seksi-p1">
            <div class="col">
                <img class="logo "src="${pageContext.request.contextPath}resources/img/logo.svg" alt="">
                <h4>Contact<h4>
                <p><strong>Address :</strong> Perumahan Permata Buah Batu, Bojongsoang, Kab.Bandung</p>
                <p><strong>Phone :</strong> +62 87870704978</p>
                <p><strong>Hours :</strong> 10.00 AM - 10.00 PM</p>

                <div class="follow">
                    <h4>Follow us</h4>
                    <div class="icon">
                        <i class="fab fa-facebook-f"></i>
                        <i class="fab fa-twitter"></i>
                        <i class="fab fa-instagram"></i>
                    </div>
                </div>
            </div>

            <div class="col">
                <h4>About Us</h4>
                <a href="#">About us</a>
                <a href="#">Delivery Information</a>
                <a href="#">Privacy Policy</a>
                <a href="#">Terms & Conditions</a>
                <a href="#">Contact Us</a>
            </div>

            <div class="col">
                <h4>My Account</h4>
                <a href="#">Sign In</a>
                <a href="#">View Cart</a>
                <a href="#">My Vehicle</a>
                <a href="#">Help</a>
            </div>

            <div class="col ins">
                <h4>install App</h4>
                <p>From App Store or Google Play</p>
                <div class="row">
                    <img src="${pageContext.request.contextPath}resources/img/app.jpg" alt="" width="150">
                    <img src="${pageContext.request.contextPath}resources/img/play.jpg" alt="" width="150">
                </div>
                <p>Secured Payment Gateways</p>
                <img src="${pageContext.request.contextPath}resources/img/payment gateway.png" alt="" width="200">
            </div>

            <div class="copyright">
                <p>c 2023, Kelompok 6 RPL IMPAL dan PBO</p>
            </div>

        </footer>
    </div>

    <!-- logout card -->
    <div id="logout-card">
        <h3>Are You Sure?</h3>
        <!-- Add more content as needed -->
        <a href="#" onclick="toggleLogOut()"><button>Cancel</button></a>
        <a href="login.html" onclick="toggleLogOut()"><button>Logout</button></a>
    </div>

    <script>
        //TOGGLE LOGOUT
        function toggleLogOut() {
            var blur = document.getElementById('blur');
            blur.classList.toggle('active');
            var logoutCard = document.getElementById('logout-card');
            logoutCard.style.display = (logoutCard.style.display === 'none' || logoutCard.style.display === '') ? 'block' : 'none';
        }    
    </script>

    <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>

  </body>
</html>
