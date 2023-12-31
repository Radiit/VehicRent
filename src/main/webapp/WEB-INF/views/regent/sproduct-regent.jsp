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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr@4.6.9/dist/flatpickr.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}resources/style/style2.css">
        
        <script src="https://cdn.jsdelivr.net/npm/flatpickr@4.6.9/dist/flatpickr.min.js"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    </head>
    
    
    <body>
        <!-- NAVBAR -->
        <section id="header">
            <a href="#"><img src="${pageContext.request.contextPath}resources/img/logo.svg" class="logo"></a>
            <div>
                <ul id="navbar">
                    <li><a href="${pageContext.request.contextPath}/home-regent">Home</a></li>
                    <li><a class="active" href="${pageContext.request.contextPath}/list-regent">Vehicle List</a></li>
                    <li><a href="${pageContext.request.contextPath}/history-regent">Rental History</a></li>
                    <li><a href="${pageContext.request.contextPath}/register-vehicle">Register Vehicle</a></li>
                    <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
                    <li>
                        <input type="text" placeholder="Search here " ><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
                    </li>
                    <li id="lg-bag"><a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a></li>
                    <li><a href="notif.html"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
                    <li><a href="profile.html"><i class="fa-regular fa-user" style="color: #000000;"></i></a></li>
                    <li><a href="#" onclick="toggleLogOut()"><button>Logout</button></a></li>
                    <a href="#" id="close"><i class="fa-solid fa-xmark" style="color: #000000;"></i></a>
                </ul>
            </div>
            <div id="mobile">           
                <a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
                <i  id="bar" class="fas fa-outdent"></i>"></i>
            </div>
        </section>

        <div id="blur">
            <section id="prodetails" class="seksi-p1">
                <div class="single-pro-image">
                    <img src="${pageContext.request.contextPath}resources/img/mobilkeluarga.jpg" width="100%" id="MainImg" alt="">
                    
                    <div class="small-img-group">
                        <div class="small-img-col">
                            <img src="${pageContext.request.contextPath}resources/img/mobilkeluarga.jpg" width="100%" class="small-img" alt="">
                        </div>
                        <div class="small-img-col">
                            <img src="${pageContext.request.contextPath}resources/img/a1.jpg" width="100%" class="small-img" alt="">
                        </div>
                        <div class="small-img-col">
                            <img src="${pageContext.request.contextPath}resources/img/a2.jpg" width="100%" class="small-img" alt="">
                        </div>
                        <div class="small-img-col">
                            <img src="${pageContext.request.contextPath}resources/img/a3.jpg" width="100%" class="small-img" alt="">
                        </div>
                    </div>
                </div>

                <div class="single-pro-details">
                    <h5>Bandung Bojongsoang</h5>
                    <h2>Toyota Avanza</h2>
                    <h3>Rp 300.000</h3>
                    <a href="#" onclick="toggleOrderForm()"><button>Edit Product</button></a>
                    <a href="#" onclick="toggleDelete()"><button>Delete Product</button></a>

                    <h4>Product Details</h4>
                    <!-- Teks singkat -->
                    <p id="shortDescription">
                        Produk ini memiliki berbagai fitur yang menakjubkan.
                    </p>
                    <!-- Teks lengkap (detail produk) -->
                    <p id="fullDescription" style="display: none;">
                        Produk ini memiliki berbagai fitur yang menakjubkan. Ini adalah deskripsi panjang produk dengan semua detailnya. Anda dapat mengetahui lebih banyak tentang spesifikasi, warna, dimensi, dan mesin produk ini di sini.
                    </p>
                    <!-- Tombol "read more" -->
                    <a href="#" id="readMoreLink">Read More</a>
                </div>
                
            </section>

            <section id="product1" class="seksi-p1">
                <h2>Your Cars</h2>
                <hr class="section-divider">
                <div class="pro-container">
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

        <!-- Form card -->
        <div id="form-card">
            <h3>Product Details Form</h3>
            <p>Please fill this form</p>
            <form action="#">
                <div class="OrderForm">
                    <label for="product_name">Product Name: </label>
                        <input type="text" name="product_name">
                    <label for="price">Price: </label>
                        <input type="text" name="price">
                    <label for="phone_number">Phone Number: </label>
                        <input type="text" name="phone_number" placeholder="Your Phone Number">
                    <!--Memasukan jumlah kendaraan-->
                    <label for="jumlah">Enter total vehicle: </label>
                        <input type="number" id="jumlah" name="jumlah" min="1" max="100">
                </div>
            </form>

            <a href="#" onclick="toggleOrderForm()"><button>Cancel</button></a>
            <a href="konfirmasi.html" onclick="toggleOrderForm()"><button>Update</button></a>
            
        </div>

        <!-- Delete card -->
        <div id="delete-card">
            <h3>Delete Product</h3>
            <h4 style="color:red; margin-bottom:20px; font-weight:700;">ARE YOU SURE?</h4>
            <a href="#" onclick="toggleDelete()"><button>Cancel</button></a>
            <a href="konfirmasi.html" onclick="toggleDelete()"><button>Delete</button></a>
        </div>

        <!-- logout card -->
        <div id="logout-card">
            <h3>Are You Sure?</h3>
            <!-- Add more content as needed -->
            <a href="#" onclick="toggleLogOut()"><button>Cancel</button></a>
            <a href="login.html" onclick="toggleLogOut()"><button>Logout</button></a>
        </div>

        <script>
            // Inisialisasi date range picker
            flatpickr("#daterange", {
                mode: "range",
                dateFormat: "d-m-Y",
            });
            // Munculin form order
            function toggleOrderForm() {
                var blur = document.getElementById('blur');
                blur.classList.toggle('active');
                var OrderForm = document.getElementById('form-card');
                OrderForm.style.display = (OrderForm.style.display === 'none' || OrderForm.style.display === '') ? 'block' : 'none';
            }

            function toggleDelete() {
                var blur = document.getElementById('blur');
                blur.classList.toggle('active');
                var DeletePop = document.getElementById('delete-card');
                DeletePop.style.display = (DeletePop.style.display === 'none' || DeletePop.style.display === '') ? 'block' : 'none';
            }

            var MainImg = document.getElementById("MainImg");
            var smallimg = document.getElementsByClassName("small-img");
    
            smallimg[0].onclick = function(){
                MainImg.src = smallimg[0].src;
            }
            smallimg[1].onclick=function(){
                MainImg.src = smallimg[1].src;
            }
            smallimg[2].onclick=function(){
                MainImg.src = smallimg[2].src;
            }
            smallimg[3].onclick=function(){
                MainImg.src = smallimg[3].src;
            }
            
            //TOGGLE LOGOUT
            function toggleLogOut() {
                var blur = document.getElementById('blur');
                blur.classList.toggle('active');
                var logoutCard = document.getElementById('logout-card');
                logoutCard.style.display = (logoutCard.style.display === 'none' || logoutCard.style.display === '') ? 'block' : 'none';
            }    

        </script>

        <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>
        <script src="${pageContext.request.contextPath}resources/script/script1.js" async defer></script>

    </body>

</html>
