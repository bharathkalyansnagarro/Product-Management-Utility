package com.nagarro.commercewebapp.servlets;

import com.nagarro.commercewebapp.constants.Constants;
import com.nagarro.commercewebapp.dao.FactoryProvider;
import com.nagarro.commercewebapp.dao.ProductDao;
import com.nagarro.commercewebapp.models.Product;
import com.nagarro.commercewebapp.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current-user");
        if (user == null) {
            response.sendRedirect(Constants.LOGIN_PAGE);
        } else {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                ProductDao productDao = new ProductDao(FactoryProvider.getSession());
                Product product = productDao.getProductById(id);
//                productDao.deleteProduct(id);

                String title = request.getParameter(Constants.TITLE_ATTRIBUTE);
                int quantity = Integer.parseInt(request.getParameter(Constants.QUANTITY_ATTRIBUTE));
                String size = request.getParameter(Constants.SIZE_ATTRIBUTE);
                String image = request.getParameter(Constants.IMAGE_URL_ATTRIBUTE);
                productDao.updateProduct(id + "", title, quantity, size, image);
//                product.setTitle(request.getParameter("title"));
//                product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
//                product.setSize(request.getParameter("size"));
//                product.setImage(request.getParameter("image"));
//                productDao.saveProduct(product);

            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect(Constants.PRODUCTS_PAGE);
        }
    }
}
