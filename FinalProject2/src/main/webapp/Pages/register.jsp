<html>

<head>
    <link rel="stylesheet" href="CSS/Register.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Register</title>
</head>

<body>
<div class="main">
    <p class="register" align="center">Register</p>
    <form class="form1" action="user?page=register" method="post">
        <input class="un " id = "username" name = "username" type="text" align="center" placeholder="Username">
        <input class="fn" id = "fullname" name="fullname" type="text" align="center" placeholder="Fullname">
        <input class="pass" id = "password" name="password" type="password" align="center" placeholder="Password">
        <input class="role" id = "role" name="role" type="text" align="center" placeholder="Role">
        <input class="submit" type="submit" value="Register">
    </br>
        <p align="center"> <a href="user?page=index">Already registered?Login</a></p>

    </form>
</div>



</body>
</html>


