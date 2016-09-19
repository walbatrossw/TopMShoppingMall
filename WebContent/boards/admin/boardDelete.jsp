<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html class="no-js" lang="ko">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<div id="head">
	<jsp:include page="/module/head.jsp" />
</div>
<body>
	<section class="boardDelete">
		<div class="container">
			<div class="row">
				<h2>관리자 공지사항</h2>
				<form name="deleteForm" action="<%=request.getContextPath()%>/Boards/Admin/BoardDeleteAction.bo?num=<%=num%>" method="post">
					<table border=1>
						<tr>
							<td><font size=2>글 비밀번호 : </font></td>
							<td><input name="BOARD_PASS" type="password"></td>
						</tr>
						<tr>
							<td colspan=2 align=center>
								<a href="javascript:deleteForm.submit()">삭제</a> &nbsp;&nbsp; 
								<a href="javascript:history.go(-1)">돌아가기</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</section>
</body>

<div>
	<jsp:include page="/module/footer.jsp" />
</div>
</html>