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
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a class="active" href="${pageContext.request.contextPath}/shop">Vehicle List</a></li>
                <li><a href="${pageContext.request.contextPath}/history">Rental History</a></li>
                <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
                <li>
                    <input type="text" placeholder="Search here "><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
                </li>
                <li id="lg-bag"><a th:href="@{/cart}"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a></li>
                <li><a th:href="@{/notif}"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
                <li><a href="/logout">Logout</a></li>
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
        <div class="pro-container" id="vehicleList">
            <!-- Vehicle data will be populated here -->
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
    
    <script>
        fetch("${pageContext.request.contextPath}/dashboard/kendaraan/display")
            .then(response => response.json()) // Assuming the response is JSON
            .then(response => {
                const vehicleList = document.getElementById('vehicleList');

                const data = response.data; // Get the results array
                console.log(data);
                
                // Loop through the data received from the API
                data.forEach(vehicle => {
                    console.log(vehicle);
                    // Create HTML elements dynamically to display each vehicle
                    const div = document.createElement('div');
                    div.className = 'pro';
                    div.onclick = function() {
                        window.location.href = "/product/" + vehicle.idKendaraan;
                        console.log("/product/" + vehicle.idKendaraan);
                    };

                    const img = document.createElement('img');
                    img.src = vehicle.mainImage; // Replace with the property in your API response containing image URL

                    const deDiv =  document.createElement('div');
                    deDiv.className = 'de';
                    
                    const span = document.createElement('span');
                    span.innerHTML = vehicle.merkKendaraan;

                    const h5 = document.createElement('h5');
                    h5.innerHTML = vehicle.jenisKendaraan;

                    const divStar = document.createElement('div');
                    divStar.className = 'star';

                    for (let i = 0; i < vehicle.totalRating; i++) {
                        const iStar = document.createElement('i');
                        iStar.className = 'fa-solid fa-star';
                        divStar.appendChild(iStar);
                    }

                    const h4 = document.createElement('h4');
                    h4.innerHTML = "Rp. " + vehicle.hargaSewa;

                    const span2 = document.createElement('span');
                    span2.innerHTML = vehicle.kondisiKendaraan;

                    // Create other elements (span, h5, div.star, h4, span, a, etc.) to display vehicle details

                    // Append elements to the div
                    div.appendChild(img);
                    div.appendChild(deDiv);
                    deDiv.appendChild(span);
                    deDiv.appendChild(h5);
                    deDiv.appendChild(divStar);
                    deDiv.appendChild(h4);
                    deDiv.appendChild(span2);

                    // Append other elements as needed

                    // Append the vehicle div to the vehicleList container
                    vehicleList.appendChild(div);
                });
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                // Handle errors
            });

    </script>
    </body>
</html>
    