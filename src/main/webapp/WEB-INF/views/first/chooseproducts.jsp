<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="com.sergio.domain.Order"%>
<%@ page import="com.sergio.domain.User"%>
<%@ page import="com.sergio.domain.Product"%>
<%@ page import="com.sergio.service.OrderService"%>
<%@ page import="com.sergio.service.UserService"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>

<%@ page import="com.sergio.repository.ProductRepository"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

     <style>
        <%@include file="/WEB-INF/views/css/style.css"%>
     </style>





<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Choose items</title>
</head>

<body>
    <div class="container">
        <div class="header">Welcome, ${user.getName()}!!!</div>
        </br>
        <div>Make your order!</div>


        <div>

<!-- ФОРМА SELECT ВЫБОР ПРОДУКТОВ  -->
            <form method="post" id="addprod" action="chooseproducts">

                <select name="selected" size="1">
                    <c:forEach var="product" items="${products}">
                        <option value="${product.key}"> ${product.key} (${product.value}$) </option>
                    </c:forEach>
                 </select>

            <!--   <input type="hidden" name="id" value="${order.getId()}"></input>    -->
                <input type="submit" name="additem" value="add item"></input>
            </form>

<!-- ФОРМА ДЛЯ КНОПОК SUBMIT И EXIT  -->
            <form method="POST" id="addprod" action="cart">
                  <input type="submit" value="submit"></input>
                  <input type="submit" name="exit" value="exit"></input>
                  <input type="hidden" name="id" value="${order.getId()}"></input>
                  <input type="hidden" name="customer" value="${user.getName()}"></input>
             </form>
<div class="container">
        <div class="header">Welcome, ${user.getName()}!!!</div>
        </br>
        <div>Make your order!</div>


        <div>

<!-- ФОРМА SELECT ВЫБОР ПРОДУКТОВ  -->
            <form method="post" id="addprod" action="chooseproducts">

                <select name="selected" size="1">
                    <c:forEach var="product" items="${products}">
                        <option value="${product.key}"> ${product.key} (${product.value}$) </option>
                    </c:forEach>
                 </select>

            <!--   <input type="hidden" name="id" value="${order.getId()}"></input>    -->
                <input type="submit" name="additem" value="add item"></input>
            </form>

<!-- ФОРМА ДЛЯ КНОПОК SUBMIT И EXIT  -->
            <form method="POST" id="addprod" action="cart">
                  <input type="submit" value="submit"></input>
                  <input type="submit" name="exit" value="exit"></input>
                  <input type="hidden" name="id" value="${order.getId()}"></input>
                  <input type="hidden" name="customer" value="${user.getName()}"></input>
             </form>


<!-- ФОРМА ОТОБРАЖЕНИЯ ВЫБРАННЫХ ПРОДУКТОВ -->
            <div>
             <% int index =0; %>
                <c:forEach var="pickedProduct" items="${selectedProducts}">
                    <p> ${pickedProduct.getName()} ${pickedProduct.getPrice()}</p>
                     <button type="submit" value="${pickedProduct.getId()}" name="remove" form="addprod"> remove </button>
             </c:forEach>
            </div>
        </div>
    </div>

<!-- ФОРМА ОТОБРАЖЕНИЯ ВЫБРАННЫХ ПРОДУКТОВ -->
            <div>
             <% int index =0; %>
                <c:forEach var="pickedProduct" items="${selectedProducts}">
                    <p> ${pickedProduct.getName()} ${pickedProduct.getPrice()}</p>
                     <button type="submit" value="${pickedProduct.getId()}" name="remove" form="addprod"> remove </button>
             </c:forEach>
            </div>
        </div>
    </div>
</body>

</html>
