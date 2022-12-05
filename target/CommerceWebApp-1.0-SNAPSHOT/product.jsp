<%@page import="java.sql.Blob" %>
<%@page import="com.nagarro.commercewebapp.models.*" %>
<%@page import="com.nagarro.commercewebapp.dao.*" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/homePage.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    User user = (User) session.getAttribute("current-user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<nav class="navbar navbar-dark bg-dark row" style="background-color: #e3f2fd;">
    <!-- Navbar content -->
    <div class="mx-auto order-0 col-10">
        <h1 class="text-center text-white">Product Management Tool</h1>
    </div>
    <div class="d-inline float-right col-2">
        <div class="row">
            <div class="col-5">
                <p class="text-white pt-2">Hi,
                    <%
                        if (user != null) {
                            out.println(user.getName());
                        }
                    %>
                </p>
            </div>
            <div class="col-7">
                <a href="LogoutServlet">
                    <button type="button" class="btn btn-outline-danger"><i class="bi bi-box-arrow-right"></i> Logout
                    </button>
                </a>
            </div>
        </div>
    </div>
</nav>

<div class="content">
    <h5>Please enter product details to add to stock</h5>


    <form action="ProductServlet" method="post" enctype="multipart/form-data">
        <table class="form">
            <tr>
                <td><label for="title">Title</label></td>
                <td><input type="text" id="title" name="title" class="form-control" required></td>
            </tr>
            <tr>
                <td><label for="quantity">Quantity</label></td>
                <td><input type="text" id="quantity" name="quantity" class="form-control" required></td>
            </tr>
            <tr>
                <td><label for="size">Size</label></td>
                <td><input type="text" id="size" name="size" class="form-control" required></td>
            </tr>
            <tr>
                <td><label for="image">Image</label></td>
                <td><input type="file" id="image" class="form-control-file" accept="image/*" name="image" required></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" class="btn btn-primary btn-block"></td>
            </tr>
        </table>
    </form>


    <br>
    <br>

    <table class="table table-bordered table-hover">

        <thead class="thead-dark">
        <tr>
            <th>S. No.</th>
            <th>Title</th>
            <th>Quantity</th>
            <th>Size</th>
            <th>Image</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>

        </tr>

        <%
            ProductDao dao = new ProductDao(FactoryProvider.getSession());
            List<Product> list = null;

            list = dao.getAllProducts();

            for (Product product : list) {
        %>
        <tr>
            <td><%=product.getId() %>
            </td>
            <td><%=product.getTitle() %>
            </td>
            <td><%=product.getQuantity() %>
            </td>
            <td><%=product.getSize() %>
            </td>
            <td><img alt="..." style="max-height:200px; max-width:100px; width:auto;"
                     src="img/products/<%= product.getImage()%>" class="card-img-top m-2"></td>
            <td>
<%--                <a href="UpdateServlet?id=<%=product.getId() %>">--%>
<%--                    <button type="button" class="btn btn-outline-warning"><i class="bi bi-pen-fill"></i></button>--%>
<%--                </a>--%>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="DeleteServlet?id=<%=product.getId() %>">
                    <button type="button" class="btn btn-outline-danger"><i class="bi bi-trash-fill"></i></button>
                </a>
            </td>
        </tr>

        <%
            }

        %>


        </tbody>
    </table>
</div>
</body>
</html>
