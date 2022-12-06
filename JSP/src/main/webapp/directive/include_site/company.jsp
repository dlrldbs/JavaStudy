<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<%-- Header 영역 : 로고, 메뉴 등 출력하기 위한 영역 - 링크 --%>
	<%@include file="header.jspf" %>
	
	<%-- Content 영역 : 요청에 대한 처리결과를 응답하기 위한 영역 --%>
	<div id="content">
		<h2>회사소개 페이지</h2>
	</div>
	
	<%-- Footer 영역 : 저작권, 약관, 개인정보 보호정책 등을 출력하기 위한 영역 - 링크 --%>
	<%@include file="footer.jspf" %>
</body>
</html>