<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/26/2022
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link href="\assetsa\css\bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-stylesheet">
    <link href="\assetsa\css\icons.min.css" rel="stylesheet" type="text/css">
    <link href="\assetsa\css\app.min.css" rel="stylesheet" type="text/css" id="app-stylesheet">

    <style>
        table thead{
           background-color: #87918d;
            color: white;
            text-align: center;
        }
        table tbody{
            text-align: center;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-9 mt-3">
            <a href="/product?action=create">
                <button type="button" class="btn btn-success">Add Product
            </button></a>
        </div>
        <div class="col-3 mt-3">
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"> <i class="fas fa-search"></i></button>
            </form>
        </div>
    </div>
    <div class="row mt-3">
        <table class="table table-hover table-bordered table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>FullName</th>
                <th>Birth</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>CityId</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listS}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.fullname}</td>
                <td>${item.birth}</td>
                <td>${item.address}</td>
                <td>${item.phone}</td>
                <td>${item.email}</td>
                <td>${item.name}</td>
                <td>
                    <a href="/product?action=edit&id=${item.id}"><button><i class="fa-solid fa-marker"></i></button></a>
                </td>
                <td>
                    <a href="#" onclick="showMess(${item.id})"><button type="button"><i class="fa-solid fa-trash-can"></i></button></a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>

    function showMess(id){
        var option = confirm("Bạn có chắc chắn muốn xóa ID số " + id + " này không?")
        if(option === true){
            window.location.href ='product?action=delete&sid=' + id;
        }
    }

</script>
</body>
</html>
