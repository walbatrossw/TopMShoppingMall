<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/module/head.jsp"/>
<body class="container">
	<br>
	회원 리스트
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>권한</th>
				<th>주소</th>
				<th>나이</th>
				<th>연락처</th>
				<th>이메일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${memberList }">
				<tr>
					<td>${member.mId }</td>
					<td>${member.mName }</td>
					<td>${member.mLevel }</td>
					<td>${member.mAddr }</td>
					<td>${member.mAge }</td>
					<td>${member.mPhone }</td>
					<td>${member.mEmail }</td>
					<td><a href="${pageContext.request.contextPath}/Min/m_update_form.ksmart?send_id=${member.mId }">수정클릭</a></td>
					<td><a href="${pageContext.request.contextPath}/Min/m_delete_pro.ksmart?send_id=${member.mId }">삭제클릭</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="/module/footer.jsp"/>
</body>
</html>