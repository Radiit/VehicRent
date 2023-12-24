<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>


    <!--My Style-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />

    <!-- Fonts Google -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,500&display=swap"
        rel="stylesheet" />

    <title>LoginPage</title>
    <style>
        html,
        body {
        overflow: hidden;
        }

        * {
        font-family: "Poppins", sans-serif;
        }
        .login {
        height: 100vh;
        }
        .login-left{
        margin-top: -88px;
        transform: scale(0.75);
        }
        .header h1 {
        /* width: 486px; */

        flex-shrink: 0;
        color: #000;
        font-size: 40px;
        font-style: normal;
        font-weight: 700;
        line-height: normal;
        margin-bottom: 28px;
        margin-top: 30px;
        /*
        margin-left: 20px;
        margin-right: 20px; */
        }
        .header p {
        /* width: 512px; */

        flex-shrink: 0;
        color: #000;
        font-size: 16px;
        font-style: normal;
        font-weight: 500;
        line-height: normal;
        opacity: 0.6;
        margin-bottom: 28px; /* 
        margin-top: 24px; */
        }
        .login-form label {
        color: #000;
        font-size: 16px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        margin-top: 20px;
        }
        .login-form input {
        color: #000;
        font-family: Poppins;
        font-size: 12px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        opacity: 0.4;
        width: 592px;
        height: 40px;
        flex-shrink: 0;
        border-radius: 16px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        background: #fff;
        }
        .login-form a {
        flex-shrink: 0;
        color: #616161;
        font-size: 14px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        margin-top: 10px;
        display: block;
        }
        .login-form .masuk {
        width: 600px;
        height: 48px;
        flex-shrink: 0;
        border-radius: 16px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        background: #a0bc71;
        color: #fff;
        margin-top: 24px;
        }
        .login-form .masukgoogle {
        width: 600px;
        height: 48px;
        flex-shrink: 0;
        border-radius: 16px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        background: #fff;
        }
        .login-form span {
        color: #000;
        font-size: 16px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        width: 309px;
        height: 29px;
        flex-shrink: 0;
        margin-top: 10px;
        display: block;
        }
        .login-form span a {
        color: #616161;
        font-family: Poppins;
        font-size: 16px;
        font-style: normal;
        font-weight: 400;
        line-height: normal;
        margin-top: 10px;
        display: block;
        }

        .login-gambar {
        background-image: url("${pageContext.request.contextPath}/resources/img/img-login.png");
        background-position: left center;
        background-size: cover;
        }

        .login-wrapper {
        padding-left: 100px;
        margin-left: 0px;
        }

        .login-desc-wrapper {
        width: 70%;
        }

        .divider {
        /* font-size: 30px; */
        display: flex;
        align-items: center;
        margin-top: 20px;
        color: rgba(0, 0, 0, 0.4);
        }

        .divider::before,
        .divider::after {
        flex: 1;
        content: "";
        padding: 1.25px;
        background-color: black;
        opacity: 0.1;
        margin: 5px;
        }
    </style>

     <script>
        function validateForm() {
            var email = document.getElementById("email").value;
            var password = document.getElementById("katasandi").value;

            if (email === "" || password === "") {
                // Display error modal
                document.getElementById("errorModal").style.display = "flex";
                return false;
            } else if (!validateEmail(email)) {
                // Display email format error modal
                document.getElementById("errorModal").style.display = "flex";
                return false;
            }

            return true;
        }

        function validateEmail(email) {
            // A simple email validation function
            var emailRegex = /\S+@\S+\.\S+/;
            return emailRegex.test(email);
        }
    </script>
</head>

<body>
    <section class="login d-flex">
        <div class="login-left w-50 h-100">
            <img src="${pageContext.request.contextPath}/resources/img/img_logo.png" alt="Welcome Image" width="200" style="margin-left: -120px;"  />
            <div class="row h-100">
                <div class="col-12 d-flex flex-column align-items-center justify-content-center">
                    <div class="header d-flex flex-column align-items-center">
                        <h1>SELAMAT DATANG</h1>
                        <p>Lanjutkan dengan Google atau Masukan Detail Login</p>
                    </div>
                    <div class="login-form">
                        <button class="masukgoogle">
                            <img src="${pageContext.request.contextPath}/resources/img/img_google.png" alt="" />
                            Masuk menggunakan google
                        </button>

                        <div class="divider">atau</div>

                        <div class="login-form">
                            <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return validateForm()">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Masukkan Email Anda" />

                                <label for="katasandi" class="form-label">Kata Sandi</label>
                                <input type="password" class="form-control" id="katasandi" name="katasandi" placeholder="Masukkan Kata Sandi Anda" />

                                <div>
                                    <a href="" class="text-decoration-none">Lupa Kata Sandi</a>
                                </div>

                                <div>
                                    <button type="submit" class="masuk">Masuk</button>
                                </div>
                            </form>
                            <div style="margin-top: 10px; margin-bottom: 100px;">
                                <span class="d-inline">Belum mempunyai akun? <a href="${pageContext.request.contextPath}/register-form"
                                        class="signup d-inline text-decoration-none">Buat akun</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="login-right w-50 h-100">
            <div class="position-relative w-100 h-100 login-gambar d-flex justify-content-center align-items-center">
                <div class="login-wrapper text-white bg-black bg-opacity-75 w-100 d-flex justify-content-start py-4">
                    <div class="login-desc-wrapper">
                        <h2 class="fw-bolder">Tentang Kami</h2>
                        <p class="fw-normal">Perusahaan rental terbaik dan terlengkap. Moto kami pelanggan puas, Kami
                            senang, Kami VehicRent siap melayani</p>
                    </div>
                </div>
            </div>
        </div>


        <!-- Error Modal -->
        <div id="errorModal" class="error-modal" class="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
            aria-labelledby="errorModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content d-flex justify-content-center align-items-center">
                    <div class="modal-body text-center">
                        <img src="${pageContext.request.contextPath}/resources/img/img_error.png" alt="Error Image" width="100" />
                        <p>Mohon lengkapi formulir dengan benar.</p>
                    </div>
                    <div class="modal-footer">
                        <button onclick="document.getElementById('errorModal').style.display='none'" type="close-button" class="btn btn-secondary" data-bs-dismiss="modal">Complete Data</button>
                    </div>
                </div>
            </div>
        </div>

    </section>


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>

</html>
