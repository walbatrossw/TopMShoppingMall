package com.topshop.boardadminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.dto.Board;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;

public class InsertProAction implements BoardActionInterface {

	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("04_01 execute InsertProAction.java");

		// 01�ܰ� ȭ�鿡�� �Է��� ���� Ȯ���Ѵ�
		String boardName = request.getParameter("BOARD_NAME");
		String boardPw = request.getParameter("BOARD_PASS");
		String boardSubject = request.getParameter("BOARD_SUBJECT");
		String boardContent = request.getParameter("BOARD_CONTENT");
		System.out.println(boardName + "<-- boardName execute In InsertProAction.java");
		System.out.println(boardPw + "<-- boardPw execute In InsertProAction.java");
		System.out.println(boardSubject + "<-- boardSubject execute In InsertProAction.java");
		System.out.println(boardContent + "<-- boardContent execute In InsertProAction.java");

		// 02�ܰ� DTO(VO)��ü���� ����
		Board board = new Board();
		board.setBOARD_NAME(boardName);
		board.setBOARD_PASS(boardPw);
		board.setBOARD_SUBJECT(boardSubject);
		board.setBOARD_CONTENT(boardContent);

		// 03�ܰ� DAOŬ������ �Է�ó�� �޼��� ȣ��
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardInsert(board);

		// 04�ܰ� ����Ʈ�� �����̷�Ʈ �ϱ� ���ؼ� MActionForwardŬ���� ���ؼ� ������ ��ü����
		// ��� ���� �� �ּҰ��� ����
		BoardActionForward forward = new BoardActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/Boards/Admin/BoardList.bo");
		return forward;
	}

}
