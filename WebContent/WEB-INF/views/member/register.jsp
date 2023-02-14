<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style>
			.register-table{
				margin: 0 auto;
			}
		</style>
	</head>
	<body>
		<jsp:include page="../common/menuBar.jsp" />
		<h1>회원가입</h1>
		<form action="/member/register.do" method="post">
			<table class="register-table">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="member-id" required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="member-pw" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="member-name" required></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="member-age"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="member-email"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="member-phone"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="member-addr"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>남<input type="radio" value="M" name="member-gender"> 여<input type="radio" value="F" name="member-gender"></td>
				</tr>
				<tr>
					<td>취미</td>
					<td><input type="text" name="member-hobby"></td>
				</tr>
				<tr>
					<td colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="취소">
					</td>
				</tr>
			</table>

		</form>
	</body>
</html>