package main.Servlets;

import main.controller.DBcontroller;
import main.models.Reader;

import java.io.IOException;

public class ReaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBcontroller DB = new DBcontroller();
//        Update reader
        if(request.getParameter("update_reader") != null){
            int id = Integer.parseInt(request.getParameter("update_reader_id"));
            String name = request.getParameter("update_reader_name");
            String address = request.getParameter("update_reader_address");
            String phone = request.getParameter("update_reader_phone");
            Reader reader_to_update = new Reader(id, name, address, phone);
            DB.updateReader(reader_to_update);
            response.sendRedirect("readers.jsp");
        }
//        Add reader
        if(request.getParameter("add_reader") != null){
            int id = Integer.parseInt(request.getParameter("add_reader_id"));
            String name = request.getParameter("add_reader_name");
            String address = request.getParameter("add_reader_address");
            String phone = request.getParameter("add_reader_phone");
            boolean id_exist = DB.checkForID(id);
            if(id_exist == false){
                Reader reader_to_add = new Reader(id, name, address, phone);
                dBcontroller.addReader(reader_to_add);
                response.sendRedirect("readers.jsp");
            }
            else {
                response.getWriter().print("<h1>Reader with this ID: "+id+" exists, change ID</h1>");
            }

        }
//        Delete reader
        if(request.getParameter("reader_id_delete") != null){
            int id = Integer.parseInt(request.getParameter("reader_id_delete"));
            response.setContentType("text/html;charset=UTF-8");
            String status = DB.removeReader(id);
            String json = new Gson().toJson(status);
            response.getWriter().write(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
