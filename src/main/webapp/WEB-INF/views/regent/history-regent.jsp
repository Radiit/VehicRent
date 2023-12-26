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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

  </head>

  <body>

    <section id="header">
      <a href="#"><img src="${pageContext.request.contextPath}resources/img/logo.svg" class="logo"></a>
      <div>
          <ul id="navbar">
              <li><a href="${pageContext.request.contextPath}/home-regent">Home</a></li>
              <li><a href="${pageContext.request.contextPath}/list-regent">Vehicle List</a></li>
              <li><a class="active" href="${pageContext.request.contextPath}/history-regent">Rental History</a></li>
              <li><a href="${pageContext.request.contextPath}/register-vehicle">Register Vehicle</a></li>
              <li><a href="language.html"><i class="fas fa-globe" style="color: #000000;"></i></a></li>
              <li>
                  <input type="text" placeholder="Search here " ><i class="fa-solid fa-magnifying-glass" style="color: #000000;"></i>
              </li>
              <li id="lg-bag"><a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a></li>
              <li><a href="notif.html"><i class="fa-regular fa-envelope" style="color: #000000;"></i></a></li>
              <li><a href="profile.html"><i class="fa-regular fa-user" style="color: #000000;"></i></a></li>
              <li><a href="#" onclick="toggleLogOut()"><button>Logout</button></a></li>
              <a href="#" id="close"><i class="fa-solid fa-xmark" style="color: #000000;"></i></a>
          </ul>
      </div>
      <div id="mobile">           
          <a href="cart.html"><i class="fa-solid fa-cart-shopping" style="color: #000000;"></i></a>
          <i  id="bar" class="fas fa-outdent"></i>"></i>
      </div>
    </section>
    
    <section id="history" class="seksi-p1">
      
      <div class="container" id = "blur">
        <h1><strong>ORDER HISTORY</strong></h1>

        <div class="container">
          <div class="card mb-3 p-4" style="max-width: 100%; height:100%;">
            <div class="row g-0">
              <div class="col-md-4 d-flex align-items-center px-2">
                <img src="${pageContext.request.contextPath}resources/img/mobilmewah.jpg" class="img-fluid" alt="" width=250px>
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h3 class="card-title">BMX</h3>
                  <p class="card-text">02/12/23 - 04/12/23</p>
                  <p class="card-text">2 Hari</p>
                  <h4 class="card-text">Rp 1000.000</h4>
                  <div class="d-flex justify-content-between align-items-center">
                    <h5 class="card-text"><strong>Status: <span style="color: #FFA500;">Waiting for Payment</span></strong></h5>
                    <a href="#" onclick="toggleDoneCard()"><button>Payment</button></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="container">
          <div class="card mb-3 p-4" style="max-width: 100%; height:100%;">
            <div class="row g-0">
              <div class="col-md-4 d-flex align-items-center px-2">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/m4.jpg" class="img-fluid" alt="" width=250px>
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h3 class="card-title">New Inova G Type</h3>
                  <p class="card-text">02/12/23 - 04/12/23</p>
                  <p class="card-text">2 Hari</p>
                  <h4 class="card-text">Rp 600.000</h4>
                  <div class="d-flex justify-content-between align-items-center">
                    <h5 class="card-text"><strong>Status: <span style="color: green;">On Going</span></strong></h5>
                    <a href="#" onclick="toggleDoneCard()"><button>Done</button></a> 
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="container">
          <div class="card mb-3 p-4" style="max-width: 100%; height:100%;">
            <div class="row g-0">
              <div class="col-md-4 d-flex align-items-center px-2">
                <img src="${pageContext.request.contextPath}resources/img/mobilkeluarga.jpg" class="img-fluid" alt="" width=250px>
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h3 class="card-title">Toyota Avanza</h3>
                  <p class="card-text">02/12/23 - 04/12/23</p>
                  <p class="card-text">2 Hari</p>
                  <h4 class="card-text">Rp 1000.000</h4>
                  <div class="d-flex justify-content-between align-items-center">
                    <h5 class="card-text"><strong>Status: <span style="color: green;">Done</span></strong></h5>
                    <a href="#" onclick="toggleRateCard()"><button>Details Order</button></a> 
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="container">
          <div class="card mb-3 p-4" style="max-width: 100%; height:100%;">
            <div class="row g-0">
              <div class="col-md-4 d-flex align-items-center px-2">
                <img src="${pageContext.request.contextPath}resources/img/kendaraan/m4.jpg" class="img-fluid" alt="" width=250px>
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h3 class="card-title">New Inova G Type</h3>
                  <p class="card-text">30/11/23 - 01/12/23</p>
                  <p class="card-text">1 Hari</p>
                  <h4 class="card-text">Rp 600.000</h4>
                  <div class="d-flex justify-content-between align-items-center">
                    <h5 class="card-text"><strong>Status: <span style="color: red;">Canceled</span></strong></h5>
                    <button>Details Order</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      
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
          </input>
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
      <a href="history.html" onclick="toggleDoneCard()"><button>Done</button></a>
    </div>

    <!-- logout card -->
    <div id="logout-card">
      <h3>Are You Sure?</h3>
      <!-- Add more content as needed -->
      <a href="#" onclick="toggleLogOut()"><button>Cancel</button></a>
      <a href="login.html" onclick="toggleLogOut()"><button>Logout</button></a>
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

      //TOGGLE LOGOUT
      function toggleLogOut() {
        var blur = document.getElementById('blur');
        blur.classList.toggle('active');
        var logoutCard = document.getElementById('logout-card');
        logoutCard.style.display = (logoutCard.style.display === 'none' || logoutCard.style.display === '') ? 'block' : 'none';
      }    

    </script>

    <script src="script.js" async defer></script>
    <script src="script1.js" async defer></script>

  </body>
</html>