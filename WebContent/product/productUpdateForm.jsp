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
<jsp:include page="/module/head.jsp"/>
<div class="container">
	<form action=" ${pageContext.request.contextPath}/Pup/productUpdatePro.product" method="post">
		<table width="100%" border="1" class="table">
			<tr align="center" valign="middle">
				<td colspan="5"><h2>상품수정화면</h2></td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">상품코드&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="hidden" name="productCode" size="20" value="${product.pCode}">${product.pCode}
				</td>
			</tr>
			
		
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">상품명&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="text" name="productName" size="20" value="${product.pName}">
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">가격&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="text" name="productPrice" size="20" value="${product.pPrice}">
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">수량&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="text" name="productCount" size="20" value="${product.pCount}">
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">카테고리&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="text" name="productCate" size="20" value="${product.pCate}">
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">등록일&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="hidden" name="productDate" size="20" value="${product.pDate}">${product.pDate}
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">판매자아이디&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="hidden" name="productMid" size="20" value="${product.mId}">${product.mId}
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">판매자연락처&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				<input type="hidden" name="productMid" size="20" value="${product.mId}">${product.mId}
				</td>
			</tr>
			
			<tr bgcolor="cccccc">
				<td colspan="2" style="height:1px;">
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">상세설명</div>
				</td>
				<td style="font-family:돋음; font-size:12">
					<table border=0 width=490 height=250 style="table-layout:fixed">
						<tr>
							<td valign=top style="font-family:돋음; font-size:12">
							<textarea name="productDetail" rows="30" cols = "150">${product.pDetail}</textarea>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr bgcolor="cccccc">
				<td colspan="2" style="height:1px;"></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<tr align="center" valign="middle">
				<td colspan="5">
					<font size=2>
						<input type="submit" value="수정!">
					</font>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
<jsp:include page="/module/footer.jsp" />
</html>