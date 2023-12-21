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

    <!-- My Style -->
    <link rel="stylesheet" href="style.css" />

    <!-- Fonts Google -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,700;1,500&display=swap"
        rel="stylesheet" />

    <title>Registrasi Page</title>
</head>

<body>
    <section class="register d-flex">
        <!-- Other HTML content remains the same -->

        <!-- Button trigger modal -->
        <button type="button" class="masuk btn" onclick="registerUser()">
            Masuk
        </button>

        <!-- Other HTML content remains the same -->
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

    <script>
        function registerUser() {
            var firstName = document.getElementById('namadepan').value;
            var lastName = document.getElementById('namabelakang').value;
            var phoneNumber = document.getElementById('nomortelepon').value;
            var emergencyNumber = document.getElementById('nomorkontakdarurat').value;
            var age = document.getElementById('umur').value;
            var email = document.getElementById('email').value;
            var password = document.getElementById('katasandi').value;
            var address = document.getElementById('alamatlengkap').value;

            // Create an object with the user data
            var userData = {
                firstName: firstName,
                lastName: lastName,
                phoneNumber: phoneNumber,
                emergencyNumber: emergencyNumber,
                age: age,
                email: email,
                password: password,
                address: address
            };

            // Make a POST request to the '/register' endpoint
            fetch('/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userData),
            })
            .then(response => {
                if (response.ok) {
                    // If registration is successful, show success modal and redirect
                    var successModal = new bootstrap.Modal(document.getElementById('successModal'));
                    successModal.show();
                    setTimeout(function () {
                        window.location.href = 'indexkonfirmasi.html';
                    }, 2000);
                } else {
                    // If there's an error, show error modal
                    var errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
                    errorModal.show();
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }
    </script>
</body>

</html>
