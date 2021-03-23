<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        <%@include file="/WEB-INF/views/css/style.css"%>
    </style>
    <title>Online Shop</title>

</head>

<body>
    <div class="container">
    <div class="header">Welcome to online Shop</div>

    <form method="POST" action="login">
        <p>
            <input name ="customer" type="text" placeholder="Enter your name">
        </p>
        <input type="checkbox" name="acceptTerms"> I agree with terms of service </input>

        <br>
        <p><input type="submit" value="Enter"></p>
    </form>

    </div>

</body>

</html>