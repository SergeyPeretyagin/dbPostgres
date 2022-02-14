package database.servlet;

import database.model.User;
import database.model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class ServUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("userId"));
            User user = UserDB.getUser(id);
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("userId"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
            User user = new User(id, name, surname, age);
            UserDB.updateUser(user);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
