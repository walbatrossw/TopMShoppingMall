<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/module/head.jsp"/>

<div class="container">
	<h1>상품상세보기</h1>
	<table  class="table">
		<tr>
			<td >상품코드</td>
			<td >${productDetail.pCode }</td>
		</tr>
		<tr>
			<td >상품명</td>
			<td >${productDetail.pName }</td>
		</tr>
		<tr>
			<td >가격</td>
			<td >${productDetail.pPrice }</td>
		</tr>
		<tr>
			<td >수량</td>
			<td >${productDetail.pCount}</td>
		</tr>
		<tr>
			<td >카테고리</td>
			<td >${productDetail.pCate }</td>
		</tr>
		<tr>
			<td >등록일</td>
			<td >${productDetail.pDate }</td>
		</tr>
		
		<tr>
			<td >판매자아이디</td>
			<td >${productDetail.mId }</td>
		</tr>
		<tr>
			<td >판매자연락처</td>
			<td>${productDetail.mPhone }</td>
		</tr>
		<tr>
			<td colspan="2" >내용</td>
		</tr>
		<tr>
			<td colspan="2" >
				<div>${productDetail.pDetail }</div>
				<div><img src="../image/${productImgs.imageName}"/></div>
			</td>
		</tr>		
		
		<tr>
			<td colspan="2" align="center">
				<c:if test="${member.mLevel==0 or member.mLevel==1}">
					<a href=" ${pageContext.request.contextPath}/Pup/productUpdateForm.product?pCode=${productDetail.pCode}">
						[수정]
					</a>&nbsp;&nbsp;
					<a href=" ${pageContext.request.contextPath}/Pdel/productDelete.product?pCode=${productDetail.pCode}">
						[삭제]
					</a>&nbsp;&nbsp;	
				</c:if>
				<a href="${pageContext.request.contextPath}/Plist/ProductList.product">[목록]</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
</div>

</body>
<jsp:include page="/module/footer.jsp"/>
</html>