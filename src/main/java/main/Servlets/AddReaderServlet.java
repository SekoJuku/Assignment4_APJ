package main.Servlets;

import main.controllers.DBcontroller;
import main.models.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddReaderServlet",urlPatterns = "/AddReaderServlet")
public class AddReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        String name = request.getParameter("add_reader_name");
        String address = request.getParameter("add_reader_address");
        String phone = request.getParameter("add_reader_phone");
        Reader reader_to_add = new Reader(0,name, address, phone);
        DB.addReader(reader_to_add);
        response.sendRedirect("readers.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
