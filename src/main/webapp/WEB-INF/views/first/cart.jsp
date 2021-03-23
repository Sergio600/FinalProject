<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="com.sergio.domain.Order"%>
<%@ page import="com.sergio.domain.User"%>
<%@ page import="com.sergio.domain.Product"%>
<%@ page import="com.sergio.service.OrderService"%>
<%@ page import="com.sergio.service.UserService"%>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
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
    <title>Cart</title>
</head>

<body>
<div class="container">

    <div class="header">Dear, ${user.getName()}, your order is: </div>

<!-- ФОРМА ОТОБРАЖЕНИЯ ВЫБРАННЫХ ПРОДУКТОВ -->

     <% int index =0; %>
     <c:forEach var="pickedProduct" items="${selectedProducts}">
           <p> <%= ++index %>) ${pickedProduct.getName()} ${pickedProduct.getPrice()}$</p>
     </c:forEach>

    <div class="totalPrice">Total price is: ${totalPrice}$</div>

    <form method="POST" action="chooseproducts">
           <input type="submit" name="add" value="Edit cart"></input>
    </form>

     <form method="POST" action="cart">
           <input type="submit" name="exit" value="Exit"></input>
     </form>

</div>
</body>

</html>
