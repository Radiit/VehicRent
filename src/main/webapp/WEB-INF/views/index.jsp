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

    <!--My Style-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />

    <!-- Fonts Google -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,500&display=swap"
        rel="stylesheet" />

    <title>Hello, world!</title>
</head>

<body>
    <section class="login d-flex">
        <div class="login-left w-50 h-100">
            <img src="${pageContext.request.contextPath}/img/img_logo.png" alt="Welcome Image" width="200" style="margin-left: -120px;"  />
            <div class="row h-100">
                <div class="col-12 d-flex flex-column align-items-center justify-content-center">
                    <div class="header d-flex flex-column align-items-center">
                        <h1>SELAMAT DATANG</h1>
                        <p>Lanjutkan dengan Google atau Masukan Detail Login</p>
                    </div>
                    <div class="login-form">
                        <button class="masukgoogle">
                            <img src="${pageContext.request.contextPath}/img/img_google.png" alt="" />
                            Masuk menggunakan google
                        </button>

                        <div class="divider">atau</div>

                        <div class="login-form">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" placeholder="Masukkan Email Anda" />

                            <label for="katasandi" class="form-label">Kata Sandi</label>
                            <input type="password" class="form-control" id="katasandi"
                                placeholder="Masukkan Kata Sandi Anda" />
                        </div>
                        <div>
                            <a href="" class="text-decoration-none">Lupa Kata Sandi</a>
                        </div>

                        <div>
                            <button class="masuk">Masuk</button>
                        </div>
                        <div style="margin-top: 10px; margin-bottom: 100px;">
                            <span class="d-inline">Belum mempunyai akun? <a href="${pageContext.request.contextPath}/register"
                                    class="signup d-inline text-decoration-none">Buat akun</a></span>
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