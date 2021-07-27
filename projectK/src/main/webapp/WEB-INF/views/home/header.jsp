<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HEADER</title>
	<link rel="stylesheet" href="css/menu.css">
</head>
<body>
    <ul>
      <li><a class="active" href="home.do">Home</a></li>
      <c:if test="${ empty name }">
    	  <li><a href="loginForm.do">Login</a></li>
      </c:if>
      <c:if test="${ not empty name }">
	      <li><a href="logout.do">Logout</a></li>
	      <li><a href="#contact">Product</a></li>
	      <li><a href="#about">About</a></li>
	      <li><a href="#about">Service</a></li>
	      <li><a href="#about">Contact</a></li>
	      <c:if test="${ author eq 'ADMIN' }">
	          <li><a href="#about">Members</a></li>
	      </c:if>
      </c:if>
    </ul>
</body>
</html>