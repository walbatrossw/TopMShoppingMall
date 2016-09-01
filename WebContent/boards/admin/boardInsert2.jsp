<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>관리자 공지사항</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/Boards/Admin/InsertProAction.bo" method="post">
		<table>
			<tr align="center" valign="middle">
				<td colspan="5">관리자 공지사항</td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12" height="16">
					<div align="center">제 목</div>
				</td>
				<td><input name="BOARD_SUBJECT" type="text" size="50"
					maxlength="100" value="" /></td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12">
					<div align="center">내 용</div>
				</td>
				<td><textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
				</td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12" height="16">
					<div align="center">글쓴이</div>
				</td>
				<td><input name="BOARD_NAME" type="text" size="10"
					maxlength="10" value="" /></td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12" height="16">
					<div align="center">비밀번호</div>
				</td>
				<td><input name="BOARD_PASS" type="password" size="10"
					maxlength="10" value="" /></td>
			</tr>
			<tr bgcolor="cccccc">
				<td colspan="2" style="height: 1px;"></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr align="center" valign="middle">
				<td colspan="5"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
	<!-- 게시판 등록 -->
</body>
</html>