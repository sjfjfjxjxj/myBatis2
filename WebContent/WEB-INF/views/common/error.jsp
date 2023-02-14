<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러발생</h1>
	<c:if test="${msg ne null}">
		<h2>${msg}</h2>
	</c:if>	
	<c:if test="${msg eq null }">
	<!-- 여기 달러 대신 #으로 오타나면 요 페이지 경로로 TLD 또는 태그 파일 내의 attribute 지시어에 의하면, 속성 [test]은(는) 어떤 표현식도 받아들이지 않습니다. 에러 남 -->
		<h2>null 발생!!!</h2>
	</c:if>
</body>
</html>