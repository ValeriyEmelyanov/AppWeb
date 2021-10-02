package com.example.appweb.command.impl;

import com.example.appweb.command.Command;
import com.example.appweb.model.User;
import com.example.appweb.web.UserServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Show the page with users list.
 */
public class ShowListCommand implements Command {
    @Override
    public String getActionPath() {
        return Command.DEFAULT_ACTION;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, UserServlet userServlet)
            throws ServletException, IOException {
        List<User> users = userServlet.getUserDao().getAll();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
}
