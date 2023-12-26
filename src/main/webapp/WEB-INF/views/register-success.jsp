<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Bootstrap CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />

    <!-- My Style -->
    <link rel="stylesheet" href="style.css" />

    <!-- Fonts Google -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,500&display=swap"
      rel="stylesheet"
    />

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
    <div class="status-container">
      <div class="status-item">
        <div class="header">
          <p>Registration Successful</p>
        </div>
        <div class="body">
          <p>Thank you for registering with us. Please check your email for verification.</p>
        </div>
        <div class="footer">
          <a href="login.jsp" class="btn btn-primary">Login</a>
        </div>
      </div>
    </div>
  </body>

  <!-- Optional JavaScript; choose one of the two! -->

  <!-- Option 1: Bootstrap Bundle with Popper -->
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"
  ></script>

  <!-- Option 2: Separate Popper and Bootstrap JS -->
  <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</html>
