<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="ko">
<div id="head">
<jsp:include page="/module/head.jsp"/>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
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
				<form id="memberForm" action="${pageContext.request.contextPath}/Member/memberInsertAction.member" method="post">
					
						<h2>회원가입</h2>
	
					<div>
						<label><h3>I D : </h3></label>
						<input type="text" name="mId" id="memberId" class="text"/><br/>
						<span id="idHelper"></span>
					</div>
					
					<div>
						<label><h3>P W : </h3></label>
						<input type="password" name="mPw" id="memberPw" class="text"/><br/>
						<span id="pwHelper"></span>
					</div>
					
					<div>
						<label><h3>이름 : </h3></label>
						<input type="text" name="mName" id="memberName" class="text"/><br/>
						<span id="nameHelper"></span>
					</div>
					
					<div>
						<label><h3>권한</h3> </label>
						<select name="mLevel" id="memberLevel" class="text">
							<option value="1">판매자</option>
							<option value="2">구매자</option>
						</select>
						<span id="levelHelper"></span>		
					</div>
					
					<div>
						<label><h3>나이 : </h3></label>
						<input type="text" name="mAge" class="text" id="memberAge"/><br/>
						<span id="ageHelper"></span>
					</div>
					
					<div>
						<label><h3>주소 : </h3></label>
						<input type="text" name="mAddr" class="text" id="memberAddr"/><br/>
						<span id="addrHelper"></span>
					</div>
					
					<div>
						<label><h3>연락처 : </h3></label>
						<input type="text" name="mPhone" class="text" id="memberPhone"/><br/>
						<span id="phoneHelper"></span>
					</div>
					<div>
						<label><h3>이메일 : </h3></label>
						<input type="text" name="mEmail" class="text" id="memberEmail"/><br/>
						<span id="emailHelper"></span>
					</div>
					
					<div>
						<!-- <input type="button" id="addBtn" value="회원등록"/> -->
						<a id="addBtn" class="btn">회원등록</a>
					</div>
			
				</form>
			</div>
		</div>
<!-- 	</div> -->
</section>
<jsp:include page="/module/footer.jsp"/>	
</body>
</html>