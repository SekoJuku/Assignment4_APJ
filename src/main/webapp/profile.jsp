<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.models.Reader" %>
<%@ page import="main.controller.DBcontroller" %>
<%@ page import="com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer" %>
<%@ page import="java.util.Map" %>
<%@ page import="main.models.Book" %>
<%@ page import="java.util.Stack" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile of User</title>
    <%--    Bootstrap--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script src="js/jquery-3.5.1.min.js"></script>
    <%
        DBcontroller dBcontroller = new DBcontroller();
        int id = Integer.parseInt(request.getParameter("profile_id"));
        Reader finded_reader = dBcontroller.getReader(id);
        Map<Integer, String> books_list = dBcontroller.getReaderBookList(id);
        Stack<Book> available_books = dBcontroller.getAvailableBooks();
        request.setAttribute("book_list", books_list);
        request.setAttribute("finded_reader", finded_reader);
        request.setAttribute("available_books", available_books);
    %>
</head>
<body>
    <%--Navbar--%>
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
        <div class="row">
            <div class="col-md-6">
                <h1>User information</h1>
                <form action="Servlet" method="post">
                    <ul class="list-group list-group-flush">
                        <input style="display: none" type="number" name="update_reader_id" value="${finded_reader.getId()}" required>
                        <li class="list-group-item">Name: </li>
                        <input type="text" class="form-control" name="update_reader_name" value="${finded_reader.getName()}" required>
                        <li class="list-group-item">Address: </li>
                        <input type="text" class="form-control" name="update_reader_address" value="${finded_reader.getAddress()}" required>
                        <li class="list-group-item">Phone: </li>
                        <input type="text" class="form-control" name="update_reader_phone" value="${finded_reader.getPhone()}" required>
                    </ul>
                    <br>
                    <button name="update_reader" type="submit" class="btn btn-info">Update details</button>
                </form>
                <button name="delete_reader" id="delete_reader" class="btn btn-danger">Remove reader</button>
            </div>
        </div>
        <hr class="my-4">
        <br><br>
<%--        BOOKS LIST--%>
        <div class="row">
            <div class="col-md-8">
                <h1>Books list</h1>
                <hr class="my-4">
                <c:forEach var="book" items="${book_list}">
                    <span>${book.getValue()} <span style="float: right"><a class="text-danger" href="Servlet?removeBookId=${book.getKey()}">Remove book</a></span></span><br>
                </c:forEach>
            </div>
        </div>
        <hr class="my-4">
        <br><br>
<%--        ADD BOOK TO LIST--%>
        <div class="row">
            <div class="col-md-6">
                <h1>Get book</h1>
                <hr class="my-4">
                <form action="Servlet" method="post">
                    <input type="number" style="display: none" name="reader_id" value="${finded_reader.getId()}">
                    <select name="book_id" style="font-size: 20px">
                        <c:forEach var="available_book" items="${available_books}">
                            <option value="${available_book.getId()}">${available_book.getName()}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" name="add_book_to_list" class="btn btn-success">ADD</button>
                </form>
            </div>
        </div>
    </div>
    <script>
        // AJAX CALL POST
        $(document).ready(()=>{
            $("#delete_reader").click(()=>{
                $.ajax({
                    url: "Servlet",
                    data: {reader_id_delete: ${finded_reader.getId()}},
                    type: "POST",
                    success: function (data){
                        console.log(data);
                        alert(data);
                        window.location = "readers.jsp"
                    }
                })
            })
        })
    </script>
</body>
</html>
