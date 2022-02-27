<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="/css/styles.css">
	</head>
	<body>
		<div class="container">
			<h1>New Book</h1>
			<form:form action="/books" method="post" modelAttribute="book">
				<input type="hidden" name="_method" value="put">
				<div>
					<form:label path="title">Title:</form:label>
					<form:errors path="title"></form:errors>
					<form:input path="title"/>
				</div>
				<div>
					<form:label path="description">Description:</form:label>
					<form:errors path="description"></form:errors>
					<form:textarea path="description"/>
				</div>
				<div>
					<form:label path="language">Language:</form:label>
					<form:errors path="language"></form:errors>
					<form:input path="language"/>
				</div>
				<div>
					<form:label path="numOfPages">Pages</form:label>
					<form:errors path="numOfPages"></form:errors>
					<form:input path="numOfPages" type="number"/>
				</div>
				<button type="submit">Submit</button>
			</form:form>
		</div>
		
	</body>
</html>