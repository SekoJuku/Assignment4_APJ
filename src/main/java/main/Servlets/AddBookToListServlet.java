package main.Servlets;

import main.controller.DBcontroller;

import java.io.IOException;

public class AddBookToListServlet extends http.HttpServlet {
    DBcontroller DB = new DBcontroller();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reader_id = Integer.parseInt(request.getParameter("reader_id"));
        int book_id = Integer.parseInt(request.getParameter("book_id"));
        DB.addBookToList(book_id, reader_id);
        response.sendRedirect("profile.jsp?profile_id="+reader_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
