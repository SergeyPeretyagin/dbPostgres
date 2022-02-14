package database.servlet;

import database.model.User;
import database.model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class ServCreate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            User user = new User(name, surname,age);
            UserDB.createUser(user);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
        }
    }
}
