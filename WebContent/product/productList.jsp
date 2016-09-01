<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<br>
	<h2>전체회원리스트</h2>
		<table width="100%" border="1" class="table">
			<thead>
			<tr>
				<th>상품코드</th><th>카테고리</th><th>상품명</th>
				<th>가격</th><th>수량</th><th>등록일</th><th>상품상세설명</th><th>판매자아이디</th>
				<th>수정</th><th>삭제</th>
			</tr>
			</thead>
			<c:forEach var ="goods" items = "${goodsArray}">
				<tr>
					<td>${goods.g_code}</td>
					<td>${goods.g_name}</td>
					<td>${goods.g_id}</td>
					<td>${goods.g_cate}</td>
					<td>${goods.g_price}</td>
					<td>${goods.g_date}</td>
					<td><a href=" ${pageContext.request.contextPath}/Gsangse/g_sangse_form.goods?g_code=${goods.g_code}">${goods.g_sangse}</a></td>
					<td>
						<a href=" ${pageContext.request.contextPath}/Gup/g_update_form.goods?g_code=${goods.g_code}">수정클릭</a>			
					</td>
					<td>
						<a href=" ${pageContext.request.contextPath}/Gdel/g_delete_pro.goods?g_code=${goods.g_code}">삭제클릭</a>			
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>