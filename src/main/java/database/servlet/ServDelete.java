package database.servlet;

import database.model.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class ServDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("userId"));
            UserDB.deleteUser(id);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

}
