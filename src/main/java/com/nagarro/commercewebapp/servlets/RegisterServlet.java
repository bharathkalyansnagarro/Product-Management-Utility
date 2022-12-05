package com.nagarro.commercewebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.commercewebapp.constants.Constants;
import com.nagarro.commercewebapp.dao.FactoryProvider;
import com.nagarro.commercewebapp.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");

            String fname = request.getParameter("fname");
            String username = request.getParameter("uname");
            String userEmail = request.getParameter("email");
            String userPassword = request.getParameter("password");

            User user = new User(fname, username, userEmail, userPassword);

            Session hibernateSession = FactoryProvider.getSession().openSession();

            Transaction tx = hibernateSession.beginTransaction();

            int userId = (Integer) hibernateSession.save(user);

            tx.commit();
            hibernateSession.close();
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "*Registration SuccessFul !! User id is:" + userId);
            response.sendRedirect(Constants.LOGIN_PAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
