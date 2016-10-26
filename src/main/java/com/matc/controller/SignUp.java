package com.matc.controller;

import com.matc.entity.User;
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
 * Created by student on 9/22/16.
 */
@WebServlet(
        urlPatterns = {"/signup"}
)
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();

        //User newUser = new User(request.getParameter("user_name"));
        String username = request.getParameter("create_userName");
        String password = request.getParameter("create_password");
        String email = request.getParameter("new_email");

        User newUser = new User(username, email, password);
        Integer userId = userDao.addUser(newUser);

        session.setAttribute("userID", userId);
        session.setAttribute("userName", userDao.getUser(userId).getUserName());
        //User userData = new User();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
        //dispatcher.forward(request, response);

    }

}
