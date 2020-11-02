package main.Servlets;

import main.controller.DBcontroller;

import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        int id = Integer.parseInt(request.getParameter("book_id_delete"));
        DB.removeBook(id);
        response.sendRedirect("books.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
