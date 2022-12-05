package com.nagarro.commercewebapp.servlets;

import com.nagarro.commercewebapp.constants.Constants;
import com.nagarro.commercewebapp.dao.FactoryProvider;
import com.nagarro.commercewebapp.dao.ProductDao;
import com.nagarro.commercewebapp.dao.UserDao;
import com.nagarro.commercewebapp.models.Product;
import com.nagarro.commercewebapp.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("uname");
        String userPassword = request.getParameter("password");

        UserDao userDao = new UserDao(FactoryProvider.getSession());
        User user = userDao.getUserByEmailAndPassword(userName, userPassword);
        HttpSession httpSession = request.getSession();

        if (user == null) {
            httpSession.setAttribute("message", "Invalid credentials!!!");
            response.sendRedirect(Constants.INDEX_PAGE);
        } else {
            httpSession.setAttribute(Constants.USER_SESSION_ATTRIBUTE, user);
            ProductDao productDao = new ProductDao(FactoryProvider.getSession());
            List<Product> products = productDao.getAllProducts();
            request.setAttribute("list", products);
            response.sendRedirect(Constants.PRODUCTS_PAGE);
        }

    }
}

























