package com.nagarro.commercewebapp.servlets;

import com.nagarro.commercewebapp.constants.Constants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute(Constants.USER_SESSION_ATTRIBUTE);
        httpSession.setAttribute("message", "Logged Out Successfully!");
        response.sendRedirect(Constants.LOGIN_PAGE);
    }

}
