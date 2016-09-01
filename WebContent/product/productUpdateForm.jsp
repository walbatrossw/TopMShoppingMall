<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<title>productAddForm.jsp</title>
</head>
<body>
${member.mId}
${member.mName}
${member.mLevel }
<jsp:include page="/module/head.jsp"/>
<form action=" ${pageContext.request.contextPath}/Pin/productAddPro.product" method="post">
		<input type="hidden" name="mId" value="${member.mId}" size="20" >
		<div class="container">
			<h2>상품등록</h2>
			<table border="1" class="table">
				<tr>
					<td>상품코드</td>
					<td><input type="text" name="productCode" size="20"></td>
				<tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="productName" size="20"></td>
				<tr>
				<tr>
					<td>카테고리</td>
					<td><input type="text" name="productCate" size="20"></td>
				<tr>
				<tr>
					<td>상세설명</td>
					<td><input type="text" name="productDetail" size="20"></td>
				<tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="productPrice" size="20"></td>
				<tr>
				<tr>
					<td>수량</td>
					<td><input type="text" name="productCount" size="20"></td>
				<tr>
				<tr>
					<td colspan="4"><input type="submit" value="상품등록!"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
<jsp:include page="/module/footer.jsp" />
</html>