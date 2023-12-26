<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />

    <!-- My Style -->
    <link rel="stylesheet" href="style.css" />

    <!-- Fonts Google -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,500&display=swap"
        rel="stylesheet" />

    <style>
        html,
        body {
            /*overflow: hidden;*/
        }

        .status-container {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 60vh;
            /* Set the height to 100% of the viewport height */
        }

        * {
            font-family: "Poppins", sans-serif;
        }

        .header p {
            flex-shrink: 0;
            color: #000;
            font-size: 24px;
            font-style: normal;
            font-weight: 700;
            line-height: normal;
            margin-bottom: 16px;
            margin-top: 16px;
        }

        .status-item {
            text-align: center;
            margin-top: 20px;
            /* Adjust as needed */
        }
    </style>

    <title>Status</title>
</head>

<body>
    <section class="konfirmasi">
        <div class="konfirmasiPage w-100">
            <img src="${pageContext.request.contextPath}/resources/img/img_logo.png" alt="Welcome Image" width="140" style="margin-bottom: 10px" />
            <div class="navigasi w-100 align-items-center justify-content-center">
                <div class="card-group w-100">
                    <div class="card w-100">
                        <div class="card-body-navigasi card-body-js text-center">
                            <h5 class="card-title">Peran</h5>
                        </div>
                    </div>
                    <div class="card w-100 inactive">
                        <div class="card-body-navigasi card-body-js text-center">
                            <h5 class="card-title">Verifikasi Data</h5>
                        </div>
                    </div>
                    <div class="card w-100 inactive">
                        <div class="card-body-navigasi card-body-js text-center">
                            <h5 class="card-title">Status</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="status-container align-items-center justify-content-center">
                <div class="status-item-sukses" style="display: none">
                    <img id="img-sukses" src="${pageContext.request.contextPath}/resources/img/img-sukses.png" alt="Verifikasi Berhasil" width="150" />
                    <p class="text-berhasil">Verifikasi Berhasil</p>
                </div> 
                <div class="status-item-load">
                    <img id="img-load" src="${pageContext.request.contextPath}/resources/img/img-load.gif" alt="Memproses" />
                    <p class="text-memproses">Memproses Registrasi</p>
                </div>
                <div class="status-item-gagal" style="display: none">
                    <img id="img-gagal" src="${pageContext.request.contextPath}/resources/img/img-gagal.png" alt="Verifikasi Gagal" width="150" />
                    <p class="text-gagal">Verifikasi Gagal</p>
                </div>
            </div>
        </div>
    </section>
</body>

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
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var cardBodies = document.querySelectorAll(".card-body-js");

        cardBodies.forEach(function (cardBody) {
            cardBody.addEventListener("click", function () {
                // Menghapus kelas 'inactive' dari semua card-body
                cardBodies.forEach(function (c) {
                    c.classList.remove("inactive");
                });

                // Menambahkan kelas 'inactive' pada card-body yang tidak diklik
                cardBodies.forEach(function (c) {
                    if (c !== cardBody) {
                        c.classList.add("inactive");
                    }
                });

                // Menampilkan status sesuai kondisi
                // Ganti dengan kondisi sesuai kebutuhan
            });
        });
    });

    function showStatus(status) {
        var statusItemSukses = document.querySelector(".status-item-sukses");
        var statusItemLoad = document.querySelector(".status-item-load");
        var statusItemGagal = document.querySelector(".status-item-gagal");

        var textBerhasil = document.querySelector(".text-berhasil");
        var textMemproses = document.querySelector(".text-memproses");
        var textGagal = document.querySelector(".text-gagal");

        switch (status) {
            case "Valid":
                statusItemSukses.style.display = "block";
                statusItemLoad.style.display = "none";
                statusItemGagal.style.display = "none";
                break;
            case "Pending":
                statusItemSukses.style.display = "none";
                statusItemLoad.style.display = "block";
                statusItemGagal.style.display = "none";
                break;
            case "Tidak Valid":
                statusItemSukses.style.display = "none";
                statusItemLoad.style.display = "none";
                statusItemGagal.style.display = "block";
                break;
            default:
            // Default behavior
        }
    }

    showStatus("${user.valid}");

    //setTimeout(() => {
    //    showStatus("${user.valid}");
    //}, 2000);
</script>

</html>