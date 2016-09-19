<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.topshop.dto.Board" %>
<%
	Board board = (Board)request.getAttribute("boarddata");
%>
<!DOCTYPE html>
<html class="no-js" lang="ko">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>

<div id="head">
	<jsp:include page="/module/head.jsp" />
</div>

<body>
<section class="boardModify">
	<div class="container">
		<div class="row">
			<h2>관리자 공지사항</h2>
			<form action="<%=request.getContextPath()%>/Boards/Admin/BoardModifyAction.bo" method="post" name="modifyform">
			<input type="hidden" name="BOARD_NUM" value=<%=board.getBOARD_NUM() %>>
			<table cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td colspan="5">관리자 게시판</td>
				</tr>
				<tr>
					<td height="16" style="font-size:12">
						<div align="center">제 목</div>
					</td>
					<td>
						<input name="BOARD_SUBJECT" size="50" maxlength="100" 
							value="<%=board.getBOARD_SUBJECT()%>">
					</td>
				</tr>
				<tr>
					<td style="font-size:12">
						<div align="center">내 용</div>
					</td>
					<td>
						<textarea name="BOARD_CONTENT" cols="67" rows="15"><%=board.getBOARD_CONTENT() %></textarea>
					</td>
				</tr>
				<tr>
					<td height="16" style="font-family:돋음; font-size:12">
						<div align="center">비밀번호</div>
					</td>
					<td>
						<input name="BOARD_PASS" type="password">
					</td>
				</tr>
				<tr bgcolor="cccccc">
					<td colspan="2" style="height:1px;">
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				
				<tr align="center" valign="middle">
					<td colspan="5">
						<font size=2>
						<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
						<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
						</font>
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