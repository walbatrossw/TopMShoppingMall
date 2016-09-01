package com.topshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.forward.MemberForward;
import com.topshop.inter.MActionInterFace;
import com.topshop.memberaction.MemberInsertProAction;
import com.topshop.memberaction.MemberLoginProAction;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//요청 서블릿 주소 값을 받는다.
    	request.setCharacterEncoding("utf-8");
    	System.out.println("doPro MemberController.java");
		String command = request.getServletPath();
		System.out.println(command + "<-- command MemberController.java");
		System.out.println("----------MemberController.java----------------");
		System.out.println();
		
		MemberForward memberForward = null;
		MActionInterFace memberAction = null;
		
		//요청주소를 받아 조건별로 처리
		if(command.equals("/Member/memberLogin.member")){
			
			System.out.println("로그인 화면 MemberController.java");
			memberForward = new MemberForward();
			memberForward.setRedirect(false);
			memberForward.setPath("/member/login/memberLogin.jsp");
			
		}else if(command.equals("/Member/memberInsertForm.member")){
			
			System.out.println("회원등록 화면 MemberController.java");
			memberForward = new MemberForward();
			memberForward.setRedirect(false);
			memberForward.setPath("/member/insert/memberInsertForm.jsp");
				
		}else if(command.equals("/Member/memberInsertAction.member")){
			//회원 등록 처리 액션
			memberAction = new MemberInsertProAction();
			try {
				//회원 등록 처리
				memberForward = memberAction.action(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/memberLoginPro.member")){
			System.out.println("로그인 처리 MemberController.java");
			//로그인 처리 액션
			memberAction = new MemberLoginProAction();
			try {
				//로그인 처리
				memberForward = memberAction.action(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//포워드방식인가 리다이렉트 방식인가를 확인 하여 각각 처리
		if(memberForward != null){
			if(memberForward.isRedirect()){
				
				response.sendRedirect(memberForward.getPath());
			}else{
				
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(memberForward.getPath());
				System.out.println(memberForward.getPath() + "<--- forward.getPath()[jsp 이동경로]  MemberController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPro(request, response);
	}

}
