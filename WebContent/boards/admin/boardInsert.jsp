<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form class="form-horizontal" action="<%=request.getContextPath()%>/Boards/Admin/InsertProAction.bo" method="post">
				<div class="form-group" >
					<label class="control-label col-sm-2">제목:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="BOARD_SUBJECT" id="BOARD_SUBJECT" placeholder="제목을 입력하세요">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">내용:</label>
					<div class="col-sm-10">
						<textarea class="form-control" name="BOARD_CONTENT" id="BOARD_CONTENT" placeholder="내용을 입력하세요" cols="67" rows="15"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">글쓴이:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="BOARD_NAME" id="BOARD_NAME" placeholder="글쓴이를 입력하세요">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">비밀번호:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="BOARD_PASS" id="BOARD_PASS" placeholder="비밀번호를 입력하세요">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" value="게시글 등록">
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
</body>

<div>
	<jsp:include page="/module/footer.jsp" />
</div>
</html>