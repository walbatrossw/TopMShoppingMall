<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/module/head.jsp"/>
<div class="container">
	<br>
	<h2>전체상품리스트</h2>
		<table width="100%" border="1" class="table">
			<thead>
			<tr>
				<th>상품코드</th><th>카테고리</th><th>상품명</th>
				<th>가격</th><th>수량</th><th>등록일</th><th>상품상세설명</th><th>판매자아이디</th>
				<c:if test="${member.mLevel==1 or member.mLevel==2}">
				<th>수정</th><th>삭제</th>
				</c:if>
			</tr>
			</thead>
			<c:forEach var ="product" items = "${productArray}">
				<tr>
					<td>${product.pCode}</td>
					<td>${product.pCate}</td>
					<td>
						<a href=" ${pageContext.request.contextPath}/Pdeta/productDetail.product?pCode=${product.pCode}">${product.pName}</a>
					</td>
					<td>${product.pPrice}</td>
					<td>${product.pCount}</td>
					<td>${product.pDate}</td>
					<td>${product.pDetail}</td>
					<td>${product.mId}</td>
				<c:if test="${member.mLevel==1 or member.mLevel==2}">
					<td>
						<a href=" ${pageContext.request.contextPath}/Pup/productUpdateForm.product?pCode=${product.pCode}">수정클릭</a>			
					</td>
					<td>
						<a href=" ${pageContext.request.contextPath}/Pdel/productDelete.product?pCode=${product.pCode}">삭제클릭</a>			
					</td>
				</c:if>			
				</tr>
			</c:forEach>
				<tr>
					<td colspan = "10">
				<c:if test ="${member.mLevel==1||member.mLevel==2}">
					<a href=" ${pageContext.request.contextPath}/Pin/productAddForm.product">상품등록하기</a>
				 </c:if> 
					</td>
				<tr>
		</table>
	</div>
	<jsp:include page="/module/footer.jsp"/>
</body>
</html>