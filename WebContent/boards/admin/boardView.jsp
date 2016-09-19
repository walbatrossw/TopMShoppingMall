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
</head>

<div id="head">
	<jsp:include page="/module/head.jsp" />
</div>

<body>
<section class="boardInsert">
	<div class="container">
		<div class="row">
			<h2>관리자 공지사항</h2>
			<table cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td colspan="5">관리자 게시판</td>
				</tr>
				
				<tr>
					<td style="font-size:12" height="16">
						<div align="center">제 목&nbsp;&nbsp;</div>
					</td>
					
					<td style="font-size:12">
					<%=board.getBOARD_SUBJECT()%>
					</td>
				</tr>
				
				<tr bgcolor="cccccc">
					<td colspan="2" style="height:1px;">
					</td>
				</tr>
				
				<tr>
					<td style="font-size:12">
						<div align="center">내 용</div>
					</td>
					<td style="font-size:12">
						<table border=0 width=490 height=250 style="table-layout:fixed">
							<tr>
								<td valign=top style="font-size:12">
								<%=board.getBOARD_CONTENT() %>
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
						<a href="<%=request.getContextPath()%>/Boards/Admin/BoardReplyView.bo?num=<%=board.getBOARD_NUM() %>">
						[답변]
						</a>&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/Boards/Admin/BoardModifyView.bo?num=<%=board.getBOARD_NUM() %>">
						[수정]
						</a>&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/Boards/Admin/BoardDeleteView.bo?num=<%=board.getBOARD_NUM() %>">
						[삭제]
						</a>&nbsp;&nbsp;
						<a href="<%=request.getContextPath()%>/Boards/Admin/BoardList.bo">
						[목록]</a>&nbsp;&nbsp;
						</font>
					</td>
				</tr>
			</table>
		</div>
	</div>
</section>
</body>

<div>
	<jsp:include page="/module/footer.jsp" />
</div>
</html>