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

		// 01단계 화면에서 입력한 값을 확인한다
		String boardName = request.getParameter("BOARD_NAME");
		String boardPw = request.getParameter("BOARD_PASS");
		String boardSubject = request.getParameter("BOARD_SUBJECT");
		String boardContent = request.getParameter("BOARD_CONTENT");
		System.out.println(boardName + "<-- boardName execute In InsertProAction.java");
		System.out.println(boardPw + "<-- boardPw execute In InsertProAction.java");
		System.out.println(boardSubject + "<-- boardSubject execute In InsertProAction.java");
		System.out.println(boardContent + "<-- boardContent execute In InsertProAction.java");

		// 02단계 DTO(VO)객체내에 셋팅
		Board board = new Board();
		board.setBOARD_NAME(boardName);
		board.setBOARD_PASS(boardPw);
		board.setBOARD_SUBJECT(boardSubject);
		board.setBOARD_CONTENT(boardContent);

		// 03단계 DAO클래스내 입력처리 메서드 호출
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.boardInsert(board);

		// 04단계 리스트로 리다이렉트 하기 위해서 MActionForward클래스 통해서 생성된 객체내에
		// 경로 셋팅 후 주소값을 리턴
		BoardActionForward forward = new BoardActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/Boards/Admin/BoardList.bo");
		return forward;
	}

}
