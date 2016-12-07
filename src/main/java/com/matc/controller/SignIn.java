package com.matc.controller;

import com.matc.entity.User;
import com.matc.persistence.GenericDao;
import com.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by student on 12/7/16.
 */

public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();

        //User newUser = new User(request.getParameter("user_name"));
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        String foundUsername = userDao.getUserByUserName(username).getUserName();
        String foundPassword = userDao.getUserByUserName(username).getUserPassword();

        if (foundUsername != null && foundPassword != null) {

            session.setAttribute("userID", userDao.getUserByUserName(username).getUserId());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/signIn.html");
            dispatcher.forward(request, response);
        }
    }
}
