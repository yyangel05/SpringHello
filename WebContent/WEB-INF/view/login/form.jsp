<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>

<form:form commandName="loginCommand">
<form:errors element="div"/>

	아이디 : <form:input path="userId"/>
	<form:errors path="userId"/>
	<br/>
	
	암호 : <form:password path="password" showPassword="false"/>
	<form:errors path="password"/>
	<br/>

	<input type="submit"/>
</form:form>

</body>
</html>