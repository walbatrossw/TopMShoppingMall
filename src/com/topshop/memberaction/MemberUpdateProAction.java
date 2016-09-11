package com.topshop.memberaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.topshop.dao.MemberDao;
import com.topshop.dto.Member;
import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;

public class MemberUpdateProAction implements MActionInterFace {

	@Override
	public MemberForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member = new Member();
		MemberDao memberDao = new MemberDao();
		
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		String mName = request.getParameter("mName");
		int mLevel = Integer.parseInt(request.getParameter("mLevel"));
		String mAddr = request.getParameter("mAddr");
		int mAge = Integer.parseInt(request.getParameter("mAge"));
		String mPhone = request.getParameter("mPhone");
		String mEmail = request.getParameter("mEmail");
		
		System.out.println(mId + " <- mId action MemberUpdateProAction.java");
		System.out.println(mPw + " <- mPw action MemberUpdateProAction.java");
		System.out.println(mName + " <- mName action MemberUpdateProAction.java");
		System.out.println(mLevel + " <- mLevel action MemberUpdateProAction.java");
		System.out.println(mAddr + " <- mAddr action MemberUpdateProAction.java");
		System.out.println(mAge + " <- mAge action MemberUpdateProAction.java");
		System.out.println(mPhone + " <- mPhone action MemberUpdateProAction.java");
		System.out.println(mEmail + " <- mEmail action MemberUpdateProAction.java");
		
		member.setmId(mId).setmPw(mPw).setmName(mName).setmLevel(mLevel).setmAddr(mAddr).setmAge(mAge).setmPhone(mPhone).setmEmail(mEmail);
		
		int result = memberDao.memberUpdate(member);
		
		if(result != 0){
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		}
		
		MemberForward forward = new MemberForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/main.jsp");
		
		return forward;
	}

}
