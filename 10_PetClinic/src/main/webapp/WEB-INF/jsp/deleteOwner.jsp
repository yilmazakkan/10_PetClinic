<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="owner" method="post">
		First Name:<form:input path="firstName"/><br>
		
		Last Name:<form:input path="lastName"/><br>
		<form:errors path="lastName"></form:errors>
		
		<form:button name="submit">Delete</form:button>
	
	</form:form>
</body>
</html>