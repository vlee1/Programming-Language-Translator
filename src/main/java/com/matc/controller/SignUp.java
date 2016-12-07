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
        GenericDao<User> userGenericDao = new GenericDao<>(User.class);

        //User newUser = new User(request.getParameter("user_name"));
        String username = request.getParameter("create_userName");
        String password = request.getParameter("create_password");
        String email = request.getParameter("new_email");

        User newUser = new User(username, email, password);
        int userId = userGenericDao.create(newUser);

        session.setAttribute("userID", userId);
        session.setAttribute("userName", userGenericDao.getById(userId).getUserId());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
        dispatcher.forward(request, response);

    }

}
