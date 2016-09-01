package com.topshop.boardadminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.dto.Board;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;


public class BoardDetailAction implements BoardActionInterface {
	
	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO boarddao = new BoardDAO();
	   	Board board = new Board();
		
	   	int num = Integer.parseInt(request.getParameter("num"));
		boarddao.setReadCountUpdate(num);
		board=boarddao.getDetail(num);
		
	   	if(board==null){
	   		System.out.println("상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("boarddata", board);
	   	
	   	BoardActionForward forward = new BoardActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("/boards/admin/boardView.jsp");
   		return forward;
	}

}
