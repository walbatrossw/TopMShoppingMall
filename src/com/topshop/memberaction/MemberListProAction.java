package com.topshop.memberaction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.MemberDao;
import com.topshop.dto.Member;
import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;

public class MemberListProAction implements MActionInterFace {

	@Override
	public MemberForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Member> memberList = null;
		MemberDao memberDao = new MemberDao();
		
		memberList = memberDao.memberList();
		
		request.setAttribute("memberList", memberList);
		
		MemberForward forward = new MemberForward();
		
		forward.setRedirect(false);
		forward.setPath("/member/list/memberList.jsp");
		
		return forward;
	}

}
