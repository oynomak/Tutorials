<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Maven + Spring MVC</title>
</head>

<body>

<div style="float: left;">
	<c:if test="${empty person}">
		<h3>New Person</h3>
		<form method="POST" action="/spring-app-1/person/add">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>NAMES</th>
						<th>AGE</th>
						<th>SEX</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" size="2" name="personId" value="${personToEdit.id}" /></td>
						<td><input type="text" name="names" value="${personToEdit.names}" /></td>
						<td><input type="text" size="2" name="age" value="${personToEdit.age}" /></td>
						<td><input type="text" size="6" name="sex" value="${personToEdit.sex}" /></td>
						<td><input type="submit" value="Add Person"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</c:if>
	<c:if test="${not empty person}">
	<h3>Matching Person</h3>
	<table border="1" align="left" style="width:50%">
		<thead>
			<tr>
				<th>ID</th>
				<th style="min-width: 300px;">NAMES</th>
				<th>AGE</th>
				<th style="min-width: 100px;">SEX</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${person.id}" /></td>
				<td><c:out value="${person.names}" /></td>
				<td><c:out value="${person.age}" /></td>
				<td><c:out value="${person.sex}" /></td>
			</tr>
		</tbody>
	</table>
	</c:if>
</div>
<div style="clear: left;">
	<br>
	<p>
		<a href="/spring-app-1/people/view">View all people</a>
	</p>
</div>

</body>
</html>