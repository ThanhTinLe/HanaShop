<%-- 
    Document   : create
    Created on : Apr 13, 2021, 7:56:03 AM
    Author     : Ray Khum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1acc75252a.js" crossorigin="anonymous"></script>
        <style>
            #create #form {
                background-color: rgba(178, 196, 211, 0.5);
                width: 50%;
                text-align: center;
            }
            #create #form #input input{
                width: 70%;
                height: 40px;
                margin: 10px;
                border-radius: 10px;
            }
            #create #form #status h4{
                display: inline;
            }
            #create #form #status #status_option{
                height: 40px;
                width: 100px;
                border-radius: 10px;
                margin: 10px;
            }
            #create #form #date input{
                margin: 10px;
                width: 200px;
                height: 40px;
            }
            #create #form #date h4{
                display: inline;  
                margin: 10px;  
            }
            #create #form #category h4{
                display: inline;
            }
            #create #form #category select{
                height: 40px;
                width: 200px;
                margin: 10px;
                border-radius: 10px;
                display: inline;
            }
            button{
                width: 150px;
                height: 40px;
                margin: 10px;
            }
        </style>
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
                    <li class="nav-item" >
                        <a class="nav-link" href="MainController?btnAction=Search page">Shoping</a>
                    </li>
                    <c:if test="${empty FULLNAME}">
                        <li class="nav-item">
                            <a class="nav-link" href="MainController?btnAction=Login page">Login</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty FULLNAME}">
                        <li class="nav-item active dropdown">
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
                    <li class="nav-item" style="margin: 5px">
                        <a href="MainController?btnAction=Cart">
                        <i class="bi bi-cart4"></i>
                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                        <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                        </svg>
                        </a>
                    </li>
                </ul>
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

        <div id="create" align="center">
            <form action="MainController" method="GET" id="form">
                <h1> Create Produce</h1>
                <c:set var="loi" value="${requestScope.UPDATE_ERROR}"/>
                <c:set var="dto" value="${sessionScope.UPDATE}"/>
                <div id="input">
                    <div class="input_item">    
                        <input type="text" name="txtName" placeholder="Name" value="${dto.proName}"><br>
                        <font color ="red" size="5%">${loi.proNameError}</font>
                    </div>
                    <div class="input_item">
                        <input type="number" step="0.1" name="txtPrice" placeholder="Price" value="${dto.proPrice}"><br>
                        <font color ="red" size="5%">${loi.proPriceError}</font>
                    </div>
                    <div class="input_item">
                        <input type="number" name="txtQuantity" placeholder="Quantity" value="${dto.quantity}"><br>
                        <font color ="red" size="5%">${loi.quantityError}</font>
                    </div>
                    <div class="input_item">
                        <input type="text" name="txtDescription" placeholder="Description" value="${dto.description}"><br>
                        <font color ="red" size="5%">${loi.descriptionError}</font>
                    </div>
                    <div class="input_item">
                        <input type="text" name="txtImage" placeholder="Image Link" value="${dto.proImage}"><br>
                        <font color ="red" size="5%">${loi.proImageError}</font>
                    </div>
                </div>
                <div id="status">
                    <h4>Status : </h4>
                    <select name="status" id="status_option">
                        <option value="true">Active</option>
                        <option value="false" <c:if test="${dto.status eq false}">selected</c:if>>Inactive</option>
                    </select>
                </div>
                <div id="date">
                    <h4>Create Date: </h4>
                    <input type="date" name="createDate" id="createDate" value="${dto.createDate}"><br>
                    <h4>Expiry Date: </h4>
                    <input type="date" name="expiryDate" value="${dto.expiryDate}"><br>
                    <font color ="red" size="5%">${loi.expiryDateError}</font>
                </div>
                <div id="category">
                    <h4>Category: </h4>
                    <select class="form-control mr-sm-2" name="txtCate" id="">
                        <c:forEach var="cate" items="${sessionScope.CATE}">
                            <option <c:if test="${dto.categoryID eq cate.categoryID}">selected="true"</c:if> value="${cate.categoryID}">${cate.category}</option>
                        </c:forEach>   
                    </select>
                </div>
                <button type="submit" class="btn btn-secondary" name="btnAction" value="Update">Update</button>
            </form>
        </div>
    </body>
</html>
