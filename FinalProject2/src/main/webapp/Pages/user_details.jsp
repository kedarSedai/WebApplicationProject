<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2021
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserDetails</title>
</head>
<body>
<table width="100%">
    <tr>
        <td> <b>id</b> </td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td> <b>Full name</b> </td>
        <td>${user.fullname}</td>
    </tr>
    <tr>
        <td> <b>Username</b> </td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td> <b>Password</b> </td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td> <b>Role</b> </td>
        <td>${user.role}</td>
    </tr>
    <tr>
        <td> <a href="user?page=userEdit&id=${user.id}"> Edit </a> </td>
        <td> <a href="user?page=deleteUser&id=${user.id}"> Delete </a></td>
    </tr>

</table>

</body>
</html>
