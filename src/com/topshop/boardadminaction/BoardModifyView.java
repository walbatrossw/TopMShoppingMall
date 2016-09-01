package com.topshop.boardadminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.dto.Board;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;


public class BoardModifyView implements BoardActionInterface {

	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardActionForward forward = new BoardActionForward();
	 	request.setCharacterEncoding("UTF-8");
   		
		BoardDAO boarddao=new BoardDAO();
	   	Board board=new Board();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
	   	board=boarddao.getDetail(num);
	   	
	   	if(board==null){
	   		System.out.println("(수정)상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("(수정)상세보기 성공");
	   	
	   	request.setAttribute("boarddata", board);
	   	forward.setRedirect(false);
   		forward.setPath("/boards/admin/boardModify.jsp");
   		return forward;
	}

}
