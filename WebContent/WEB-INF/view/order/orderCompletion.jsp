<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 완료</title>
</head>
<body>
주문 완료
<br/>
주문 아이템 
<br/>
<ul>
	<c:forEach var="item" items="${orderCommand.orderItems}"> <!--orderCommand.orderItems 리스트객체에 저장된 것을 하나씩 뽑아서 item에 저장한다 -->
		<li>${item.itemId} / ${item.number} / ${item.remark }</li>
	</c:forEach>
</ul>

배송지 : ${orderCommand.address}

</body>
</html>