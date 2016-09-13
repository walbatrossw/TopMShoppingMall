<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/module/head.jsp"/>
<section class="myPage">
       <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">마이 페이지</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/Member/memberUpdate.member">회원정보 수정</a>
                </li>
                <li>
                    <a href="#">회원 탈퇴</a>
                </li>
                <li>
                    <a href="#">장바구니</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>MY PAGE</h1>
                        	내용
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
</section>
<jsp:include page="/module/footer.jsp"/>
</body>
</html>