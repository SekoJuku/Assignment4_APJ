package main.Servlets;

import main.controllers.DBcontroller;
import main.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBookServlet",urlPatterns = "/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        String name = request.getParameter("update_book_name");
        String author = request.getParameter("update_book_author");
        String url = request.getParameter("update_book_image_url");
        int pages = Integer.parseInt(request.getParameter("update_book_pages"));
        int quantity = Integer.parseInt(request.getParameter("update_book_quantity"));
        int id = Integer.parseInt(request.getParameter("update_book_id"));
        Book book_to_update = new Book(id, null, name, pages, author, url, quantity);
        DB.updateBook(book_to_update);
        response.sendRedirect("books.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
