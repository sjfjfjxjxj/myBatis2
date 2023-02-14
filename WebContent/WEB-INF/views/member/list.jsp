<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- uri fmt 쓰면 시간 어떻게 관리할수있대 --> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멤버목록</title>
		<!-- 부트스트랩 함 써보자!! -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<style>
 			table{ width:500px; } 
		</style>
	</head>
	<body>
		<jsp:include page="../common/menuBar.jsp"></jsp:include>
		<br><br>
		<div>
			<div>
				<table class="table table-hover">
					<colgroup>
						<col width="80" align="center">
						<col width="200">
						<col width="200">
						<col width= "400">
					<thead>
						<tr>
							<th>No</th>
							<th>회원ID</th>
							<th>이름</th>
							<th>주소</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mList }" var="member" varStatus="status">
						<!-- items: 객체리스트. 리퀘스트스코프에서 리스트인거 가져옴, var=객체 하나하나ㅇㅇ .이용해서 꺼냄 -->
							<tr>
								<td>${status.count }</td><!-- 포문돌릴때 인덱스+1값 -->
								<td>${member.memberId }</td>
								<td>${member.memberName }</td>
								<td>${member.memberAddr }</td>
								<td>
									<c:if test="${sessionScope.member.memberId eq member.memberId }">
										<a class="btn btn-xs btn-warning" href="/member/modify.do">UPDATE</a>
									</c:if>	
								</td>
								<td>
									<c:if test="${sessionScope.member.memberId eq member.memberId }">
										<!-- ne null로 하면 모든 사람 딜리트버튼 보임. eq자기 아이디 하면 자기것만 보임 -->
										<a class="btn btn-xs btn-danger" href="/member/delete.do">DELETE</a> <!-- 컨펌삭제 만들어보기 -->
									</c:if>
								</td>
							</tr>
						</c:forEach>	
					</tbody>
					<tfoot>
						<tr>
							<td colspan="6" align="center">
							${pageNavi }
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</body>
</html>