package main.Servlets;

import main.controller.DBcontroller;
import main.models.Book;

import java.io.IOException;

public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();

//        Update book
        if(request.getParameter("update_book") != null){
            String name = request.getParameter("update_book_name");
            String author = request.getParameter("update_book_author");
            String url = request.getParameter("update_book_image_url");
            int count = Integer.parseInt(request.getParameter("update_book_count"));
            int quantity = Integer.parseInt(request.getParameter("update_book_quantity"));
            int id = Integer.parseInt(request.getParameter("update_book_id"));
            Book book_to_update = new Book(id, null, name, count, author, url, quantity);
            DB.updateBook(book_to_update);
            response.sendRedirect("books.jsp");
        }
//        Add book
        if(request.getParameter("add_book") != null){
            String name = request.getParameter("add_book_name");
            String author = request.getParameter("add_book_author");
            String url = request.getParameter("add_book_image_url");
            String isbn = request.getParameter("add_book_isbn");
            int count = Integer.parseInt(request.getParameter("add_book_count"));
            int quantity = Integer.parseInt(request.getParameter("add_book_quantity"));
            boolean isbn_exist = DB.searchByISBN(isbn);
            if(isbn_exist == false) {

                Book book_to_add = new Book(0, isbn, name, count, author, url, quantity);
                DB.addBook(book_to_add);
                response.sendRedirect("books.jsp");
            }
            else {
                response.getWriter().print("<h1>Book with this ISBN: "+isbn+" exists, change isbn</h1>");
            }

        }
//        Delete book
        if(request.getParameter("delete_books") != null){
            int id = Integer.parseInt(request.getParameter("book_id_delete"));
            DB.removeBook(id);
            response.sendRedirect("books.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
