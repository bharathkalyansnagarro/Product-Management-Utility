<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reset Pasword</title>
    <link rel="stylesheet" href="css/ResetPassword.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


<div class="container">
    <form action="ResetServlet" method="post">
        <table class="formTable">
            <thead>
            <tr>
                <th> Reset Password</th>
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
                <td style="padding-left: 1vw;"><label for="email">Email Id : </label></td>
                <td>
                    <input type="email" name="email" id="email">
                </td>
            </tr>
            <tr>
                <td style="padding-left: 1vw;"><label for="password">New Password : </label></td>
                <td>
                    <input type="password" name="password" id="password">
                </td>
            </tr>
            <tr>
                <td style="padding-left: 1vw;"><label for="cnfPassword">Confirm Password : </label></td>
                <td>
                    <input type="password" name="cnfpassword" id="cnfPassword">
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td></td>
                <td class="registerButton"><input type="submit" value="Reset" class="btn btn-success btn-sm"></td>
            </tr>
            </tfoot>
        </table>
    </form>
</div>

</body>
</html>