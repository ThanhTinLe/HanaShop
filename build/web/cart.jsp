<%-- 
    Document   : cart
    Created on : Apr 15, 2021, 9:53:14 AM
    Author     : Ray Khum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
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
                                    <a class="dropdown-item" href="#">History</a>
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
                <font color="green" font-size="5px">${requestScope.UPDATE_CART}</font>
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

        <c:if test="${not empty sessionScope.MAP}">
            <table border="1" style="width: 100%; text-align: center">
                <thead>
                    <tr>
                        <th>IMAGE</th>
                        <th>NAME</th>
                        <th>PRICE</th>
                        <th>QUANTITY</th>
                        <th>TOTAL</th>
                        <th>UPDATE</th>
                        <th>DELETE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="map" items="${sessionScope.MAP}">
                    <form action="MainController" method="POST">
                        <tr>
                            <input type="hidden" name="txtProID" value="${map.value.proID}"/>
                            <td style="width: 140px; height: 140px"><img src="${map.value.proImage}" height="140px" width="140px"></td>
                            <td>${map.value.proName}</td>
                            <td>${map.value.proPrice}</td>
                            <td><input type="number" min="1" name="txtQuantity" value="${map.value.quantity}"/></td>
                            <td>${map.value.proPrice * map.value.quantity}</td>
                            <c:set var="total" value="${map.value.proPrice * map.value.quantity + total}"/>
                            <td><button class="btn btn-outline-success" type="submit" name="btnAction" value="Update Cart">Update</button></td>
                            <td><button class="btn btn-outline-danger" type="submit" name="btnAction" value="Delete Cart" onclick="return confirm('do you want to delete this item')">Delete</button></td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

        <hr style="height:2px;border-width:0;color:gray;background-color:gray; width: 50%">

        <form action="MainController" method="POST" style="margin: 10px 10px 10px 50px ">
            <h3>Total: ${total}$</h3>
            <input type="hidden" name="txtTotal" value="${total}" />
            <input class="btn btn-outline-primary" type="submit" value="Buy Now" name="btnAction"/>
        </form>

    </c:if>
    <c:if test="${empty sessionScope.MAP}">
        <h1>cart is empty. <a href="MainController?btnAction=Search">Buy more</a></h1>
    </c:if>
</body>
</html>
