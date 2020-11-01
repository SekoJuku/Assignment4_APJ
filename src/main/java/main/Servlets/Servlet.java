package main.Servlets;

import com.google.gson.Gson;
import main.controller.DBcontroller;
import main.models.Book;
import main.models.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {
    DBcontroller DB = new DBcontroller();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("profile_id") != null) {
            int id = Integer.parseInt(request.getParameter("profile_id"));
            response.sendRedirect("profile.jsp?profile_id="+id);
        }
        if(request.getParameter("removeBookId") != null) {
            int id = Integer.parseInt(request.getParameter("removeBookId"));
            DB.removeBookFromList(id);
            response.sendRedirect("main.jsp");
        }
    }
}
