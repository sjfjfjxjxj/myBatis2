<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이바티스웹</title>
		<style>
			#content{
				display: flex;
				justify-content: center;
			}
			
		</style>
	</head>
	<body>
		
		<!-- 메뉴바 임포틓주기. jsp액션태그로! -->
		<jsp:include page="../common/menuBar.jsp" />
		<div id="content">
			<img alt="마이바티스 메인이미지" src="/resources/images/mybatis.png">
		</div>
	</body>
</html>