<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<html>
<head>
    <!-- Your existing head content -->
</head>
<body>
    <!-- Your existing container and row -->
    <div class="col py-3">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Nama</th>
                        <th scope="col">Role</th>
                        <th scope="col">Aksi</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    List<Map<String, Object>> dataList = (List<Map<String, Object>>)request.getAttribute("dataList");
                    if (dataList != null) {
                        for (Map<String, Object> data : dataList) {
                    %>
                        <tr>
                            <th scope="row"><%= data.get("no") %></th>
                            <td><%= data.get("nama") %></td>
                            <td><%= data.get("role") %></td>
                            <td><%= data.get("aksi") %></td>
                            <td><%= data.get("status") %></td>
                        </tr>
                    <%
                        }
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>