<%-- 
    Document   : history
    Created on : Apr 15, 2021, 6:27:56 PM
    Author     : Ray Khum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1acc75252a.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">HanaShop</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ">
                        <a class="nav-link" href="MainController?btnAction=Home page">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active" >
                        <a class="nav-link disabled" href="">Shoping</a>
                    </li>
                    <c:if test="${empty FULLNAME}">
                        <li class="nav-item">
                            <a class="nav-link" href="MainController?btnAction=Login page">Login</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty FULLNAME}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${sessionScope.FULLNAME}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:if test="${sessionScope.ROLE eq true}">
                                    <a class="dropdown-item" href="MainController?btnAction=History Page">History</a>
                                </c:if>
                                <c:if test="${sessionScope.ROLE eq false}">
                                    <a class="dropdown-item" href="MainController?btnAction=Create Page">Create</a>
                                    <a class="dropdown-item" href="MainController?btnAction=Delete Page">Delete</a>
                                </c:if>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="MainController?btnAction=Logout">Logout</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.ROLE}">
                        <li class="nav-item" style="margin: 5px">
                            <a href="MainController?btnAction=Cart">
                                <i class="bi bi-cart4"></i>
                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                                <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                                </svg>
                            </a>
                        </li>
                    </c:if>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="MainController">
                    <input class="form-control mr-sm-2" type="date" name="txtDateHis" />
                    <input class="form-control mr-sm-2" name="txtSearch" type="text" placeholder="Search" value="${param.txtSearch}" aria-label="Search">
                    <input type="hidden" name="txtPage" value="1" />
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="btnAction" value="History Page">Search</button>
                </form>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
                integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>

        <table border="1" style="width: 100%; text-align: center">
            <thead>
                <tr>
                    <th>Image</th>
                    <th>product Name</th>
                    <th>quantity</th>
                    <th>total price</th>
                    <th>buy Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${sessionScope.LIST_HIS}">
                    <tr>
                        <td style="width: 140px; height: 140px"><img src="${list.proImage}" width="140px" height="140px"></td>
                        <td>${list.proName}</td>
                        <td>${list.numOfPro}</td>
                        <td>${list.price}</td>
                        <td>${list.buyDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
