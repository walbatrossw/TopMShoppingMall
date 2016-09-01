package com.topshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.boardadminaction.BoardDetailAction;
import com.topshop.boardadminaction.BoardInsertProAction;
import com.topshop.boardadminaction.BoardListAction;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("02 doProcess메서드 호출 BoardController.java");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI IN BoardController.java");
		System.out.println(contextPath + "<-- contextPath IN BoardController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() IN BoardController.java");
		System.out.println(command + "<-- command IN BoardController.java");
		System.out.println("<-------------------BoardController.java------------------->");
		System.out.println();

		BoardActionForward forward = null;
		BoardActionInterface action = null;

		// 01단계 : 요청주소를 받아 조건별로 처리

		if (command.equals("/Boards/Admin/BoardInsert.bo")) {
			System.out.println("03_01 조건문내(게시글입력화면) /Boards/Admin/BoardInsert.bo IN BoardController.java");
			forward = new BoardActionForward();
			forward.setRedirect(false);
			forward.setPath("/boards/admin/boardInsert.jsp");
			forward.toString();

		} else if (command.equals("/Boards/Admin/InsertProAction.bo")) {
			System.out.println("03_02 조건문내(게시글입력처리) /Boards/Admin/InsertProAction.bo IN BoardController.java");
			action = new BoardInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Boards/Admin/BoardList.bo")) {
			System.out.println("03_03 조건문내(게시글리스트) /Boards/Admin/BoardList.bo IN BoardController.java");
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else if(command.equals("/Board/Admin/BoardDetailAction.bo")){
			System.out.println("03_04 조건문내(게시글상세보기) /Board/Admin/BoardDetailAction.bo IN BoardController.java");
			action = new BoardDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
		
		
		// 02단계 : 포워드 할 것인가? 리다이렉트 할 것인가?
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath()); // 리다이렉트
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp 이동경로] IN BoardController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("01_01 doGet메서드 호출 BoardController.java");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("01_02 doPost메서드 호출 BoardController.java");
		doProcess(request, response);
	}

}
