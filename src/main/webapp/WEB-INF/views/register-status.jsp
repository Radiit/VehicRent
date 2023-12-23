<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Halaman Status Register</title>
    <!-- Tambahkan link ke CSS atau Bootstrap jika diperlukan -->
</head>
<body>
    <div class="container">
        <h2>Status Register</h2>
        
        <%-- Ambil parameter dari request --%>
        <% String status = (String)request.getAttribute("status"); %>

        <%-- Tampilkan status register --%>
        <div class="alert alert-info" role="alert">
            <strong>Status Register:</strong> <%= status %>
        </div>

        <%-- Tambahkan elemen HTML atau CSS sesuai kebutuhan --%>
    </div>

    <!-- Tambahkan skrip JavaScript atau jQuery jika diperlukan -->

    <!-- Tambahkan link ke Bootstrap atau skrip JavaScript jika diperlukan -->
</body>
</html>
