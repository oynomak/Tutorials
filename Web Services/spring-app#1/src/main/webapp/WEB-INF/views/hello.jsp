<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Maven + Spring MVC</title>
</head>

<div style="float: left;">
	<h1>${message}</h1>
	<p>
		<c:if test="${not empty name}">
			<h4>Hello ${name}</h4>
		</c:if>

		<c:if test="${empty name}">
			<h4>Welcome!</h4>
		</c:if>

		<!--
		<p><h5>Below is the list of Users</h5></p>
		<c:forEach var="user" items="${usersList}" varStatus="counter">
		   <c:out value="${counter.count}"/>: <c:out value="${user}"/><p>
		</c:forEach>
		-->
	</p>

	<div>
		<form method="post" action="/spring-app-1/person/view" >
			<table>
				<tr>
					<td>Enter person ID</td>
					<td><input type="text" size="5" name="personId"></td>
					<td><input type="submit" name="myButton" value="Search"></td>
				</tr>
				<tr>
					<td colspan="3">
						<hr width="100%" />
					</td>
				</tr>
			</table>
		</form>
	</div>

	<c:if test="${not empty people}">
	<h3>My People</h3>
	<table border="1" align="left" style="width:50%">
		<thead>
			<tr>
				<th>#</th>
				<th>ID</th>
				<th>NAMES</th>
				<th>AGE</th>
				<th>SEX</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${people}" varStatus="counter">
				<tr>
					<td><c:out value="${counter.count}"/></td>
					<td><c:out value="${person.id}" /></td>
					<td><c:out value="${person.names}" /></td>
					<td><c:out value="${person.age}" /></td>
					<td><c:out value="${person.sex}" /></td>
					<td><a href="/spring-app-1/person/new?personToEdit=${person.id}">Edit</a></td>
					<td><a href="">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="clear:left;">
	<a href="/spring-app-1/person/new">ADD NEW PERSON</a>
	</c:if>
	<c:if test="${empty people}">
		<p>
			<a href="/spring-app-1/people/view">View all people</a>
		</p>
	</c:if>

</div>

</body>
</html>