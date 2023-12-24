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

    <div id="blur">
        <section id="confirmation" class="seksi-p1">
            <h2 style="text-align:center; font-weight:700;">Confirm Your Order<h2>

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
                            <h4>Total<input class="form-control" type="text" value="Rp. 909.000,00"
                                    aria-label="Total" disabled readonly></h4>
                            <a href="${pageContext.request.contextPath}/sproduct" onclick="togglePayment()"><button>Cancel</button></a>
                            <a href="#" onclick="togglePayment()"><button>Pay</button></a>

                        </div>
                    </div>
                </div>

        </section>
    </div>

    <div id="payment-card" style="max-width:400px; margin:auto; padding:20px; box-sizing:border-box; overflow:hidden; display: none;">
        <h3>Payment</h3>
        <!-- Add more content as needed -->
        <form action="#">
            <label for="payment-method">Select Payment Method:</label>
            <select id="payment-method" class="form-select" onchange="showSubOptions(this)">
                <option value="cod">COD (Cash On Delivery)</option>
                <option value="bank">Transfer Bank</option>
                <option value="card">Credit/Debit Card</option>
            </select>
    
            <div id="bank-options" class="sub-options" style="display:none;">
                <label for="bank-options">Select Bank:</label>
                <select  id="bank-select" class="form-select" onchange="showVirtualNumber(this)">
                    <option value="bca">Bank Central Asia</option>
                    <option value="bni">Bank Negara Indonesia</option>
                    <option value="mandiri">Bank Mandiri</option>
                </select>
            </div>
    
            <!-- Menampilkan nomor virtual untuk Bank Central Asia -->
            <div id="bca-details" class="sub-options" style="display:none;">
                <p id="bca-virtual-account"></p>
            </div>
        
            <button type="button" onclick="togglePayment()">Cancel</button>
            <button onclick="submitPayment()">Submit Payment</button>
        </form>

    </div>

    <script async defer>
        var virtualNumber;

        // Munculin form order
        function togglePayment() {
            var blur = document.getElementById('blur');
            blur.classList.toggle('active');
            var paymentMethod = document.getElementById('payment-card');
            paymentMethod.style.display = (paymentMethod.style.display === 'none' || paymentMethod.style.display === '') ? 'block' : 'none';

            // Sembunyikan/munculkan nomor virtual berdasarkan pilihan bank
            var bcaDetails = document.getElementById('bca-details');
            var bankSelect = document.getElementById('bank-select');
            var bcaVirtualAccount = document.getElementById('bca-virtual-account');

            if (bankSelect.value === 'bca') {
                // Tampilkan nomor virtual untuk Bank Central Asia
                // Ganti dengan nomor virtual BCA yang sesuai
                var bcaVirtualNumber = '1234 5678 9012 3456';
                //   bcaVirtualAccount.textContent = 'Virtual Account Number: ' + bcaVirtualNumber;
                bcaDetails.style.display = 'block';
            } else {
                bcaDetails.style.display = 'none';
            }
        }

        // Fungsi buat nampilin virtualnumber ketika ada perubahan di select bank
        // kalo ada perubahan, bakal ngetrigger onChange()
        function showVirtualNumber(el) {
            // ambil element va nya
            var bcaVirtualAccount = document.getElementById('bca-virtual-account');

            // pengkondisian no va sesuai bank yang dipilih
            if(el.value == "bni") {
                virtualNumber = "BNI0012010111"
            } else if (el.value == "bca") {
                virtualNumber = "BCA0012010111"
            } else if (el.value == "mandiri") {
                virtualNumber = "MANDIRI0012010111"
            }
            // nampilin
            bcaVirtualAccount.textContent = 'Virtual Account Number: ' + virtualNumber;
        }


        function showSubOptions(select) {
            var bankOptions = document.getElementById('bank-options');
            var bcaVirtualAccount = document.getElementById('bca-virtual-account');

            if (select.value === 'bank') {
                var bankSelect = document.getElementById('bank-select');

                // ini buat pas setiap option yang dipilih itu transfer bank
                // maka dicek value select nya apa trus dikasi va sesuai banknya
                if(bankSelect.value == "bni") {
                    virtualNumber = "BNI0012010111"
                } else if (bankSelect.value == "bca") {
                    virtualNumber = "BCA0012010111"
                } else if (bankSelect.value == "mandiri") {
                    virtualNumber = "MANDIRI0012010111"
                }

                // buat nampilin
                bankOptions.style.display = 'block';
                bcaVirtualAccount.style.display = "block"
                bcaVirtualAccount.textContent = 'Virtual Account Number: ' + virtualNumber;
            } else {
                var bcaVirtualAccount = document.getElementById('bca-virtual-account');
                bcaVirtualAccount.style.display = "none"
                bankOptions.style.display = 'none';
            }
        }

        function submitPayment() {
            var paymentMethod = document.getElementById('payment-method').value;
            var selectedBank = document.getElementById('bank-select').value;
            
            // pengkondisian sesuai metode bayar
            if (paymentMethod == "bank") {
                alert('Payment Method: ' + paymentMethod + '\nSelected Bank: ' + selectedBank + '\nVA Number: ' + virtualNumber);
            } else {
                alert('Payment Method: ' + paymentMethod);
            }
        }
    </script>

    <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>

</body>

</html>
