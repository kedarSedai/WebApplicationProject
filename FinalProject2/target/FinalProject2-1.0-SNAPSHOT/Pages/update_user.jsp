<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/31/2021
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<div id="wrapper">

<%--    <%@include file=""%>--%>
    <div class="container">
        <h1> Admin Registration Form</h1>
        <form action="user?page=editUser" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <h3> Srep 1:</h3>
            <div>
                <input type="text" name="fullname" value="${user.fullname}" placeholder="Enter Full Name">
                <input type="text" name="role" value="${user.role}" placeholder="Enter role">

            </div>

            <h3> Step 2 :</h3>
            <div>
                <input type="text" name="username" value="${user.username}" placeholder="Enter a username">
                <input type="password" name="password" value="${user.password}" placeholder="Enter a password">
            </div>

        </form>
    </div>
</div>
<body>

</body>
</html>
