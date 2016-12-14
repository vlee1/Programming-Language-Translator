package com.matc.controller;

import com.matc.entity.Message;
import com.matc.entity.User;
import com.matc.persistence.GenericDao;
import com.matc.persistence.MessageDao;
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
@WebServlet (
        name = "profile",
        urlPatterns = {"/profile"}
)
public class SignInSignUp extends HttpServlet {

    /**
     *  Handles HTTP POST requests from signup form.
     *
     *@param  request               an httpServlet request
     *@param  response              an httpServlet response
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        MessageDao messageDao = new MessageDao();


        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        List<Message> messages = messageDao.getMessagesByUserName(username);
        User user = userDao.getUserByUserName(username);

        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setAttribute("user", user);
        session.setAttribute("messages", messages);
        session.setAttribute("messageDao", messageDao);

        String url = "/user.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);


    }

}
