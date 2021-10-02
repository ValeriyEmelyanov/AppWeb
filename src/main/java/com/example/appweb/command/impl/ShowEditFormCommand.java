package com.example.appweb.command.impl;

import com.example.appweb.command.Command;
import com.example.appweb.model.User;
import com.example.appweb.web.UserServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Show the with edit form.
 */
public class ShowEditFormCommand implements Command {
    @Override
    public String getActionPath() {
        return "/edit";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, UserServlet userServlet)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User fetchedUser = userServlet.getUserDao().getById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", fetchedUser);
        dispatcher.forward(request, response);
    }
}
