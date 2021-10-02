package com.example.appweb.command.impl;

import com.example.appweb.command.Command;
import com.example.appweb.web.UserServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Show the page with the form for new user.
 */
public class ShowNewFormCommand implements Command {
    @Override
    public String getActionPath() {
        return "/new";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, UserServlet userServlet)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
}
