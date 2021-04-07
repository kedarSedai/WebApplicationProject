<html>

<head>
    <link rel="stylesheet" href="CSS/Style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Sign in</title>
</head>

<body>
<div class="main">
    <p class="sign" align="center">Login</p>
<!--     <input type="hidden" name="page" value="login"> -->  
<!--     This above line needs to keep in inside form it always worked whether cookie is disabled or not -->
    <form class="form1" action="user" method="post">
        <input type="hidden" name="page" value="login">
        <input class="un " type="text" name = "username" align="center" placeholder="Username">
        <input class="pass" type="password" name="password" align="center" placeholder="Password">
        <input  class="submit" type ="submit" value="Login" align="center">
        <p class="register" align="center"><a href="user?page=newUsers">Register?</a></p>



</form>
</div>
</body>
</html>


