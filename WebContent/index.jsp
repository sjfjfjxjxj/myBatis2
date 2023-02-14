<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스웹</title>
</head>
<body>
<!-- 메인으로 꾸미기도 하지만 Redirect로 사용하기도 함 -->
	<!-- jsp액션태그 forward 사용. 이리로 오면 메인으로 가게끔 할것 -->
	<jsp:forward page="/WEB-INF/views/main/main.jsp"></jsp:forward>
</body>
</html>