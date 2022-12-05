<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="css/Login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<div class="container">
    <form action="LoginServlet" method="post">
        <table class="form formTable">
            <thead>
            <tr>
                <th> Login</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style="padding-left: 1vw;"><label for="uname">Username : </label></td>
                <td>
                    <input type="text" name="uname" id="uname">
                </td>
            </tr>
            <tr>
                <td style="padding-left: 1vw;"><label for="password">Password : </label></td>
                <td>
                    <input type="password" name="password" id="password">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <%--                    <a href="PasswordReset.jsp">Forgot your password?</a>--%>
                    <a href="Registration.jsp">Sign Up</a>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td></td>
                <td class="loginButton"><input type="submit" value="Login > " class="btn btn-success btn-sm"></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>
</body>
</html>