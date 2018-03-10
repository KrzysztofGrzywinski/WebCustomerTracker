<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

<head>
<title>List Customers</title>

<!-- reference our style sheet -->

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<br>
	<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd';return false;"
		class="add-button" />

	<form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />

		<input type="submit" value="Search" class="add-button" />
	</form:form>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="temp" items="${customers}">
					<c:url value="/customer/showFormForUpdate" var="updateLink">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>

					<c:url value="/customer/delete" var="deleteLink">
						<c:param name="customerId" value="${temp.id}"></c:param>
					</c:url>
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>