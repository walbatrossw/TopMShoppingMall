package com.topshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.boardadminaction.InsertProAction;
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
		System.out.println("02 doProcess�޼��� ȣ�� BoardController.java");
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
		// 01�ܰ� : ��û�ּҸ� �޾� ���Ǻ��� ó��
		if (command.equals("/Boards/Admin/BoardInsert.bo")) {
			System.out.println("03_01 ���ǹ���(�Խñ��Է�ȭ��) /Boards/Admin/BoardInsert.bo IN BoardController.java");
			forward = new BoardActionForward();
			forward.setRedirect(false);
			forward.setPath("/boards/admin/boardInsert.jsp");
			forward.toString();

		} else if (command.equals("/Boards/Admin/InsertProAction.bo")) {
			System.out.println("03_02 ���ǹ���(�Խñ��Է�ó��) /Boards/Admin/InsertProAction.bo IN BoardController.java");
			action = new InsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 02�ܰ� : ������ �� ���ΰ�? �����̷�Ʈ �� ���ΰ�?
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath()); // �����̷�Ʈ
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����] IN BoardController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("01_01 doGet�޼��� ȣ�� BoardController.java");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("01_02 doPost�޼��� ȣ�� BoardController.java");
		doProcess(request, response);
	}

}
