<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.topshop.dto.Board" %>
<%
	Board board=(Board)request.getAttribute("boarddata");
%>
<!DOCTYPE html>
<html class="no-js" lang="ko">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script language="javascript">
	function replyboard(){
		boardform.submit();
	}
	</script>
</head>

<div id="head">
	<jsp:include page="/module/head.jsp" />
</div>

<body>
<section class="boardInsert">
	<div class="container">
		<div class="row">
			<h2>관리자 공지사항</h2>
			<form action="<%=request.getContextPath()%>/Boards/Admin/BoardReplyAction.bo" method="post" name="boardform">
				<input type="hidden" name="BOARD_NUM" value="<%=board.getBOARD_NUM() %>">
				<input type="hidden" name="BOARD_RE_REF" value="<%=board.getBOARD_RE_REF() %>">
				<input type="hidden" name="BOARD_RE_LEV" value="<%=board.getBOARD_RE_LEV() %>">
				<input type="hidden" name="BOARD_RE_SEQ" value="<%=board.getBOARD_RE_SEQ() %>">
				
				<table cellpadding="0" cellspacing="0">
					<tr align="center" valign="middle">
						<td colspan="5">관리자게시판</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12" height="16">
							<div align="center">글쓴이</div>
						</td>
						<td>
							<input name="BOARD_NAME" type="text"/>
						</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12" height="16">
							<div align="center">제 목</div>
						</td>
						<td>
							<input name="BOARD_SUBJECT" type="text" size="50" 
								maxlength="100" value="Re: <%=board.getBOARD_SUBJECT() %>"/>
						</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12">
							<div align="center">내 용</div>
						</td>
						<td>
							<textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
						</td>
					</tr>
					<tr>
						<td style="font-family:돋음; font-size:12">
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
						<a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
						<a href="javascript:history.go(-1)">[뒤로]</a>
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