<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap error page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css2?family=Cardo&amp;family=Lemonada:wght@300&amp;display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #3B3B98;
            font-family: 'Cardo', serif;

        }

        .row {
            margin: 0;
        }

        a {
            background-color: #182C61;
            border: 0px;
            text-decoration: none;
            padding: 10px;
            color: #fff;
            font-family: 'Lemonada', cursive;

        }

        a:hover {
            text-decoration: none;
            color: #fff;
            background-color: #0c2461;
        }

        h1 {
            font-size: 180px;
        }

        h4 {
            padding-bottom: 20px;
            font-family: 'Lemonada', cursive;

        }

        p {
            font-family: 'Lemonada', cursive;
            text-align: center;

        }
    </style>
</head>

<body>
<div class="row">
    <div class="col-md-12 d-flex flex-column justify-content-center align-items-center text-white vh-100">
        <h4>"Invalid Credentials!"</h4>
        <a href="login.jsp">Back To Login</a>
    </div>
</div>


</body>
</html>