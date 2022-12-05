<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>
    <link rel="stylesheet" href="css/Registration.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<div class="container">
    <form action="RegisterServlet" method="post">
        <table class="formTable">
            <thead>
            <tr>
                <th> Registration</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style="padding-left: 1vw;"><label for="fname">First Name : </label></td>
                <td>
                    <input type="text" name="fname" id="fname">
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td style="padding-left: 1vw;"><label for="lname">Last Name : </label></td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="lname" id="lname">--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td style="padding-left: 1vw;"><label for="uname">Username : </label></td>
                <td>
                    <input type="text" name="uname" id="uname">
                </td>
            </tr>
            <tr>
                <td style="padding-left: 1vw;"><label for="email">Email Id : </label></td>
                <td>
                    <input type="email" name="email" id="email">
                </td>
            </tr>
            <tr>
                <td style="padding-left: 1vw;"><label for="password">Password : </label></td>
                <td>
                    <input type="password" name="password" id="password">
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td style="padding-left: 1vw;"><label for="cnfPassword">Confirm Password : </label></td>--%>
<%--                <td>--%>
<%--                    <input type="password" name="cnfpassword" id="cnfPassword">--%>
<%--                </td>--%>
<%--            </tr>--%>
            </tbody>
            <tfoot>
            <tr>
                <td></td>
                <td class="registerButton"><input type="submit" value="Register > " class="btn btn-success btn-sm"></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>

</body>
</html>