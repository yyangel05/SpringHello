<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ����</title>
</head>
<body>

<ul>
	<li><a href="<c:url value='/hello.do'/>">/hello.do</a> (HelloController)</li>
	<li><a href="<c:url value='/article/newArticle.do' />">/article/newArticle.do</a> (NewArticleController, Ŀ�ǵ� ��ü ����)</li>
	<li><a href="<c:url value='/order/order.do' />">/order/order.do</a> (OrderController, Ŀ�ǵ� ��ü�� List �ޱ� ����)</li>
	<li><a href="<c:url value='/search/internal.do' />?query=q&p=2">/search/internal.do</a>
		<a href="<c:url value='/search/external.do' />?query=p&">/search/external.do</a>
		(SearchController, @RequestParam ����)</li>
	<li><a href="<c:url value='/cookie/make.do' />">/cookie/make.do</a>
				<a href="<c:url value='/cookie/view.do' />">/cookie/view.do</a>
			 (CookieController, @CookieValue ����)</li>
	<li><a href="<c:url value='/header/check.do' />">/header/check.do</a>
			 (HeaderController, @RequestHeader ����)</li>
	<li><a href="<c:url value='/search/main.do' />">/search/main.do</a>
			 (GameSearchController, @ModelAttribute ����)</li>
	<li><a href="<c:url value='/account/create.do' />">/account/create.do</a>
			 (CreateAccountController, @ModelAttribute �� �� �� ���� ����)</li>
	<li><a href="<c:url value='/game/users/madvirus/characters/10' />">/game/users/{userId}/characters/{characterId}</a>
			 (CharacterInfoController, @PathVariable ����)</li>
	<li><a href="<c:url value='/login/login.do' />">/login/login.do</a>
			 (LoginController, @InitBinder �� @Valid�� �̿��� �� �� ����)</li>
	<li><a href="<c:url value='/report/submission.do' />">/report/submission.do</a>
			 (ReportSubmissionController, ���� ���ε� ����)</li>
	<li><a href="<c:url value='/log/query.do' />?from=2010-04-01&to=2010-04-30">/log/query.do</a>
			 (QueryLogController, @InitBinder �� WebBindingInitializer ����)</li>
	<li><a href="<c:url value='/event/list.do' />">/event/list.do</a>
			 (EventController, HandlerInterceptor ����)</li>
	<li><a href="<c:url value='/search/game.do' />">/search/game.do</a>
			 (GameSearchController, @ExceptionHandler ����)</li>
	<li><a href="<c:url value='/math/divide.do' />?op1=1&op2=0">/math/divide.do?op1=1&amp;op2=0</a>
			 (ArithmeticOperatorController, SimpleMappingExceptionResolver ����)</li>
	<li><a href="<c:url value='/guestmessage/xml.do' />">/guestmessage/xml.do</a>
			 (GuestMessageController, @ResponseBody ����)</li>

</ul>


</body>
</html>