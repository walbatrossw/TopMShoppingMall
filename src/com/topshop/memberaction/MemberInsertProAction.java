package com.topshop.memberaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.MemberDao;
import com.topshop.dto.Member;
import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;

public class MemberInsertProAction implements MActionInterFace {

	@Override
	public MemberForward action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원 가입 처리 메서드");
		//화면에서 입력한 값을 확인한다.
		
		String mId = request.getParameter("mId"); 
		String mPw = request.getParameter("mPw");
		String mName = request.getParameter("mName");
		int mLevel = Integer.parseInt(request.getParameter("mLevel"));
		String mAddr = request.getParameter("mAddr");
		int mAge = Integer.parseInt(request.getParameter("mAge"));
		String mPhone = request.getParameter("mPhone");
		String mEmail = request.getParameter("mEmail");
		
		System.out.println(mId + " <- mId action MemberInsertProAction.java");
		System.out.println(mPw + " <- mPw action MemberInsertProAction.java");
		System.out.println(mName + " <- mName action MemberInsertProAction.java");
		System.out.println(mLevel + " <- mLevel action MemberInsertProAction.java");
		System.out.println(mAddr + " <- mAddr action MemberInsertProAction.java");
		System.out.println(mAge + " <- mAge action MemberInsertProAction.java");
		System.out.println(mPhone + " <- mPhone action MemberInsertProAction.java");
		System.out.println(mEmail + " <- mEmail action MemberInsertProAction.java");
		
		//02단계 : DTO(VO)객체내에 셋팅
		Member member = new Member();
		member.setmId(mId).setmPw(mPw).setmName(mName).setmLevel(mLevel).setmAddr(mAddr).setmAge(mAge).setmPhone(mPhone).setmEmail(mEmail);
		
		
		
		//03단계 : DAO클래스내 입력처리 메서드 호출
		MemberDao memberDao = new MemberDao();
		int result = memberDao.mInsert(member);
			
		//04단계 : 리스트로 리다이렉트 하기 위해서 MActionForward 클래스를 통해서 생성된 객체내에
		//경로 셋팅후 주소값을 리턴
		MemberForward forward = new MemberForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/main.jsp");
		
		return forward;
		
	}

}
