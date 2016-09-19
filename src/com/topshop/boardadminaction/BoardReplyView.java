package com.topshop.boardadminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.dto.Board;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;

public class BoardReplyView implements BoardActionInterface {

	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardActionForward forward = new BoardActionForward();
	 	
		BoardDAO boarddao=new BoardDAO();
   		Board boarddata=new Board();
   		
   		int num=Integer.parseInt(request.getParameter("num"));
   		
   		boarddata=boarddao.getDetail(num);
   		
   		if(boarddata==null){
   			System.out.println("답장 페이지 이동 실패");
   			return null;
   		}
   		System.out.println("답장 페이지 이동 완료");
   		
   		request.setAttribute("boarddata", boarddata);
   		forward.setRedirect(false);
   		forward.setPath("/boards/admin/boardReply.jsp");
   		return forward;
	}

}
