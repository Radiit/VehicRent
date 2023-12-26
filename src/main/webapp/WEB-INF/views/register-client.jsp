<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- My Style -->
        <link rel="stylesheet" href="style.css" />

        <!-- Fonts Google -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,500&display=swap"
            rel="stylesheet" />

        <title>Konfirmasi Client</title>
        <style>
            html,
            body {
                /*overflow: hidden;*/
            }

            * {
                font-family: "Poppins", sans-serif;
            }

            .register {
                height: 100vh;
            }

            .register-left {
                margin-top: -100px;
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
                margin-bottom: 16px;
                margin-top: 16px;
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
                margin-bottom: 28px;
                /* 
        margin-top: 24px; */
            }

            .register-form .fields {
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .input-fields label {
                color: #000;
                font-size: 16px;
                font-style: normal;
                font-weight: 400;
                line-height: normal;
                margin-top: 20px;
                flex-direction: column;
            }

            .input-fields input {
                color: #000;
                font-size: 12px;
                font-style: normal;
                font-weight: 400;
                line-height: normal;
                opacity: 0.4;
                width: 312px;
                height: 40px;
                flex-shrink: 0;
                border-radius: 16px;
                border: 1px solid rgba(0, 0, 0, 0.3);
                background: #fff;
                flex-direction: column;
            }

            input .custom-large {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
            }

            .register-form .fields2 {
                display: flex;
                align-items: center;
                justify-content: flex-start;
            }

            .input-fields2 label {
                color: #000;
                font-size: 16px;
                font-style: normal;
                font-weight: 400;
                line-height: normal;
                margin-top: 20px;
                flex-direction: column;
            }

            .input-fields2 input {
                color: #000;
                font-size: 12px;
                font-style: normal;
                font-weight: 400;
                line-height: normal;
                opacity: 0.4;
                width: 655px;
                height: 40px;
                flex-shrink: 0;
                border-radius: 16px;
                border: 1px solid rgba(0, 0, 0, 0.3);
                background: #fff;
                flex-direction: column;
            }

            .register-form a {
                flex-shrink: 0;
                color: #616161;
                font-size: 14px;
                font-style: normal;
                font-weight: 400;
                line-height: normal;
                margin-top: 10px;
                display: block;
            }

            .register-form .masuk {
                width: 655px;
                height: 48px;
                flex-shrink: 0;
                border-radius: 16px;
                border: 1px solid rgba(0, 0, 0, 0.3);
                background: #a0bc71;
                color: #fff;
                margin-top: 24px;
            }

            .register-form .masukgoogle {
                width: 655px;
                height: 48px;
                flex-shrink: 0;
                border-radius: 16px;
                border: 1px solid rgba(0, 0, 0, 0.3);
                background: #fff;
            }

            .register-form span {
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

            .register-form .form-check {
                display: flex;
                align-items: center;
                justify-content: flex-start;
                margin-top: 28px;
            }

            .form-check .form-check-inpt {
                display: flex;
                justify-content: flex-start;
                margin-right: 12px;
                margin-left: -20px;
            }

            .register-gambar {
                background-image: url("${pageContext.request.contextPath}/resources/img/img-login.png");
                background-position: left center;
                background-size: cover;
            }

            .register-wrapper {
                padding-left: 100px;
                margin-left: 0px;
            }

            .register-desc-wrapper {
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

            .navigasi {
                margin-bottom: 24px;
                box-shadow: 1px 4px 5px 0px rgba(0, 0, 0, 0.05);
                /* border: 2px solid red; */
            }

            .card-text {
                color: black;
                font-size: 16px;
                /* warna teks default */
            }

            .card.inactive .card-text {
                color: #8aae92;
                /* warna teks saat tidak aktif */
            }

            .konfirmasi {
                /* height: 100vh; */
                padding-top: 1rem;
                padding-bottom: 2rem;
            }

            .konfirmasiPage {
                width: 100%;
                /* margin-top: -100px; */
                /* transform: scale(0.75); */
            }

            .konfirmasiPage .title .title-text {
                color: #000;
                text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.1);
                font-family: Poppins;
                font-size: 32px;
                font-style: normal;
                font-weight: 500;
                line-height: normal;
                margin-bottom: 2rem;
            }

            .konfirmasiPage .pilihPeran {
                justify-content: center;
                gap: 4rem;
            }

            .pilihPeran .cardRegent {
                background-color: #f4f9f4;
            }

            .pilihPeran .cardClient {
                background-color: #f4f9f4;
            }

            .header5 {
                color: #000;
                font-family: Poppins;
                font-size: 24px;
                font-style: normal;
                font-weight: 600;
                line-height: normal;
            }

            .header5 p {
                color: #000;
                font-family: Poppins;
                font-size: 16px;
                font-style: normal;
                font-weight: 400;
                line-height: normal;
            }

            .card-title {
                font-size: 16px;
                margin-bottom: 0;
            }

            .card-body-navigasi {
                padding: 1rem;
            }

            .card-body-peran {
                padding: 0;
                margin-bottom: 1rem;
            }

            .button-choose {
                width: 100%;
                text-decoration: none;
                background-color: #fff;
                color: #000;
                text-align: center;
                font-size: 12px;
                padding-top: 12px;
                padding-bottom: 12px;
                /* padding-left: 150px;
        padding-right: 150px; */
                /*border: 1px solid rgba(0, 0, 0, 0.15);*/
                border-radius: 12px;
                /* margin-left: 50px; */
                /*box-shadow: -3px 5px 5px 0px rgba(0, 0, 0, 0.15);*/
                /* height: 100px; */
                flex-shrink: 0;
                border: 1px solid rgba(0, 0, 0, 0.3);
                box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.15);
                transition: all 0.25s ease;
                justify-content: center;
            }

            .button-pilih:active {
                opacity: 0.6;
                transition: all 0.25s ease;
            }

            .card-img-center {
                width: 100%;
            }

            .cardPeran {
                display: flex;
                flex-direction: column;
                justify-content: space-between;
                padding: 2rem;
                border-radius: 1rem;
                box-shadow: 1px 4px 5px 0px rgba(0, 0, 0, 0.19);
            }

            .button-pilih {
                width: 100%;
                text-decoration: none;
                text-align: center;
                font-size: 12px;
                border-radius: 12px;
                flex-shrink: 0;
                border: 1px solid rgba(0, 0, 0, 0.3);
                box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.15);
                transition: all 0.25s ease;
                justify-content: center;
                background-color: #A0BC71;
                padding: 10px;
                margin-top: 32px;
                margin-bottom: 10px;
                width: 100px;
                margin-left: 1400px;
                float: left;
                color: #fff;
            }
        </style>
    </head>

    <body>
        <section class="konfirmasi">
            <div class="konfirmasiPage w-100">
                <img src="${pageContext.request.contextPath}/resources/img/img_logo.png" alt="Welcome Image" width="140"
                    style="margin-bottom: 10px" />
                <div class="navigasi w-100 align-items-center justify-content-center">
                    <div class="card-group w-100">
                        <div class="card w-100">
                            <div class="card-body-navigasi card-body-js  text-center">
                                <h5 class="card-title">Peran</h5>
                                <!-- Isi untuk peran di sini -->
                            </div>
                        </div>
                        <div class="card w-100 inactive">
                            <div class="card-body-navigasi card-body-js  text-center">
                                <h5 class="card-title">Verifikasi Data</h5>
                                <!-- Isi untuk verifikasi data di sini -->
                            </div>
                        </div>
                        <div class="card w-100 inactive">
                            <div class="card-body-navigasi card-body-js text-center">
                                <h5 class="card-title">Status</h5>
                                <!-- Isi untuk status di sini -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="peran">
                    <div class="title align-items-center justify-content-center">
                        <h6 class="title-text d-flex flex-column align-items-center"> Verifikasi Data Anda </h6>
                    </div>
                    <div class="pilihPeran d-flex">
                        <div class="cardPeran cardClient align-items-center" style="width: 26rem;">
                            <div class="card-body-peran card-body-js">
                                <h5 class="card-title"
                                    style="font-size: 20px; font-style: normal; font-weight: 600; line-height: normal;">
                                    Foto KTP</h5>
                                <p class="card-text">Selfie dengan memegang KTP untuk verifikasi data anda</p>
                            </div>
                            <div class="mb-5">
                                <input class="form-control" type="file" id="ktpImg"
                                    onchange="preview(event, 'frame1', 'imageContainer1')">
                            </div>
                            <div id="imageContainer1" class="image-container">
                                <img id="frame1" src="" class="img-fluid" />
                            </div>
                        </div>
                        <div class="cardPeran cardClient align-items-center" style="width: 26rem;">
                            <div class="card-body-peran card-body-js">
                                <h5 class="card-title"
                                    style="font-size: 20px; font-style: normal; font-weight: 600; line-height: normal;">
                                    Foto SIM</h5>
                                <p class="card-text">Foto SIM anda sejajar dengan tempat yang sudah disediakan</p>
                            </div>
                            <div class="mb-5">
                                <input class="form-control" type="file" id="simImg"
                                    onchange="preview(event, 'frame2', 'imageContainer2')">
                            </div>
                            <div id="imageContainer2" class="image-container">
                                <img id="frame2" src="" class="img-fluid" />
                            </div>
                        </div>
                    </div>
                    <!-- href="${pageContext.request.contextPath}/register-status" -->
                    <button id="nextButton"
                        class="button-pilih align-items-center justify-content-center">Selanjutnya</button>
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
        document.addEventListener('DOMContentLoaded', function () {
            var cardBodies = document.querySelectorAll('.card-body-js');

            cardBodies.forEach(function (cardBody) {
                cardBody.addEventListener('click', function () {
                    // Menghapus kelas 'inactive' dari semua card-body
                    cardBodies.forEach(function (c) {
                        c.classList.remove('inactive');
                    });

                    // Menambahkan kelas 'inactive' pada card-body yang tidak diklik
                    cardBodies.forEach(function (c) {
                        if (c !== cardBody) {
                            c.classList.add('inactive');
                        }
                    });
                });
            });
        });

        function b64toBlob(b64Data, contentType, sliceSize) {
                contentType = contentType || '';
                sliceSize = sliceSize || 512;

                var byteCharacters = atob(b64Data);
                var byteArrays = [];

                for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
                    var slice = byteCharacters.slice(offset, offset + sliceSize);

                    var byteNumbers = new Array(slice.length);
                    for (var i = 0; i < slice.length; i++) {
                        byteNumbers[i] = slice.charCodeAt(i);
                    }

                    var byteArray = new Uint8Array(byteNumbers);

                    byteArrays.push(byteArray);
                }

                var blob = new Blob(byteArrays, { type: contentType });
                return blob;
            }

        function preview(event, frameId, containerId) {
            var frame = document.getElementById(frameId);
            var container = document.getElementById(containerId);
            frame.src = URL.createObjectURL(event.target.files[0]);
            container.style.display = "block";
        }

        function clearImage(frameId, inputId, containerId) {
            var frame = document.getElementById(frameId);
            var container = document.getElementById(containerId);
            document.getElementById(inputId).value = null;
            frame.src = "";
            container.style.display = "none";
        }

        const nextButton = document.getElementById('nextButton');
        
        nextButton.addEventListener('click', function () {

            var userData = JSON.parse(sessionStorage.getItem("userData")) || {}; // Mendapatkan data dari sessionStorage atau objek kosong jika tidak ada

            var ktpObj = document.getElementById('ktpImg');
            var simObj = document.getElementById('simImg');

            var ktpFile = ktpObj.files[0];
            var simFile = simObj.files[0];

            var formData = new FormData();

            formData.append('nik', userData.nik);
            formData.append('role_user', userData.role_user);
            formData.append('nama_depan', userData.nama_depan);
            formData.append('nama_belakang', userData.nama_belakang);
            formData.append('noTelepon', userData.noTelepon);
            formData.append('kontakDarurat', userData.kontakDarurat);
            formData.append('umur', userData.umur);
            formData.append('email', userData.email);
            formData.append('password', userData.password);
            formData.append('alamat', userData.alamat);

            var block = userData.fotoDiri.split(";");
            // Get the content type of the image
            var contentType = block[0].split(":")[1];// In this case "image/gif"
            // get the real base64 content of the file
            var realData = block[1].split(",")[1];// In this case "R0lGODlhPQBEAPeoAJosM...."

            // Convert it to a blob to upload
            var blob = b64toBlob(realData, contentType);

            var file = new File([blob], "fotoDiri.png", { type: contentType });
 
            formData.append('fotoDiri', file);
            formData.append('ktp', ktpFile);
            formData.append('sim', simFile);

            // Kirim data jika diperlukan
            fetch('/dashboard/client/create', {
                method: 'POST',
                headers: {
                    // 'Content-Type': 'multipart/form-data'
                },
                body: formData
            })
                .then(response => {
                    if (response.ok) {
                        // Redirect ke halaman selanjutnya jika berhasil
                        window.location.href = '${pageContext.request.contextPath}/register-status';
                    } else {
                        // Tangani jika terjadi kesalahan
                        console.log(response);
                        throw new Error('Something went wrong');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    // Lakukan sesuatu, misalnya tampilkan pesan kesalahan kepada pengguna
                });
        });

    </script>

    </body>

    </html>