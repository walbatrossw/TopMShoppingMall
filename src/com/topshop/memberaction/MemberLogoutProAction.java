package com.topshop.memberaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;

public class MemberLogoutProAction implements MActionInterFace {

	@Override
	public MemberForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그아웃 처리
		MemberForward forward = new MemberForward();
		
		HttpSession session = request.getSession();
		//세션값 초기화
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/main.jsp");
		
		return forward;
	}

}
