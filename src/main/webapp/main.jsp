<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    body{
        background-image: url("https://miro.medium.com/max/11914/0*nkMHIYllnotYcos_");
        background-repeat: no-repeat;
        background-size: auto;
    }
    .main{
        background-color:gray;
        opacity: 0.91;
    }
    footer{
        background-color: orange;
    }
</style>
<head>
    <title>Library</title>
<%--    Bootstrap--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
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
    <br><br><br>
    <div class="main">
        <br><br>
        <h1 align="center">Welcome to our Library Management System!</h1>
        <br><br>
    </div><br><br><br>
    <div class="main">
        <br>
        <h3 style="margin-left: 10px">A LIBRARY is a curated collection of sources of information and similar resources, selected by experts and made accessible to a defined community for reference or borrowing, often in a quiet environment conducive to study. It provides physical or digital access to material, and may be a physical location or a virtual space, or both.</h3>
        <br>
    </div>
    <br><br><br><br>
<br><br><br><br><br><br>
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
