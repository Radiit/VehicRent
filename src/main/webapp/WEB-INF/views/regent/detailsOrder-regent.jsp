<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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

            .pritn {
                width: 600px;
                height: 48px;
                flex-shrink: 0;
                color: #04266a;
                margin-top: 24px;
                font: 700 16px/1.2 poppins, sans-serif;
            }
        </style>
    </head>

    <body>

        

        <div id="blur">
            <section id="confirmation" class="seksi-p1">
                <h2 style="text-align:center; font-weight:700;">Details Order<h2>

                        <div class="d-flex justify-content-between">
                            <div class="card" id="konfirmasi">
                                <div class="card-body">
                                    <h3><b>${transaksi.kendaraan.jenisKendaraan}</b></h3>
                                    <p>Name <input class="form-control" type="text" value="${transaksi.orderName}"
                                            aria-label="Disabled input example" disabled readonly></p>
                                    <p>Pick up address <input class="form-control" type="text"
                                            value="${transaksi.pickUpAddress}" aria-label="Disabled input example"
                                            disabled readonly></p>
                                    <p>Drop off address <input class="form-control" type="text"
                                            value="${transaksi.dropOffAddress}" aria-label="Disabled input example"
                                            disabled readonly></p>
                                    <p>Destination <input class="form-control" type="text"
                                            value="${transaksi.destination}" aria-label="Disabled input example"
                                            disabled readonly></p>
                                    <p>Date <input class="form-control" type="text"
                                            value="${transaksi.rentDateStart} - ${transaksi.rentDateEnd}"
                                            aria-label="Disabled input example" disabled readonly></p>
                                </div>
                            </div>
                            <div class="card" id="receipt">
                                <div class="card-body">
                                    <p>Car Price <input class="form-control" type="text" id="carPrice" disabled readonly></p>
                                    <p>${transaksi.lamaSewa} Day${transaksi.lamaSewa > 1 ? 's' : ''} <input class="form-control" type="text" id="countRent" disabled readonly></p>
                                    <p>Total<input class="form-control" type="text" id="total" disabled readonly></p>
                                    <p>Tax (10%)<input class="form-control" type="text" id="tax" disabled readonly></p>
                                    <hr class="section-divider">
                                    <h4>Total<input class="form-control" type="text" id="totalAll" aria-label="Total" disabled readonly></h4>
                                </div>
                            </div>
                        </div>
                        <a href="#" onclick="print()">Print</a>
            </section>
        </div>


        <script>
            //TOGGLE LOGOUT
            function toggleLogOut() {
                var blur = document.getElementById('blur');
                blur.classList.toggle('active');
                var logoutCard = document.getElementById('logout-card');
                logoutCard.style.display = (logoutCard.style.display === 'none' || logoutCard.style.display === '') ? 'block' : 'none';
            }

            function parseRupiah(bilangan) {
                var number_string = bilangan.toString(),
                    sisa = number_string.length % 3,
                    rupiah = number_string.substr(0, sisa),
                    ribuan = number_string.substr(sisa).match(/\d{3}/g);

                if (ribuan) {
                    separator = sisa ? '.' : '';
                    rupiah += separator + ribuan.join('.');
                }

                return rupiah;
            }

            var hargaSewaMobil = parseInt("${transaksi.kendaraan.hargaSewa}");
            var lamaSewa = parseInt("${transaksi.lamaSewa}");
            var total = hargaSewaMobil * lamaSewa;
            var tax = total * 0.1;
            var totalAll = total + tax;

            document.getElementById("carPrice").value = "Rp. " + parseRupiah(hargaSewaMobil);
            document.getElementById("countRent").value = "Rp. " + parseRupiah(hargaSewaMobil) + " x " + lamaSewa;
            document.getElementById("total").value = "Rp. " + parseRupiah(total);
            document.getElementById("tax").value = "Rp. " + tax;
            // document.getElementById("totalAll").value = "Rp. " + parseRupiah(totalAll);
            document.getElementById("totalAll").value = "Rp. " + parseRupiah(parseInt("${transaksi.hargaTotal}"));

        </script>

        <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>

    </body>

    </html>