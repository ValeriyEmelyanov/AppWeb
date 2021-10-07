package com.example.appweb.web;

import com.example.appweb.command.Command;
import com.example.appweb.dao.UserDao;
import com.example.appweb.util.CommandMapBuilder;
import com.example.appweb.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the browser.
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {

    private UserDao userDao;
    private Map<String, Command> commandMap;

    public void init() {
        userDao = new UserDao(new HibernateUtil());
        commandMap = CommandMapBuilder.getCommandMap();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        Command command = commandMap.getOrDefault(action, commandMap.get(Command.DEFAULT_ACTION));
        command.execute(request, response, this);
    }

    public UserDao getUserDao() {
        return userDao;
    }

}