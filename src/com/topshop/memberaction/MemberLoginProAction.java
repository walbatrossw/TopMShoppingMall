package com.topshop.memberaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.topshop.dao.MemberDao;
import com.topshop.dto.Member;
import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;

public class MemberLoginProAction implements MActionInterFace{

	@Override
	public MemberForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�α��� ó�� �׼�
		//�Է� ���̵�� ��й�ȣ�� �޾ƿɴϴ�.
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		System.out.println(mId + " <- mId MemberLoginProAction.java");
		System.out.println(mPw + " <- mPw MemberLoginProAction.java");
		
		MemberDao memberDao = new MemberDao();
		//�α��� üũ �޼��� ����
		String result = memberDao.memberLoginCheck(mId, mPw);
		MemberForward forward = new MemberForward();
		if(result.equals("�α��μ���")){
			System.out.println(result);
			Member member = new Member();
			member = memberDao.memberLogin(mId);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/main.jsp");

		}else if(result.equals("�α��ν���")){
			System.out.println(result);
			request.setAttribute("loginResult", result);
			forward.setRedirect(false);
			forward.setPath("/member/login/memberLogin.jsp");
		}
		
		
		return forward;
	}

}
