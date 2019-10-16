<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery</title>
<script>
		function validateForm() {
			  var x = document.forms["myForm"]["itemId"].value;
			  if (x == "") {
			    alert("itemId must be filled out");
			    return false;
			  }
		}
		function validateSubForm() {
			  var x = document.getElementById("name").value;
			  var y = document.getElementById("price").value;
			  var z = document.getElementById("quantity").value;
			  if (x == "") {
			    alert("itemName must be filled out");
			    return false;
			  }
			  if (y == "") {
			    alert("itemPrice must be filled out");
			    return false;
			  }
			  if (z == "") {
			    alert("itemQuantity must be filled out");
			    return false;
			  }
		}

	</script>
<style>
input:invalid {
	border: 1px solid red;
}

input:valid {
	border: 1px solid black;
}
</style>
</head>
<body>
	<form action="readGrocery">
		<h4>Grocery In Store</h4>

		<input type="submit" value="Read Grocery In Store"> <br>
		<br>
		<table border=1 c:if test="${not empty groceryList}">
			<tr>
				<td>Item Id</td>
				<td>Item Name</td>
				<td>Item Price</td>
				<td>Item Quantity</td>
				<td>Category</td>

			</tr>
			<c:forEach var="grocery" items="${groceryList}">
				<c:forEach var="groceryItems" items="${grocery}">
					<tr>
						<td>${groceryItems.itemId}</td>
						<td>${groceryItems.itemName}</td>
						<td>${groceryItems.itemPrice}</td>
						<td>${groceryItems.itemQty}</td>
						<td>${groceryItems.category}</td>
					</tr>
				</c:forEach>
			</c:forEach>

		</table>
	</form>
	<br>
	<br>
	<form name="myForm" onsubmit="return validateForm()" method="post"
		target="_blank">
		<h4>CRUD Operations</h4>
		<table border=0>
			<tr>
				<td align="right">itemId:</td>
				<td align="left"><input type="text" name="itemId" required
					id="clearText"></input></td>
			</tr>
			<tr>
				<td align="right">category:</td>
				<td align="left"><select name="category">
						<option value="food">Food</option>
						<option value="dairy">Dairy</option>
						<option value="cloth">Cloth</option>
						<option value="toys">Toys</option>
				</select>
			<tr>
				<td align="right">*itemName:</td>
				<td align="left"><input type="text" name="itemName" id="name"></input></td>
			</tr>
			<tr>
				<td align="right">*itemPrice:</td>
				<td align="left"><input type="text" name="itemPrice" id="price"></input></td>
			</tr>
			<tr>
				<td align="right">*itemQty:</td>
				<td align="left"><input type="text" name="itemQty"
					id="quantity"></input></td>
			</tr>
			<br>
			<tr>
				<td></td>
				<td align="left">*Required for Only <b>CREATE</b></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Delete"
					formaction="deleteGrocery"> <input type="submit"
					value="Update" formaction="updateGrocery"> <input
					type="submit" value="Create" formaction="addGrocery"
					onclick="return validateSubForm()" name="subform"> <input
					type="reset" value="ClearText"></td>
			</tr>
		</table>
	</form>
	<br>

	<form action="showGrocery">
		<h4>Search By Category</h4>
		<table border=0>
			<tr>
				<td align="right">category:</td>
				<td align="left"><select name="category">
						<option value="food">Food</option>
						<option value="dairy">Dairy</option>
						<option value="cloth">Cloth</option>
						<option value="toys">Toys</option>
				</select> <input type="submit" value="SearchByCategory"></td>
			</tr>
		</table>
		<br> <br> <br>
		<table border=1>
			<c:if test="${not empty groceryCategoryList}">
				<tr>
					<td>Item Id</td>
					<td>Item Name</td>
					<td>Item Price</td>
					<td>Item Quantity</td>
					<td>Category</td>

				</tr>
				<c:forEach var="groceryCategory" items="${groceryCategoryList}">
					<c:forEach var="groceryCategoryItems" items="${groceryCategory}">

						<tr>
							<td>${groceryCategoryItems.itemId}</td>
							<td>${groceryCategoryItems.itemName}</td>
							<td>${groceryCategoryItems.itemPrice}</td>
							<td>${groceryCategoryItems.itemQty}</td>
							<td>${groceryCategoryItems.category}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</c:if>

		</table>
	</form>
</body>
</html>

