<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Maven + Spring MVC</title>
</head>

<body> 
<div>
	<h1>${message}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>

		<c:if test="${empty name}">
			Welcome Welcome!
		</c:if>
	</p>
	<form method="" action="/spring-app-2/hello/save">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add User">
				</td>
			</tr>
		</table>
	</form>

	<c:if test="${not empty records}">
		<c:forEach var="data" items="${records}" varStatus="counter">
			<c:out value="${counter.count}"/><c:out value="${data}" /><p>
		</c:forEach>
	</c:if>

</div>

</body>
</html>