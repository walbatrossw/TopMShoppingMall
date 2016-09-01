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
    	//��û ���� �ּ� ���� �޴´�.
    	request.setCharacterEncoding("utf-8");
    	System.out.println("doPro MemberController.java");
		String command = request.getServletPath();
		System.out.println(command + "<-- command MemberController.java");
		System.out.println("----------MemberController.java----------------");
		System.out.println();
		
		MemberForward memberForward = null;
		MActionInterFace memberAction = null;
		
		//��û�ּҸ� �޾� ���Ǻ��� ó��
		if(command.equals("/Member/memberLogin.member")){
			
			System.out.println("�α��� ȭ�� MemberController.java");
			memberForward = new MemberForward();
			memberForward.setRedirect(false);
			memberForward.setPath("/member/login/memberLogin.jsp");
			
		}else if(command.equals("/Member/memberInsertForm.member")){
			
			System.out.println("ȸ����� ȭ�� MemberController.java");
			memberForward = new MemberForward();
			memberForward.setRedirect(false);
			memberForward.setPath("/member/insert/memberInsertForm.jsp");
				
		}else if(command.equals("/Member/memberInsertAction.member")){
			//ȸ�� ��� ó�� �׼�
			memberAction = new MemberInsertProAction();
			try {
				//ȸ�� ��� ó��
				memberForward = memberAction.action(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Member/memberLoginPro.member")){
			System.out.println("�α��� ó�� MemberController.java");
			//�α��� ó�� �׼�
			memberAction = new MemberLoginProAction();
			try {
				//�α��� ó��
				memberForward = memberAction.action(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//���������ΰ� �����̷�Ʈ ����ΰ��� Ȯ�� �Ͽ� ���� ó��
		if(memberForward != null){
			if(memberForward.isRedirect()){
				
				response.sendRedirect(memberForward.getPath());
			}else{
				
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(memberForward.getPath());
				System.out.println(memberForward.getPath() + "<--- forward.getPath()[jsp �̵����]  MemberController.java");
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
