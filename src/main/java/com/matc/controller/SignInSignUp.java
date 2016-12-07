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
import java.util.List;

/**
 * Created by student on 12/7/16.
 */
@WebServlet ( urlPatterns = {"/profile"})
public class SignInSignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();

        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        String newUsername = request.getParameter("create_userName");
        String newPassword = request.getParameter("create_password");
        String newEmail = request.getParameter("new_email");


        User user = null;

        if (username != null && password != null) {
            user = userDao.getUserByUserName(username);

            if (user != null) {
                //  Regular Users
                if (user.getUserPassword() == password) {

                    session.setAttribute("userID", user.getUserId());

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
                    dispatcher.forward(request, response);
                } else {

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/signIn.jsp");
                    dispatcher.forward(request, response);
                }

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/signIn.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            GenericDao<User> userGenericDao = new GenericDao<>(User.class);

            for (User users : userGenericDao.getAll()) {
                if (users.getUserName() != newUsername && users.getUserEmail() != newEmail) {

                    user = new User(newUsername, newEmail, newPassword);
                    int userId = userGenericDao.create(user);

                    session.setAttribute("userID", userId);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/user.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
    }

    private boolean isAdmin(String username) {
        GenericDao<User> users = new GenericDao<>(User.class);

        if (users.getById(1).getUserName() == username) {
            return true;
        }
        return false;
    }
}
