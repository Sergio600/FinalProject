<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<p>Hello!</p>
<a href="goodbye">goodbye</a>


     <% int index =0; %>
     <c:forEach var="product" items="${products}">
           <p> <%= ++index %>) ${product.getName()} ${product.getPrice()}$</p>
     </c:forEach>


</body>
</html>