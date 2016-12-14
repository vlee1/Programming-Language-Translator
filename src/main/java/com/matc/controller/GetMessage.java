package com.matc.controller;

import com.matc.entity.Message;
import com.matc.persistence.GenericDao;
import com.matc.persistence.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by student on 12/13/16.
 */
@WebServlet("/GetMessage")
public class GetMessage extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Message> messageGenericDao = new GenericDao<>(Message.class);
        Message message = null;

        String messageId = req.getParameter("messageId");

        if (messageId != null) {

            if (messageGenericDao.getById(Integer.parseInt(messageId)) != null) {

                message = messageGenericDao.getById(Integer.parseInt(messageId));

                resp.setContentType("text/plain");
                resp.getWriter().write(message.getDescription());
            } else {
                resp.setContentType("text/plain");
                resp.getWriter().write("Message does not exist");
            }
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().write("Null parameter");
        }
    }
}
