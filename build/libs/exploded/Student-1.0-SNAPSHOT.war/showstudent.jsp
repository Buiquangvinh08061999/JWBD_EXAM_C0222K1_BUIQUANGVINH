<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px solid black">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Dob</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach begin="1" end="5" var="x">
            <tr>
                <td>1</td>
                <td>Bui Quang Vinh</td>
                <td>Male</td>
                <td>08-06-1999</td>
                <td>
                    <a href="">Update</a>
                    <a href="">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
