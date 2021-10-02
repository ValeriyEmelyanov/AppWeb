package com.example.appweb.command;

import com.example.appweb.web.UserServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User`s command.
 */
public interface Command {
    String DEFAULT_ACTION = "/list";

    String getActionPath();

    void execute(HttpServletRequest request, HttpServletResponse response, UserServlet userServlet)
            throws ServletException, IOException;
}
