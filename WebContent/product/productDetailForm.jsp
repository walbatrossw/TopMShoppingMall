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
					<div align="center">상품코드&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.pCode }
				</td>
			</tr>
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">상품명&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.pName }
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">가격&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.pPrice }
				</td>
			</tr>
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">수량&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.pCount}
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">카테고리&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.pCate }
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">등록일&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.pDate }
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">판매자아이디&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.mId }
				</td>
			</tr>
			
			<tr>
				<td style="font-family:돋음; font-size:12">
					<div align="center">판매자연락처&nbsp;&nbsp;</div>
				</td>
				
				<td style="font-family:돋음; font-size:12">
				${productDetail.mPhone }
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
							${productDetail.pDetail }
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
					<c:if test="${member.mLevel==0 or member.mLevel==1}">
						<a href=" ${pageContext.request.contextPath}/Pup/productUpdateForm.product?pCode=${productDetail.pCode}">
							[수정]
						</a>&nbsp;&nbsp;
						<a href=" ${pageContext.request.contextPath}/Pdel/productDelete.product?pCode=${productDetail.pCode}">
							[삭제]
						</a>&nbsp;&nbsp;	
							
					</c:if>

					<a href="${pageContext.request.contextPath}/Plist/ProductList.product">[목록]</a>&nbsp;&nbsp;
					</font>
				</td>
			</tr>
		</table>
	
</div>

</body>
<jsp:include page="/module/footer.jsp"/>
</html>