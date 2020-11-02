package main.Servlets;

import main.controllers.DBcontroller;
import main.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBookServlet",urlPatterns = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        String name = request.getParameter("add_book_name");
        String author = request.getParameter("add_book_author");
        String url = request.getParameter("add_book_image_url");
        String isbn = request.getParameter("add_book_isbn");
        int pages = Integer.parseInt(request.getParameter("add_book_pages"));
        int quantity = Integer.parseInt(request.getParameter("add_book_quantity"));
        boolean isbn_exist = DB.searchByISBN(isbn);
        if(isbn_exist == false) {

            Book book_to_add = new Book(0, isbn, name, pages, author, url, quantity);
            DB.addBook(book_to_add);
            response.sendRedirect("books.jsp");
        }
        else {
            response.getWriter().print("<h1>Book with this ISBN: "+isbn+" exists, change isbn</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
