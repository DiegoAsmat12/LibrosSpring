<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Reading Books</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">
	</head>
	<body>
		<h1>All Books</h1>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th>Number of Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.getId()}"></c:out></td>
						<td><a href="/books/${book.getId()}"><c:out value="${book.getTitle()}"></c:out></a></td>
						<td><c:out value="${book.getLanguage()}"></c:out></td>
						<td><c:out value="${book.getNumOfPages()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		

	</body>
</html>