package main;

import main.controller.DBcontroller;
import main.models.Book;
import main.models.Reader;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/library")
public class restAPI {
    public DBcontroller dBcontroller = new DBcontroller();

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getBooks(){
        return dBcontroller.getAllBooks();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Reader> getReaders(){
        return dBcontroller.getAllReaders();
    }

}
