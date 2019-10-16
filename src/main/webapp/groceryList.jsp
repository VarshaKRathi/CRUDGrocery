<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery List</title>
</head>
<body>
	<h2>Grocery List</h2>

	<a th:href="@{'/home/addGrocery'}">Add Grocery</a>

	<br />

	<table th:if="${ not #lists.isEmpty(groceries) }" border=1>
		<tr>
			<td>ItemID</td>
			<td>ItemName</td>
			<td>Price</td>
			<td>Quantity</td>
		</tr>
		<tr th:each="grocery : ${groceries}">
			<td th:text="${grocery.itemId}"></td>
			<td th:text="${grocery.itemName}"></td>
			<td th:text="${grocery.itemPrice}"></td>
			<td th:text="${grocery.itemQty}"></td>

		</tr>
	</table>
</body>
</html>