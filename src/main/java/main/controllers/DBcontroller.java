package main.controllers;

import main.models.Book;
import main.DB;
import main.models.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DBcontroller extends DB {

    DB db = new DB();

    private Connection myConnection = db.getConnection();


    public void addBook(Book book) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.
                    prepareStatement("insert into books values(null, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setInt(3, book.getPages());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setString(5, book.getUrl_image());
            preparedStatement.setInt(6, book.getQuantity());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void removeBook(int book_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.
                    prepareStatement("delete from books where book_id=?");
            preparedStatement.setInt(1, book_id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void updateBook(Book book) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection
                    .prepareStatement("update books " +
                            "set book_name=?, book_author=?, book_image_url=?, book_pages=?, book_quantity=? " +
                            "where book_id=?");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getUrl_image());
            preparedStatement.setInt(4, book.getPages());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.setInt(6, book.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public int getCopiesOfBook(int book_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.prepareStatement("select book_quantity from books where book_id=?");
            preparedStatement.setInt(1, book_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int quantity = resultSet.getInt(1);
                return quantity;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    public boolean searchByISBN(String isbn) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = myConnection.prepareStatement("select * from books where book_isbn=?");
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while(resultSet.next()){
                count ++;
            }
            if(count != 0){
                return true;
            }
            else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    //
    public ArrayList<Reader> getAllReaders() {
        PreparedStatement preparedStatement = null;
        ArrayList<Reader> all_readers = new ArrayList<>();
        try {
            preparedStatement = myConnection.prepareStatement("select * from readers");
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while(resultSet.next()){
                Reader reader = new Reader(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                all_readers.add(reader);
                count ++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all_readers;
    }
    public void addReader(Reader reader) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.
                    prepareStatement("insert into readers values(null, ?, ?, ?)");
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getAddress());
            preparedStatement.setString(3, reader.getPhone());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Reader getReader(int id) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = myConnection.prepareStatement("select * from readers where reader_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Reader reader = null;
            while(resultSet.next()){
                reader = new Reader(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                return reader;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public String removeReader(int reader_id) {
        PreparedStatement preparedStatement = null;
        if(getReaderBookList(reader_id).size() == 0){
            try {
                preparedStatement = myConnection.prepareStatement("delete from readers where reader_id=?");
                preparedStatement.setInt(1, reader_id);
                preparedStatement.execute();
                return "Deleted reader with ID: "+reader_id;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "User didn't return books, please first return books.";
    }
    public void updateReader(Reader reader) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection
                    .prepareStatement("update readers " +
                            "set reader_name=?, reader_address=?, reader_phone=? " +
                            "where reader_id=?");
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getAddress());
            preparedStatement.setString(3, reader.getPhone());
            preparedStatement.setInt(4, reader.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean checkForID(int id) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = myConnection.prepareStatement("select * from readers where reader_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while(resultSet.next()){
                count ++;
            }
            if(count != 0){
                return true;
            }
            else
                return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    //
    public Map<Integer, String> getReaderBookList(int reader_id) {
        PreparedStatement preparedStatement = null;
        Map<Integer, String> books = new HashMap<>();
        try {
            preparedStatement = myConnection.prepareStatement("select reader_booklist.id, reader_booklist.book_id, books.book_name from reader_booklist inner join books on reader_booklist.book_id=books.book_id where reader_booklist.reader_id=?");
            preparedStatement.setInt(1, reader_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String book = "ID: "+resultSet.getInt(2)+"| NAME: "+resultSet.getString(3);
                books.put(id, book);
            }
            return books;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }
    public void addBookToList(int book_id, int reader_id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConnection.prepareStatement("insert into reader_booklist values(null, ?, ?)");
            preparedStatement.setInt(1, reader_id);
            preparedStatement.setInt(2, book_id);
            preparedStatement.execute();
            int copies = getCopiesOfBook(book_id);
            copies--;
            PreparedStatement preparedStatement1 = myConnection.prepareStatement("update books set book_quantity=? where book_id=?");
            preparedStatement1.setInt(1, copies);
            preparedStatement1.setInt(2, book_id);
            preparedStatement1.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void removeBookFromList(int id) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = myConnection.prepareStatement("select book_id from reader_booklist where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs1 = preparedStatement.executeQuery();
            if(rs1.next()){
                int book_id = rs1.getInt(1);
                PreparedStatement preparedStatement1 = myConnection.prepareStatement("delete from reader_booklist where id=?");
                preparedStatement1.setInt(1, id);
                preparedStatement1.execute();
                int copies = getCopiesOfBook(book_id);
                copies++;
                PreparedStatement preparedStatement2 = myConnection.prepareStatement("update books set book_quantity=? where book_id=?");
                preparedStatement2.setInt(1, copies);
                preparedStatement2.setInt(2, book_id);
                preparedStatement2.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Stack<Book> getAvailableBooks() {
        PreparedStatement preparedStatement = null;
        Stack<Book> available_books = new Stack<>();
        try {
            preparedStatement = myConnection.prepareStatement("select * from books where book_quantity>0");
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while(resultSet.next()){
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5),resultSet.getString(6), resultSet.getInt(7));
                available_books.add(book);
                count ++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return available_books;
    }

    public ArrayList<Book> getAllBooks() {
        PreparedStatement preparedStatement = null;
        ArrayList<Book> all_books = new ArrayList<>();
        try {
            preparedStatement = myConnection.prepareStatement("select * from books");
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while(resultSet.next()){
                //public Book(int book_id, String book_isbn, String book_name, int book_pages, String book_author, String book_url_image, int book_quantity)
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5),resultSet.getString(6), resultSet.getInt(7));
                all_books.add(book);
                count ++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return all_books;
    }


}
