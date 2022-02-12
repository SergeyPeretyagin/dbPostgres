package database.servlet;

import database.model.User;
import database.model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class Serv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = null;
        try {
            users = UserDB.getAllUsers();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

}
