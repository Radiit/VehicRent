<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Vehic Rent</title>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}resources/style/style2.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
      <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

    </head>

    <body>

      <section id="header">
        <a href="#"><img src="${pageContext.request.contextPath}/resources/img/logo.svg" alt="Logo"></a>
        <div>
          <ul id="navbar">
            <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/shop">Vehicle List</a></li>
            <li><a class="active" href="${pageContext.request.contextPath}/history">Rental History</a></li>
            <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
            <li>
              <input type="text" placeholder="Search here "><i class="fa-solid fa-magnifying-glass"
                style="color: #000000;"></i>
            </li>
            <li id="lg-bag"><a th:href="@{/cart}"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
            </li>
            <li><a th:href="@{/notif}"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
            <li><a th:href="@{/profile}"><i class="fa-regular fa-user" style="color: #000000;"></i></a></li>
            <a href="#" id="close"><i class="fa-solid fa-xmark" style="color: #000000;"></i></a>
          </ul>
        </div>
        <div id="mobile">
          <a th:href="@{/cart}"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
          <i id="bar" class="fas fa-outdent"></i>
        </div>
      </section>

      <section id="history" class="seksi-p1">
        <div class="container" id="blur">
          <h1><strong>ORDER HISTORY</strong></h1>

          <!-- Loop through the listTransaksi to generate card containers dynamically -->
          <c:forEach var="transaksi" items="${listTransaksi}">
            <div class="container">
              <div class="card mb-3 p-4" style="max-width: 100%; height:100%;">
                <div class="row g-0">
                  <div class="col-md-4 d-flex align-items-center px-2">
                    <!-- Adjust these fields based on your Transaksi model -->
                    <img
                      src="${pageContext.request.contextPath}${transaksi.kendaraan.mainImage}"
                      class="img-fluid" alt="" width="250px">
                  </div>
                  <div class="col-md-8">
                    <div class="card-body">
                      <!-- Adjust these fields based on your Transaksi model -->
                      <h3 class="card-title">
                        <c:out value="${transaksi.kendaraan.jenisKendaraan}" />
                      </h3>
                      <p class="card-text">
                        <c:out value="${transaksi.rentDateStart} - ${transaksi.rentDateEnd} - ${transaksi.idTransaksi}" />
                      </p>
                      <p class="card-text">
                        <c:out value="${transaksi.kendaraan.merkKendaraan}" />
                      </p>
                      <h4 class="card-text">
                        <c:out value="${transaksi.hargaTotal}" />
                      </h4>
                      <div class="d-flex justify-content-between align-items-center">
                        <!-- Check condition here for adding class based on a condition -->
                        <c:choose>
                          <c:when test="${transaksi.status eq 'WaitingPayment'}">
                            <h5 class="card-text special-class"><strong>Status: <span style="color: #FFA500;">Waiting
                                  for Payment</span></strong></h5>
                            <button onclick='updateStatus("${transaksi.idTransaksi}", "Done")'>Payment</button>
                          </c:when>
                          <c:when test="${transaksi.status eq 'Done'}">
                            <h5 class="card-text"><strong>Status: <span style="color: green;">Done</span></strong></h5>
                            <a href="${pageContext.request.contextPath}/something"><button>Rate</button></a>
                          </c:when>
                          <c:when test="${transaksi.status eq 'OnGoing'}">
                            <h5 class="card-text"><strong>Status: <span style="color: green;">On Going</span></strong></h5>
                            <a href="${pageContext.request.contextPath}/something"><button>Done</button></a>
                          </c:when>
                          <c:when test="${transaksi.status eq 'Canceled'}">
                            <h5 class="card-text"><strong>Status: <span style="color: red;">Canceled</span></strong></h5>
                            <a href="${pageContext.request.contextPath}/something"><button>Rent Again</button></a>
                          </c:when>
                          <c:otherwise>
                            <h5 class="card-text"><strong>Status: <span style="color: #FFA500;">Another
                                  Status</span></strong></h5>
                          </c:otherwise>
                        </c:choose>

                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>


          <!-- End loop -->

        </div>
      </section>

      <!-- Rate card -->
      <div id="rate-card">
        <h3>Please Rate Your Order</h3>
        <!-- Add more content as needed -->
        <form action="#" class="form-container">
          <div class="rating">
            <input type="number" name="rating" hidden>
            <i class='bx bx-star star' style="--i: 0;"></i>
            <i class='bx bx-star star' style="--i: 1;"></i>
            <i class='bx bx-star star' style="--i: 2;"></i>
            <i class='bx bx-star star' style="--i: 3;"></i>
            <i class='bx bx-star star' style="--i: 4;"></i>
          </div>
          <textarea name="opinion" cols="30" rows="5" placeholder="Your opinion..."></textarea>
        </form>
        <a href="#" onclick="toggleRateCard()"><button>Cancel</button></a>
        <a href="#" onclick="toggleRateCard()"><button>Submit</button></a>

      </div>

      <!-- Done card -->
      <div id="done-card">
        <h3>Are You Sure?</h3>
        <!-- Add more content as needed -->
        <a href="#" onclick="toggleDoneCard()"><button>Cancel</button></a>
        <a href="#" onclick="toggleDoneCard()"><button>Done</button></a>
      </div>

      <script>
        function toggleRateCard() {
          var blur = document.getElementById('blur');
          blur.classList.toggle('active');
          var rateCard = document.getElementById('rate-card');
          rateCard.style.display = (rateCard.style.display === 'none' || rateCard.style.display === '') ? 'block' : 'none';
        }

        function toggleDoneCard() {
          var blur = document.getElementById('blur');
          blur.classList.toggle('active');
          var doneCard = document.getElementById('done-card');
          doneCard.style.display = (doneCard.style.display === 'none' || doneCard.style.display === '') ? 'block' : 'none';
        }
      </script>

      <script src="${pageContext.request.contextPath}resources/script/script.js" async defer></script>
      <script src="${pageContext.request.contextPath}resources/script/script1.js" async defer></script>
      <script> 
        function updateStatus(idTransaksi, status) {
          const form = new FormData();
          form.append('status', status);
          fetch('${pageContext.request.contextPath}/dashboard/transaksi/status/' + idTransaksi, {
            method: 'POST',
            
            body: form
          }).then(response => {
            if (response.ok) {
              return response.json()
            }
            throw new Error(response.statusText)
          }).then(data => {
            console.log(data)
            window.location.reload()
          }).catch(error => {
            console.error('Error:', error)
          })
        };
      </script>

    </body>

    </html>