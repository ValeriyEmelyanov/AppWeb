package com.example.appweb.command.impl;

import com.example.appweb.command.Command;
import com.example.appweb.web.UserServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Delete the user by id.
 */
public class DeleteUserCommand implements Command {
    @Override
    public String getActionPath() {
        return "/delete";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, UserServlet userServlet) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userServlet.getUserDao().delete(id);
        response.sendRedirect("list");
    }
}
