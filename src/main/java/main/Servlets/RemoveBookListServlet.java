package main.Servlets;

import main.controllers.DBcontroller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveBookListServlet",urlPatterns = "/RemoveBookListServlet")
public class RemoveBookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        int id = Integer.parseInt(request.getParameter("removeBookId"));
        DB.removeBookFromList(id);
        response.sendRedirect("main.jsp");
    }
}
