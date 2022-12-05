package com.nagarro.commercewebapp.servlets;

import com.nagarro.commercewebapp.constants.Constants;
import com.nagarro.commercewebapp.dao.FactoryProvider;
import com.nagarro.commercewebapp.dao.ProductDao;
import com.nagarro.commercewebapp.models.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setTitle(request.getParameter(Constants.TITLE_ATTRIBUTE));
        product.setQuantity(Integer.parseInt(request.getParameter(Constants.QUANTITY_ATTRIBUTE)));
        product.setSize(request.getParameter(Constants.SIZE_ATTRIBUTE));

        Part part = request.getPart(Constants.IMAGE_URL_ATTRIBUTE);
        product.setImage(part.getSubmittedFileName());

        ProductDao productDao = new ProductDao(FactoryProvider.getSession());
        productDao.saveProduct(product);

        try {

            String path = "C:\\Users\\bharathkalyan\\IdeaProjects\\Nagarro\\CommerceWebApp\\src\\main\\webapp\\img\\products\\" + part.getSubmittedFileName();

            FileOutputStream fos = new FileOutputStream(path);

            InputStream is = part.getInputStream();

            byte[] data = new byte[is.available()];
            is.read(data);

            //writing the data
            fos.write(data);
            fos.close();

        } catch (Exception e) {
            response.getWriter().println("Error while copying the image to local folder!!");
            e.printStackTrace();
        }


        HttpSession httpsession = request.getSession();
        httpsession.setAttribute("message", "Product added successfully:");
        response.sendRedirect(Constants.PRODUCTS_PAGE);
    }


}
