<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/module/head.jsp"/>

<div class="container">
		<table width="100%" border="1" class="table">
			<tr align="center" valign="middle">
				<td colspan="5"><h2>상품상세보기</h2></td>
			</tr>
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">상품명&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				상품명 넣는자리 
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">가격&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				가격자리
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">카테고리&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				카테고리자리 
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">등록일&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				등록일
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">판매자아이디&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				판매자아이디
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">판매자연락처&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				판매자연락처
				</td>
			</tr>
			
			<tr bgcolor="cccccc">
				<td colspan="2" style="height:1px;">
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">내용</div>
				</td>
				<td style="font-family:돋음; font-size:12">
					<table border=0 width=490 height=250 style="table-layout:fixed">
						<tr>
							<td valign=top style="font-family:돋음; font-size:12">
							내용넣는자리
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
					<a href="./Pup/productUpdateForm.product?pCode=${product.pCode}">
					[수정]
					</a>&nbsp;&nbsp;
					<a href="./Pdel/productDelete.product?pCode=${product.pCode}">
					[삭제]
					</a>&nbsp;&nbsp;
					<a href="./Plist/ProductList.product">[목록]</a>&nbsp;&nbsp;
					</font>
				</td>
			</tr>
		</table>
	</div>

</body>
<jsp:include page="/module/footer.jsp"/>
</html>