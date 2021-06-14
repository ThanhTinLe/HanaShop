<%-- 
    Document   : search
    Created on : Apr 12, 2021, 9:50:26 AM
    Author     : Ray Khum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home Page</title>
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
                <font color ="red" size="5%">${requestScope.CEARTED}</font>
                <font color ="red" size="5%">${requestScope.ADD}</font>
                <form class="form-inline my-2 my-lg-0" action="MainController">
                    <select class="form-control mr-sm-2" name="txtCate">
                        <option value="">All Product</option>
                        <c:forEach var="cate" items="${sessionScope.CATE}">
                            <option <c:if test="${sessionScope.CATEID eq cate.categoryID}">selected="true"</c:if>   value="${cate.categoryID}">${cate.category}</option>
                        </c:forEach>                             
                    </select>
                    <input class="form-control mr-sm-2" type="number" min="0" name="txtMinPrice" value="${sessionScope.MIN_PRICE}" placeholder="0" />
                    <i class="bi bi-arrow-right"></i>
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
                    </svg>
                    <input class="form-control mr-sm-2" type="number" min="1" name="txtMaxPrice" value="${sessionScope.MAX_PRICE}" placeholder="100" />
                    <input class="form-control mr-sm-2" name="txtSearch" type="text" placeholder="Search" value="${sessionScope.PRO_NAME}" aria-label="Search">
                    <input type="hidden" name="txtPage" value="1" />
                    <input class="btn btn-outline-success my-2 my-sm-0" type="submit" name="btnAction" value="Search"/>
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

        <div class="album py-5 bg-light">
            <div class="container">
                <div class="row">
                    <c:if test="${empty sessionScope.LIST}">
                        <h2>no resutl</h2>
                    </c:if>
                    <c:if test="${empty sessionScope.ROLE}">
                        <c:forEach var="list" items="${sessionScope.LIST}">
                            <c:if test="${list.status eq true}">
                                <div class="col-md-4">
                                    <div class="card mb-4 box-shadow">
                                        <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${list.proImage}">
                                        <div class="card-body">
                                            <form action="MainController">
                                                <p class="card-text">
                                                <h4>${list.proName}</h4>
                                                <p>Price:${list.proPrice}</p>
                                                <button type="submit" class="btn btn-danger" name="btnAction" value="AddToCart">Add To Cart</button>
                                                <input type="hidden" name="txtProID" value="${list.proID}" />
                                                <button type="submit" class="btn btn-info" name="btnAction" value="Detail">View Detail</button>                                        
                                                <div class="d-flex justify-content-between align-items-center">
                                                </div>
                                            </form>
                                        </div>  
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${not empty sessionScope.ROLE}">
                        <c:if test="${sessionScope.ROLE eq false}">
                            <c:forEach var="list" items="${sessionScope.LIST}">
                                <div class="col-md-4">
                                    <div class="card mb-4 box-shadow">
                                        <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${list.proImage}">
                                        <div class="card-body">
                                            <form action="MainController" method="GET">
                                                <p class="card-text">
                                                <h4>${list.proName}</h4>
                                                <p>Price : ${list.proPrice}</p>
                                                <c:if test="${list.status eq true}">
                                                    <p>Status : Active</p>
                                                </c:if>
                                                <c:if test="${list.status eq false}">
                                                    <p>Status : Inactive</p>
                                                </c:if>
                                                <button type="submit" name="btnAction" value="Update Page" class="btn btn-success">Update</button>
                                                <input type="hidden" name="txtProID" value="${list.proID}"/>
                                                <div class="d-flex justify-content-between align-items-center">
                                                </div>
                                            </form>
                                        </div>  
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                        <c:if test="${sessionScope.ROLE eq true}">
                            <c:forEach var="list" items="${sessionScope.LIST}">
                                <c:if test="${list.status eq true}">
                                    <div class="col-md-4">
                                        <div class="card mb-4 box-shadow">
                                            <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="${list.proImage}">
                                            <div class="card-body">
                                                <form action="MainController">
                                                    <p class="card-text">
                                                    <h4>${list.proName}</h4>
                                                    <p>Price:${list.proPrice}</p>
                                                    <button type="submit" class="btn btn-danger" name="btnAction" value="AddToCart">Add To Cart</button>
                                                    <input type="hidden" name="txtProID" value="${list.proID}" />
                                                    <button type="submit" class="btn btn-info" name="btnAction" value="Detail">View Detail</button>                                        
                                                    <div class="d-flex justify-content-between align-items-center">
                                                    </div>
                                                </form>
                                            </div>  
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:if>
                </div>
            </div>
        </div> 
        <div class="container">
            <div class="row" style="text-align: center;">
                <div class="col-md-4">
                </div>
                <div class="col-md-4" style="font-size: 20px; ">
                    <c:forEach var="size" begin="1" end="${sessionScope.INDEX}">
                        <form action="MainController" method="GET" style="display: inline">
                            <c:if test="${not empty requestScope.OKE}">
                                <button name="btnAction" value="Search Paging">${size}</button>       
                                <input type="hidden" name="txtPaging" value="${size}" />
                            </c:if>
                            <c:if test="${empty requestScope.OKE}">
                                <button name="btnAction" value="Paging">${size}</button>       
                                <input type="hidden" name="txtPaging" value="${size}" />
                            </c:if>
                                <input type="hidden" name="txtMinPrice" value="${sessionScope.MIN_PRICE}" />
                                <input type="hidden" name="txtMaxPrice" value="${sessionScope.MAX_PRICE}" />
                        </form>
                    </c:forEach>
                </div>
                <div class="col-md-4">
                </div>
            </div>
        </div>

    </body>
</html>
