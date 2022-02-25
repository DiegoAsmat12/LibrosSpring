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
		<h1><c:out value="${book.getTitle()}"></c:out></h1>
		<p>Description: <c:out value="${book.getDescription()}"></c:out></p>
		<p>Language: <c:out value="${book.getLanguage()}"></c:out></p>
		<p>Number of Pages: <c:out value="${book.getNumOfPages()}"></c:out></p>
	</body>
</html>