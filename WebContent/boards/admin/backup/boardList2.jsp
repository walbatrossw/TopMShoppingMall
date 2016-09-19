<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.topshop.dto.Board"%>

<%
	List boardList = (List) request.getAttribute("boardlist");
	int listcount = ((Integer) request.getAttribute("listcount")).intValue();
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = ((Integer) request.getAttribute("maxpage")).intValue();
	int startpage = ((Integer) request.getAttribute("startpage")).intValue();
	int endpage = ((Integer) request.getAttribute("endpage")).intValue();
%>

<!DOCTYPE html>
<html class="no-js" lang="ko">
<jsp:include page="/module/head.jsp" />
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>관리자 공지사항</h3>
		<div class="table-responsive">
			<table class="table" width=50% border="0" cellpadding="0" cellspacing="0">
				<%
					if (listcount > 0) {
				%>
				<tr align="center" valign="middle">
					<td colspan="4">관리자게시판</td>
					<td align=right><font size=2>글 개수 : ${listcount }</font></td>
				</tr>

				<tr align="center" valign="middle" bordercolor="#333333">
					<td style="font-family: Tahoma; font-size: 8pt;" width="8%"
						height="26">
						<div align="center">번호</div>
					</td>
					<td style="font-family: Tahoma; font-size: 8pt;" width="50%">
						<div align="center">제목</div>
					</td>
					<td style="font-family: Tahoma; font-size: 8pt;" width="14%">
						<div align="center">작성자</div>
					</td>
					<td style="font-family: Tahoma; font-size: 8pt;" width="17%">
						<div align="center">날짜</div>
					</td>
					<td style="font-family: Tahoma; font-size: 8pt;" width="11%">
						<div align="center">조회수</div>
					</td>
				</tr>

				<%
					for (int i = 0; i < boardList.size(); i++) {
							Board bl = (Board) boardList.get(i);
				%>
				<tr align="center" valign="middle" bordercolor="#333333" onmouseover="this.style.backgroundColor='F8F8F8'"
					onmouseout="this.style.backgroundColor=''">
					<td height="23" style="font-family: Tahoma; font-size: 10pt;">
						<%=bl.getBOARD_NUM()%>
					</td>
					<td style="font-family: Tahoma; font-size: 10pt;">
						<div align="left">
							<%
								if (bl.getBOARD_RE_LEV() != 0) {
							%>
							<%
								for (int a = 0; a <= bl.getBOARD_RE_LEV() * 2; a++) {
							%>
							&nbsp;
							<%
								}
							%>
							▶
							<%
								} else {
							%>
							▶
							<%
								}
							%>
							<a href="<%=request.getContextPath()%>/Board/Admin/BoardDetailAction.bo?num=<%=bl.getBOARD_NUM()%>">
								<%=bl.getBOARD_SUBJECT()%>
							</a>
						</div>
					</td>

					<td style="font-family: Tahoma; font-size: 10pt;">
						<div align="center"><%=bl.getBOARD_NAME()%></div>
					</td>
					<td style="font-family: Tahoma; font-size: 10pt;">
						<div align="center"><%=bl.getBOARD_DATE()%></div>
					</td>
					<td style="font-family: Tahoma; font-size: 10pt;">
						<div align="center"><%=bl.getBOARD_READCOUNT()%></div>
					</td>
				</tr>
				<%
					}
				%>
				<tr align=center height=20>
					<td colspan=7 style="font-family: Tahoma; font-size: 10pt;">
						<%
							if (nowpage <= 1) {
						%> [이전]&nbsp; 
						<%
 							} else {
 						%> <a href="<%=request.getContextPath()%>/Boards/Admin/BoardList.bo?page=<%=nowpage - 1%>">[이전]</a>&nbsp; <%
 							}
 						%> 
 						<%
 							for (int a = startpage; a <= endpage; a++) {
 								if (a == nowpage) {
 						%> 
 							[<%=a%>] 
 						<%
 							} else {
						%> 
						<a href="<%=request.getContextPath()%>/Boards/Admin/BoardList.bo?page=<%=a%>">[<%=a%>]</a>&nbsp; 
						<%
 							}
						%>
						<%
 							}
						%>
						<%
 							if (nowpage >= maxpage) {
						%> 
						[다음]
						<%
 							} else {
						%> <a href="<%=request.getContextPath()%>/Boards/Admin/BoardList.bo?page=<%=nowpage + 1%>">[다음]</a> <%
 							}
						%>
					</td>
				</tr>
				<%
							} else {
				%>
				<tr align="center" valign="middle">
					<td colspan="4">MVC 게시판</td>
					<td align=right><font size=2>등록된 글이 없습니다.</font></td>
				</tr>
				<%
							}
				%>
				<tr align="right">
					<td colspan="5"><a
						href="<%=request.getContextPath()%>/Boards/Admin/BoardInsert.bo">[글쓰기]</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
<jsp:include page="/module/footer.jsp" />
</html>
