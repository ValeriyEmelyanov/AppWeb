package com.example.appweb.command.impl;

import com.example.appweb.command.Command;
import com.example.appweb.model.User;
import com.example.appweb.web.UserServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Update user.
 */
public class UpdateUserCommand implements Command {
    @Override
    public String getActionPath() {
        return "/update";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, UserServlet userServlet) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        User user = new User(id, firstname, lastname, email);
        userServlet.getUserDao().update(user);
        response.sendRedirect("list");
    }
}
