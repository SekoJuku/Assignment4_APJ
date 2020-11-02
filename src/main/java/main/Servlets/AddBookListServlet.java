package main.Servlets;

import main.controllers.DBcontroller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBookListServlet",urlPatterns = "/AddBookListServlet")
public class AddBookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        int reader_id = Integer.parseInt(request.getParameter("reader_id"));
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        DB.addBookToList(book_id, reader_id);
        response.sendRedirect("profile.jsp?profile_id="+reader_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
