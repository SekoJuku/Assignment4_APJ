package main.Servlets;

import com.google.gson.Gson;
import main.controllers.DBcontroller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveReaderServlet",urlPatterns = "/RemoveReaderServlet")
public class RemoveReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
        int id = Integer.parseInt(request.getParameter("reader_id_delete"));
        response.setContentType("text/html;charset=UTF-8");
        String status = DB.removeReader(id);
        String json = new Gson().toJson(status);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
