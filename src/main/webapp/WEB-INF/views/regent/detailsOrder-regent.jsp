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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/style/style2.css">
    <style>
        .form-select {
            width: 100%;
            padding: 8px;
            margin-bottom: 20px;
        }
    </style>
</head>

<body>

    <section id="header">
        <a href="#"><img src="${pageContext.request.contextPath}resources/img/logo.svg" class="logo"></a>
        <div>
            <ul id="navbar">
                <li><a href="${pageContext.request.contextPath}/home-regent">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/list-regent">Vehicle List</a></li>
                <li><a href="${pageContext.request.contextPath}/history-regent">Rental History</a></li>
                <li><a class="active" href="${pageContext.request.contextPath}/register-vehicle">Register Vehicle</a></li>
                <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
                <li>
                    <input type="text" placeholder="Search here " ><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
                </li>
                <li id="lg-bag"><a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a></li>
                <li><a href="notif.html"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
                <li><a href="profile.html"><i class="fa-regular fa-user" style="color: #000000;"></i></a><li>
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
        <section id="confirmation" class="seksi-p1">
            <h2 style="text-align:center; font-weight:700;">Details Order<h2>

                <div class="d-flex justify-content-between">
                    <div class="card" id="konfirmasi">
                        <div class="card-body">
                            <h3><b>Toyota Avanza</b></h3>
                            <p>Pick up address <input class="form-control" type="text"
                                    value="Permata Buah Batu C21t" aria-label="Disabled input example" disabled
                                    readonly></p>
                            <p>Drop off address <input class="form-control" type="text"
                                    value="Permata Buah Batu C21" aria-label="Disabled input example" disabled
                                    readonly></p>
                            <p>Destination <input class="form-control" type="text" value="Jakarta"
                                    aria-label="Disabled input example" disabled readonly></p>
                            <p>Date <input class="form-control" type="text" value="12/06/2023 - 15/06/2023"
                                    aria-label="Disabled input example" disabled readonly></p>
                            <p>Pick up Time <input class="form-control" type="text" value="24.00"
                                    aria-label="Disabled input example" disabled readonly></p>
                        </div>
                    </div>
                    <div class="card" id="receipt">
                        <div class="card-body">
                            <p>Car Price <input class="form-control" type="text" value="Rp. 300.000,00"
                                    aria-label="Car Price" disabled readonly></p>
                            <p>3 Days <input class="form-control" type="text" value="Rp. 300.000,00 x 3"
                                    aria-label="3 Days Total" disabled readonly></p>
                            <p>Total<input class="form-control" type="text" value="Rp. 900.000,00"
                                    aria-label="3 Days Total" disabled readonly></p>
                            <p>Tax (10%)<input class="form-control" type="text" value="Rp 9.000,00"
                                    aria-label="Tax" disabled readonly></p>
                            <hr class="section-divider">
                            <h4>Total<input class="form-control" type="text" value="Rp. 909.000,00" aria-label="Total" disabled readonly></h4>
                        </div>
                    </div>
                </div>

        </section>
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
