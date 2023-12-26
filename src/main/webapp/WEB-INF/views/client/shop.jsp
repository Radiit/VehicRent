<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Vehic Rent</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/style/style2.css">
    </head>

    <body>

    <section id="header">
        <a href="#"><img src="${pageContext.request.contextPath}/resources/img/logo.svg" alt="Logo"></a>
        <div>
            <ul id="navbar">
                <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li><a class="active" href="${pageContext.request.contextPath}/shop">Vehicle List</a></li>
                <li><a href="${pageContext.request.contextPath}/history">Rental History</a></li>
                <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
                <li>
                    <input type="text" placeholder="Search here "><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
                </li>
                <li id="lg-bag"><a th:href="@{/cart}"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a></li>
                <li><a th:href="@{/notif}"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
                <li><a th:href="@{/profile}"><i class="fa-regular fa-user" style="color: #000000;"></i></a></li>
                <a href="#" id="close"><i class="fa-solid fa-xmark" style="color: #000000;"></i></a>
            </ul>
        </div>
        <div id="mobile">           
            <a th:href="@{/cart}"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
            <i  id="bar" class="fas fa-outdent"></i>
        </div>
    </section>    

    <section id="page-header">
        <h2>#stayhome</h2>
        <p>Make life easer, RENT HERE</p>
    </section>

    <section id="product1" class="seksi-p1">
        <div class="pro-container">
            <div class="pro" onclick="window.location.href='${pageContext.request.contextPath}/sproduct'">
                <img src="${pageContext.request.contextPath}resources/img/mobilkeluarga.jpg" alt="">
                <div class="de">
                    <span>Lintas</span>
                    <h5>Toyota Avanza New</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 300.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

        
            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/m3.jpg" alt="">
                <div class="de">
                    <span>Bhineka</span>
                    <h5>New Avanza G Type</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 200.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/m1.jpg" alt="">
                <div class="de">
                    <span>Mantap</span>
                    <h5>BMW X6 2020</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 500.000</h4>
                    <span>Jakarta</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/m4.jpg" alt="">
                <div class="de">
                    <span>Lintas</span>
                    <h5>New Innova G Type</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 300.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/b1.jpg" alt="">
                <div class="de">
                    <span>PBB Rent</span>
                    <h5>Beat CBS 2018</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 80.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/m7.jpg" alt="">
                <div class="de">
                    <span>Lintas</span>
                    <h5>Daihatsu Gran Max</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 250.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/b3.jpg" alt="">
                <div class="de">
                    <span>PBB Rent</span>
                    <h5>Vespa Primavera</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 150.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

            <div class="pro">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/b2.jpg" alt="">
                <div class="de">
                    <span>PBB Rent</span>
                    <h5>Scoopy Fashion</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Rp 88.000</h4>
                    <span>Bandung</span>
                </div>
                <a href="#">
                    <div class="cart">
                        <i class="fa-solid fa-cart-shopping"></i>
                    </div>
                </a>
            </div>

        </div>
    </section>

    <section id="pagination" class="seksi-p1">
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#"><i class="fa-solid fa-arrow-right"></i></a>
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
            <a href="#">My Wishlist</a>
            <a href="#">My Order</a>
            <a href="#">Help</a>
        </div>

        <div class="col install">
            <h4>Install App</h4>
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

    <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>
    <script src="${pageContext.request.contextPath}resources/script/script1.js" async defer></script>
    </body>
</html>
    