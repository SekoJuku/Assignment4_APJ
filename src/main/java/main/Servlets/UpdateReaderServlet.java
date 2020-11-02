package main.Servlets;

import main.controllers.DBcontroller;
import main.models.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateReaderServlet",urlPatterns = "/UpdateReaderServlet")
public class UpdateReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        int id = Integer.parseInt(request.getParameter("update_reader_id"));
        String name = request.getParameter("update_reader_name");
        String address = request.getParameter("update_reader_address");
        String phone = request.getParameter("update_reader_phone");
        Reader reader_to_update = new Reader(id, name, address, phone);
        DB.updateReader(reader_to_update);
        response.sendRedirect("readers.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
