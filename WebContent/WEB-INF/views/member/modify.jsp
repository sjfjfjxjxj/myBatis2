<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보수정</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		
	</head>
	<body>
		<jsp:include page="../common/menuBar.jsp"></jsp:include>
		<h1>회원정보수정</h1>
		<form action="/member/modify.do" method="post">
			<table class="table">
				<colgroup>
					<col width = "150">
					<col width = "*">
				</colgroup>
				<tr>
<%-- 			데이터 이상하게 나올때 이렇게 입력해서 확인해보면 좋음!	${mOne } --%>
					<td>아이디</td>
					<td><input type="text" name="member-id" class="form-control" value="${mOne.memberId }" readonly></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="member-pw" class="form-control" value="${mOne.memberPw }" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="member-name" class="form-control" value="${mOne.memberName }" required></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="member-age" class="form-control" value="${mOne.memberAge }"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="member-email" class="form-control" value="${mOne.memberEmail }"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="member-phone" class="form-control" value="${mOne.memberPhone }"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="member-addr" class="form-control" value="${mOne.memberAddr }"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>남<input type="radio" value="M" name="member-gender" <c:if test="${mOne.memberGender eq 'M'}">checked</c:if>> 
						여<input type="radio" value="F" name="member-gender" <c:if test="${mOne.memberGender eq 'F'}">checked</c:if>></td>
				</tr>
				<tr>
					<td>취미</td>
					<td><input type="text" class="form-control" name="member-hobby" value="${mOne.memberHobby }"></td>
				</tr>
				<tr>
					<td colspan="2">
				<input type="submit" class="btn btn-sm btn-success" value="수정">
				<a class="btn btn-sm btn-warning" href="#">뒤로가기</a>
					</td>
				</tr>
			</table>

		</form>
	</body>
</html>