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
		First Name:<form:input path="firstName"/>
		<form:errors path="firstName" cssStyle="color:red"/>
		<br/>
		Last Name:<form:input path="lastName"/>
		<form:errors path="lastName" cssStyle="color:red"/>
		<br/>
		<form:button name="submit">Update</form:button>
	</form:form>
</body>
</html>