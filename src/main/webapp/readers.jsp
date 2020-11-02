<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.controllers.DBcontroller" %>
<%@ page import="main.models.Reader" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Readers</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <%
        DBcontroller DB = new DBcontroller();
        ArrayList<Reader> all_readers = DB.getAllReaders();
        request.setAttribute("all_readers", all_readers);
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
        <div class="row" id="all_books">
            <c:forEach var="reader" items="${all_readers}">
                <div class="col-md-4 mt-5">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${reader.getName()}</h5>
                            <p class="card-text"><b>Address:</b>  ${reader.getAddress()}</p>
                            <p class="card-text"><b>Phone:</b>  ${reader.getPhone()}</p>
                        </div>
                        <form action="ProfileServlet" method="get">
                            <input type="number" name="profile_id" value="${reader.getId()}" style="display: none">
                            <button class="btn btn-primary">Open profile</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-md-4 mt-5" style="max-height: 500px; border: solid grey 1px; border-radius: 5px">
                <h1>Add reader</h1>
                <form action="AddReaderServlet" method="post">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Name: </li>
                        <input type="text" class="form-control" name="add_reader_name" required>
                        <li class="list-group-item">Address: </li>
                        <input type="text" class="form-control" name="add_reader_address" required>
                        <li class="list-group-item">Phone Number: </li>
                        <input type="text" class="form-control" name="add_reader_phone" required>
                    </ul>
                    <br>
                    <button name="add_reader" type="submit" class="btn btn-success">Add reader</button>
                </form>
            </div>
        </div>
    </div>
</body>
<br><br>
<footer style="background-color: orange">
    <br>
    <h5 class="text-uppercase" style="margin-left: 10px">SE-1906</h5>
    <p style="margin-left: 10px">Made by Serikzhan Quanyshev, Dauren Ashim, Akan Otebay</p>
    <div align="center">© 2020 Astana IT University:
        <a href="astanait.edu.kz">Astanait.edu.kz</a>
    </div>
</footer>
</html>
