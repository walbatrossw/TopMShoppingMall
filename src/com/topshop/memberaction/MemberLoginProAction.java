package com.topshop.memberaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.MemberDao;
import com.topshop.dto.Member;
import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;

public class MemberLoginProAction implements MActionInterFace{

	@Override
	public MemberForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		System.out.println(mId + " <- mId MemberLoginProAction.java");
		System.out.println(mPw + " <- mPw MemberLoginProAction.java");
		
		MemberDao memberDao = new MemberDao();
		String result = memberDao.memberLoginCheck(mId, mPw);
		MemberForward memberForward = new MemberForward();
		if(result.equals("�α��μ���")){
			Member member = new Member();
			member = memberDao.memberLogin(mId);
			
			
		}else if(result.equals("��й�ȣ����ġ")){
			
		}else if(result.equals("���̵����ġ")){
			
		}
		
		
		return null;
	}

}
