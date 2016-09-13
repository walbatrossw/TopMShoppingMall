<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<jsp:include page="/module/head.jsp"/>
<section class="memberList">
	<div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">회원관리 페이지</a>
                </li>
                <li>
                    <a href="#">#</a>
                </li>
                <li>
                    <a href="#">#</a>
                </li>
                <li>
                    <a href="#">#</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="col-sm-1">아이디</th>
							<th class="col-sm-1">이름</th>
							<th class="col-sm-1">권한</th>
							<th class="col-sm-1">나이</th>
							<th class="col-sm-2">연락처</th>
							<th class="col-sm-2">이메일</th>
							<th class="col-sm-2">주소</th>
							<th class="col-sm-1">수정</th>
							<th class="col-sm-1">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${memberList }">
							<tr>
								<td>${member.mId }</td>
								<td>${member.mName }</td>
								<td>${member.mLevel }</td>
								<td>${member.mAge }</td>
								<td>${member.mPhone }</td>
								<td>${member.mEmail }</td>
								<td>${member.mAddr }</td>
								<td><a href="${pageContext.request.contextPath}/Min/m_update_form.ksmart?send_id=${member.mId }">[수정]</a></td>
								<td><a href="${pageContext.request.contextPath}/Min/m_delete_pro.ksmart?send_id=${member.mId }">[삭제]</a></td>									
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
        <!-- /#page-content-wrapper -->
</section>
<jsp:include page="/module/footer.jsp"/>
</body>
</html>