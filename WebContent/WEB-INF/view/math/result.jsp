<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form>



${operation }의 연산결과는  ====> ${result }


</form>
</body>
</html>

<!--  

http://localhost:8080/SpringHello/math/add.do?op1=55&op2=5
http://localhost:8080/SpringHello/math/sub.do?op1=55&op2=5
http://localhost:8080/SpringHello/math/mul.do?op1=55&op2=5
http://localhost:8080/SpringHello/math/div.do?op1=55&op2=0    ->예외발생

-->