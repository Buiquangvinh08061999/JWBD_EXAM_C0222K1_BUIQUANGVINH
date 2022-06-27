<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/26/2022
  Time: 9:30 PM
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
        .success{
            margin-top: 36px;
            color: #35895c
        }
        .errors{
            margin-top: 36px;
            color: #c64c5e
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-9 mt-3">
            <h1>Edit Student</h1>
        </div>

    </div>
    <form method="post">
        <fieldset class="row">

            <div class="col-sm-12 mt-3">
                <label>Full name</label>
                <input type="text" placeholder="Enter name" class="form-control" name="fullname" value="${student.fullname}">
            </div>

            <div class="col-sm-12 mt-3">
                <label>Email</label>
                <input type="email" placeholder="Enter email" class="form-control" name="email" value="${student.email}" >
            </div>

            <div class="col-sm-12 mt-3">
                <label>Date of Birth</label>
                <input type="date"  placeholder="Enter date of birth as DD/MM/YYYY"class="form-control" name="birth" required value="${student.birth}">
            </div>

            <div class="col-sm-12 mt-3">
                <label>Address</label>
                <input type="text" placeholder="Enter Addres" class="form-control" name="address" required value="${student.address}" >
            </div>

            <div class="col-sm-12 mt-3">
                <label>Phone Number</label>
                <input type="text" placeholder="Enter phone number" class="form-control" name="phone" required value="${student.phone}">
            </div>

            <div class="col-sm-12 mt-3">
                <label>ClassId</label>
                <select name="classId"  class="form-control" id="classId" required value="${student.classId}">
                    <option value="1">C0222K1</option>
                    <option value="2">C0222H1</option>
                    <option value="3">C0322H1</option>
                    <option value="4">12B3</option>
                </select>
            </div>

            <div class="col-sm-2 mt-3">
                <button type="submit" class="btn btn-success waves-effect waves-light"> Update user </button>
            </div>
            <div class="col-sm-2 mt-3">
                <a href="/product">
                    <button type="button" class="btn btn-secondary">Black</button>
                </a>
            </div>

        </fieldset>
    </form>
    <c:forEach items="${requestScope['errors']}" var="item">
        <ul class="errors">
            <li>${item}</li>
        </ul>
    </c:forEach>

    <div class="">
        <c:if test="${requestScope['success'] == true}">
            <ul class="success">
                <li>Thêm mới thành công</li>
            </ul>
        </c:if>
    </div>

</div>
</div>
</body>
</html>
