<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
</head>
<body>

<form:form commandName="loginCommand">
<form:errors element="div"/>

	���̵� : <form:input path="userId"/>
	<form:errors path="userId"/>
	<br/>
	
	��ȣ : <form:password path="password" showPassword="false"/>
	<form:errors path="password"/>
	<br/>

	<input type="submit"/>
</form:form>

</body>
</html>