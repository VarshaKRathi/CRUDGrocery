<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Search By Category Results</title>
</head>
<body>
  <h2>Grocery List</h2>

  <a th:href="@{'/getGrocery'}">View Grocery</a>

  
  ${grocerys}



</body>
</html>