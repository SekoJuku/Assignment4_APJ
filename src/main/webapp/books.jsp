<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.models.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.controllers.DBcontroller" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Books</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <%
        DBcontroller DB = new DBcontroller();
        ArrayList<Book> all_books = DB.getAllBooks();
        request.setAttribute("all_books", all_books);
    %>

</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Library Management System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="main.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="readers.jsp">Readers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="books.jsp">Books</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="row" id="">
            <c:forEach var="book" items="${all_books}">
                <div class="col-md-4">
                    <div class="card" style="width: 18rem;">
                        <img src="${book.getUrl_image()}" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${book.getName()}</h5>
                            <p class="card-text"><b>Author:</b>  ${book.getAuthor()}</p>
                        </div>
                        <form action="UpdateBookServlet" method="post">
                            <ul class="list-group list-group-flush">
                                <input style="display: none" type="number" name="update_book_id" value="${book.getId()}" required>
                                <li class="list-group-item">Name: </li>
                                <input type="text" class="form-control" name="update_book_name" value="${book.getName()}" required>
                                <li class="list-group-item">Author: </li>
                                <input type="text" class="form-control" name="update_book_author" value="${book.getAuthor()}" required>
                                <li class="list-group-item">Page count: </li>
                                <input type="number" class="form-control" name="update_book_pages" value="${book.getPages()}" required>
                                <li class="list-group-item">Image url: </li>
                                <input type="text" class="form-control" name="update_book_image_url" value="${book.getUrl_image()}" required>
                                <li class="list-group-item">Quantity: </li>
                                <input type="number" class="form-control" name="update_book_quantity" value="${book.getQuantity()}" required>
                            </ul>
                            <br>
                            <button name="update_book" type="submit" class="btn btn-info">Update details</button>
                        </form>
                        <form action="RemoveBookServlet" method="post">
                            <input type="number" value="${book.getId()}" style="display: none" name="book_id_delete">
                            <button name="delete_books" type="submit" class="btn btn-danger">Remove book</button>
                        </form>
                    </div>
                </div>
            </c:forEach>

            </div>
                <div class="row">
                    <div class="col-md-4">
                        <h1>Add book</h1>
                        <form action="AddBookServlet" method="post">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Name: </li>
                                <input type="text" class="form-control" name="add_book_name" required>
                                <li class="list-group-item">Author: </li>
                                <input type="text" class="form-control" name="add_book_author" required>
                                <li class="list-group-item">ISBN: </li>
                                <input type="text" class="form-control" name="add_book_isbn" id="add_book_isbn" required>
                                <li class="list-group-item">Page count: </li>
                                <input type="number" class="form-control" name="add_book_pages" required>
                                <li class="list-group-item">Image url: </li>
                                <input type="text" class="form-control" name="add_book_image_url" required>
                                <li class="list-group-item">Quantity: </li>
                                <input type="number" class="form-control" name="add_book_quantity" required>
                            </ul>
                            <br>
                            <button name="add_book" type="submit" class="btn btn-success">Add book</button>
                        </form>
                    </div>
                </div>
            </div>

</body>
<footer>
    <br>
    <h5 class="text-uppercase" style="margin-left: 10px">SE-1906</h5>
    <p style="margin-left: 10px">Made by Serikzhan Kuanyshev, Dauren Ashim, Akan Otebay</p>
    <div align="center">© 2020 Astana IT University:
        <a href="https://astanait.edu.kz/">Astanait.edu.kz</a>
    </div>
</footer>
</html>
