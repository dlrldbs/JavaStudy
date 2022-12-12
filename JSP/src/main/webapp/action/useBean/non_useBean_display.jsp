<%@page import="xyz.itwill.bean.Hewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 처리페이지(non_useBean_action.jsp)의 내장객체에 저장된 속성값을 반환받아 클라이언트에게 
전달하는 JSP 문서 --%>
<%
	if(session.getAttribute("hewon")==null) {//session 내장객체에 저장된 속성값이 없는 경우
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//session 내장객체에 저장된 속성값을 반환받아 저장
	Hewon hewon=(Hewon)session.getAttribute("hewon");
	
	//다른 JSP 문서에서 session 내장객체에 저장된 속성값을 사용하지 못하도록 속성값 제거
	session.removeAttribute("hewon");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<p>이름 = <%=hewon.getName() %></p>
	<p>전화번호 = <%=hewon.getPhone() %></p>
	<p>주소 = <%=hewon.getAddress() %></p>
</body>
</html>