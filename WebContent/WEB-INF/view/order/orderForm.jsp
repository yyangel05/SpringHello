<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문하기</title>
</head>
<body>

<form method="post"> <!-- 액션이 없으면 브라우저 url경로에 전송한다. -->
	상품1 : ID - <input type="text" name="orderItems[0].itemId"/>
	개수 - <input type="text" name="orderItems[0].number"/>
	주의 - <input type="text" name="orderItems[0].remark"/>
	<br/>
	상품2 : ID - <input type="text" name="orderItems[1].itemId"/>
	개수 - <input type="text" name="orderItems[1].number"/>
	주의 - <input type="text" name="orderItems[1].remark"/>
	<br/>
	상품3 : ID - <input type="text" name="orderItems[2].itemId"/>
	개수 - <input type="text" name="orderItems[2].number"/>
	주의 - <input type="text" name="orderItems[2].remark"/>
	<br/>
	배송지 : 
	우편번호 - <input type="text" name="address.zipcode"/>
	주소1 - <input type="text" name="address.address1"/>
	주소2 - <input type="text" name="address.address2"/>
	<br/>
	<input type="submit" value="주문하기"/>
	<input type="reset" value="초기화"/>

</form>

</body>
</html>

<!-- http://localhost:8080/SpringHello/order/order.do -->