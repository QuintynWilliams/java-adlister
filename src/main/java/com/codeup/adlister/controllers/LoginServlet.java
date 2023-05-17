package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User foundUser = DaoFactory.getUsersDao().findByUsername(username);

        //  TODO: find a record in your database that matches the submitted password
        //  TODO: make sure we find a user with that username
        //  TODO: check the submitted password against what you have in your database

        if (validAttempt(username, password, foundUser)){
        //  TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", foundUser);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }

    public static boolean validAttempt(String username, String password, User user) {
        return (user != null && user.getUsername().equals(username) && user.getPassword().equals(password));
    }
}