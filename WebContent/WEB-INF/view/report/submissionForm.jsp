<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����Ʈ ����</title>
</head>
<body>

<h3>@RequestParam ���</h3>
<form action="submitReport1.do" method="post" enctype="multipart/form-data">
	�й� : <input type="text" name="studentNumber"/>
	<br/>
	����Ʈ���� : <input type="file" name="report"/>
	<br/>
	<input type="submit"/>
</form>	
	
<h3>@MultipartHttpServletRequest ���</h3>
<form action="submitReport2.do" method="post" enctype="multipart/form-data">
	�й� : <input type="text" name="studentNumber"/>
	<br/>
	����Ʈ���� : <input type="file" name="report"/>
	<br/>
	<input type="submit"/>
</form>	

<h3>Ŀ�ǵ� ��ü(=�ڹٺ�) ���</h3>
<form action="submitReport3.do" method="post" enctype="multipart/form-data">
	�й� : <input type="text" name="studentNumber"/>
	<br/>
	����Ʈ���� : <input type="file" name="report"/>
	<br/>
	<input type="submit"/>
</form>		

</body>
</html>