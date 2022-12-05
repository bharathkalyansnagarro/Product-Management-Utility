package com.nagarro.commercewebapp.servlets;

import com.nagarro.commercewebapp.constants.Constants;
import com.nagarro.commercewebapp.dao.FactoryProvider;
import com.nagarro.commercewebapp.dao.ProductDao;
import com.nagarro.commercewebapp.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.USER_SESSION_ATTRIBUTE);
        if (user == null) {
            response.sendRedirect(Constants.LOGIN_PAGE);
        } else {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                ProductDao productDao = new ProductDao(FactoryProvider.getSession());
                productDao.deleteProduct(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect(Constants.PRODUCTS_PAGE);
        }
    }
}
