<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="ko">
<div id="head">
<jsp:include page="/module/head.jsp"/>
</div>
<script>
	$(document).ready(function(){
		$('#memberId').focus();
		$('#addBtn').click(function(){
			if($('#memberId').val() == '' || !(isNaN($('#memberId').val()))){
				$('#idHelper').text('등록하실 아이디를 입력하세요.');
				$('#memberId').focus();
			}else if($('#memberPw').val() == ''){
				$('#idHelper').text('');
				$('#pwHelper').text('비밀번호가 공백입니다.');
				$('#memberPw').focus();
			}else if($('#memberName').val() == ''|| !(isNaN($('#memberName').val()))){
				$('#pwHelper').text('');
				$('#nameHelper').text('이름을 입력하세요.');
				$('#memberName').focus();
			}else if(isNaN($('#memberAge').val()) || $('#memberAge').val()==''){
				$('#genderHelper').text('');
				$('#ageHelper').text('나이는 숫자만 또는 공백이면 안됩니다.');
				$('#memberAge').focus();
			}else if($('#memberAddr').val()=='' || !(isNaN($('#memberAddr').val()))){
				$('#ageHelper').text('');
				$('#addrHelper').text('주소를 입력하세요.');
				$('#memberAddr').focus();
			}else{
				$('#addrHelper').text('');
				$('#memberForm').submit();
			}
		});
	});
</script>
<section class="memberInsert">
<div class="container">
	<div class="row">
		<!-- <div class="col-md-6"> -->
		<h1>회원가입</h1>
				<form class="form-horizontal" id="memberForm" action="${pageContext.request.contextPath}/Member/memberInsertAction.member" method="post">
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="id">I D : </label>
						<input type="text" name="mId" class="form-control" id="memberId"/><br/>
						<span id="idHelper"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">P W : </label>
						<input type="password" name="mPw" class="form-control" id="memberPw"/><br/>
						<span id="pwHelper"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="name">이름 : </label>
						<input type="text" name="mName" class="form-control" id="memberName"/><br/>
						<span id="nameHelper"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="level">권한 : </label>
						<select name="mLevel" id="memberLevel" class="form-control">
							<option value="1">판매자</option>
							<option value="2">구매자</option>
						</select>
						<span id="levelHelper"></span>		
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="age">나이 : </label>
						<input type="text" name="mAge" class="form-control" id="memberAge"/><br/>
						<span id="ageHelper"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="addr">주소 : </label>
						<input type="text" name="mAddr" class="form-control" id="memberAddr"/><br/>
						<span id="addrHelper"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="phone">연락처 : </label>
						<input type="text" name="mPhone" class="form-control" id="memberPhone"/><br/>
						<span id="phoneHelper"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">이메일 : </label>
						<input type="text" name="mEmail" class="form-control" id="memberEmail"/><br/>
						<span id="emailHelper"></span>
					</div>
					
					<div class="form-group">
						<!-- <input type="button" id="addBtn" value="회원등록"/> -->
						<a id="addBtn" class="form-control">회원등록</a>
					</div>
				</form>
			</div>
		</div>
<!-- 	</div> -->
</section>
<jsp:include page="/module/footer.jsp"/>	
</body>
</html>