<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2021
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%@include file="../Includes/sidebar.jsp"%>
<table width="100%">
    <tr>
        <th>id</th>
        <th>FullName</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>

    </tr>
    <c:forEach items="${userList}" var="user">
    <tr>
        <td> ${user.id}</td>
        <td> ${user.fullname} </td>
        <td> ${user.username} </td>
        <td> ${user.password}</td>
        <td> ${user.role} </td>
        <td> <a href="user?page=userDetails&id=${user.id}"> View Details </a> </td>
    </tr>
    </c:forEach>
    <tr>
        <td> <a href="user?page=newUsers"> Add New User</a> </td>
    </tr>

</table>

</body>
</html>
