<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vehic Rent</title>
        <link rel="icon" href="${pageContext.request.contextPath}resources/img/logo.svg" type="image/png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}resources/style/style2.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>

    <body>


        <section id="header">
            <a href="#"><img src="${pageContext.request.contextPath}resources/img/logo.svg" class="logo"></a>
            <div>
                <ul id="navbar">
                    <li><a href="${pageContext.request.contextPath}/home-regent">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/list-regent">Vehicle List</a></li>
                    <li><a href="${pageContext.request.contextPath}/history-regent">Rental History</a></li>
                    <li><a class="active" href="${pageContext.request.contextPath}/register-vehicle">Register
                            Vehicle</a></li>
                    <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
                    <li>
                        <input type="text" placeholder="Search here "><i class="fa-solid fa-magnifying-glass"
                            style="color: #000000;"></i>
                    </li>
                    <li id="lg-bag"><a href="cart.html"><i class="fa-solid fa-cart-shopping"
                                style="color: #000000;"></i></a></li>
                    <li><a href="notif.html"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
                    <li><a href="profile.html"><i class="fa-regular fa-user" style="color: #000000;"></i></a>
                    <li>
                    <li><a href="#" onclick="toggleLogOut()"><button>Logout</button></a></li>
                    <a href="#" id="close"><i class="fa-solid fa-xmark" style="color: #000000;"></i></a>
                </ul>
            </div>
            <div id="mobile">
                <a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
                <i id="bar" class="fas fa-outdent"></i>"></i>
            </div>
        </section>

        <div id="blur">
            <section id="register-form" style="margin-bottom: 20px; margin-top: 20px; margin-left: 80px;">
                <h1 style="text-align: center; margin-top: 20px; font-size: 35px;"><strong>REGISTER YOUR
                        VEHICLE</strong></h1>
                <p style="text-align: center;">Isi data kendaraan yang ingin anda sewakan</p>

                <div class="form-wrapper">
                    <form action="#" id="add-vehicle-form">
                        <div class="form-left">
                            <div class="form-left-inner">
                                <div>
                                    <label for="JenisKendaraan">Jenis Kendaraan</label><br>
                                    <select class="form-select" aria-label="Default select example"
                                        style="width: 300px; height: 35px; border-radius: 10px;" name="jenisKendaraan">
                                        <option value="Mobil Keluarga" selected>Mobil Keluarga</option>
                                        <option value="Mobil Travel">Mobil Travel</option>
                                        <option value="Mobil Angkut">Mobil Angkut</option>
                                        <option value="Mobil Mewah">Mobil Mewah</option>
                                        <option value="Sepeda Motor">Sepeda Motor</option>
                                        <option value="Motor Mewah">Motor Mewah</option>
                                    </select>
                                    <div class="form-input">
                                        <label for="Merk">Merk</label>
                                        <input type="text" placeholder="Masukkan Merk Kendaraan Anda" name="merk">
                                    </div>
                                    <div class="form-input">
                                        <label for="Model">Model</label>
                                        <input type="text" placeholder="Masukkan Model Kendaraan Anda" name="model">
                                    </div>
                                    <div class="form-input">
                                        <label for="HargaSewa">Harga Sewa</label>
                                        <input type="text" placeholder="Masukkan Harga Sewa Kendaraan Anda"
                                            name="hargaSewa">
                                    </div>
                                    <div class="form-input">
                                        <label for="np">Nomor Plat</label>
                                        <input type="text" placeholder="Masukkan Nomor Plat Kendaraan Anda"
                                            name="platNomor">
                                    </div>
                                    <div class="form-input">
                                        <label for="warna">Warna</label>
                                        <input type="text" placeholder="Masukkan Warna Kendaraan Anda" name="warna">
                                    </div>
                                    <div class="form-input">
                                        <label for="Tahun">Tahun</label>
                                        <input type="text" placeholder="Masukkan Tahun Kendaraan Anda"
                                            name="tahunKendaraan">
                                    </div>
                                </div>
                                <div>
                                    <div class="form-input">
                                        <label for="nm">Nomor Mesin</label>
                                        <input type="text" placeholder="Masukkan Nomor Mesin Kendaraan Anda"
                                            name="nomorMesin">
                                    </div>
                                    <div class="form-input">
                                        <label for="STNK">STNK</label>
                                        <input type="file" id="stnkInput" name="stnkImage" accept="image/*" />
                                        <img id="stnkPreview" src="#" alt="STNK Preview"
                                            style="display:none; max-width: 100%; max-height: 200px; margin-top: 10px;">
                                    </div>
                                    <label for="transmisi">Pilih transmisi kendaraan</label><br>
                                    <select class="form-select" aria-label="Default select example"
                                        style="width: 300px; height: 35px; border-radius: 10px;" name="transmisi">
                                        <option value="Automatic" selected>Automatic</option>
                                        <option value="Manual">Manual</option>
                                    </select>
                                </div>
                            </div>
                            <!-- <div style="margin-top: 10px;">
                            <label style="font-weight: 500;" for="">Kondisi Kendaraan</label>
                            <textarea name="" id="" cols="30" rows="10"></textarea>
                            </div> -->
                            <label for="kondisiKendaraan">Pilih Kondisi kendaraan</label><br>

                            <select class="form-select" aria-label="Default select example"
                                style="width: 300px; height: 35px; border-radius: 10px;" name="kondisiKendaraan">
                                <option value="Bagus" selected>Bagus</option>
                                <option value="Lumayan">Lumayan</option>
                            </select>
                        </div>
                        <div class="form-right">
                            <div>
                                <div class="input-image">
                                    <label for="images" class="drop-container" id="dropcontainer">
                                        <span class="drop-title">📁</span>
                                        Klik untuk tambah gambar
                                        <input style="visibility: hidden;" type="file" id="images" name="fotoKendaraan"
                                            accept="image/*" required>
                                    </label>
                                </div>
                            </div>
                            <div class="btn-wrapper">
                                <button class="btn-register btn-daftar" type="button"
                                    onclick="handleSubmit()">Daftar</button>
                                <button class="btn-register btn-batal" type="button">Batal</button>
                            </div>
                        </div>
                    </form>
                </div>

            </section>
        </div>

        <footer class="seksi-p1">
            <div class="col">
                <img class="logo " src="${pageContext.request.contextPath}resources/img/logo.svg" alt="">
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

            const handleSubmit = () => {
                const form = document.getElementById('add-vehicle-form');
                const formData = new FormData(form);

                for (var pair of formData.entries()) {
                    console.log(pair[0] + ', ' + pair[1]);
                }
                
                fetch('/dashboard/kendaraan/create', {
                    method: 'POST',
                    headers: {
                        // 'Content-Type': 'multipart/form-data'
                    },
                    body: formData
                })
                    .then(response => response.json())
                    .then(response => {
                        console.log(response);
                        window.location.href = '/regent';
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
                    
            }
        </script>

        <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>

    </body>

    </html>