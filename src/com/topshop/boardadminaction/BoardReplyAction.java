package com.topshop.boardadminaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.dto.Board;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;


public class BoardReplyAction implements BoardActionInterface {

	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
	 	BoardActionForward forward = new BoardActionForward();
	 	
		BoardDAO boarddao=new BoardDAO();
   		Board boarddata=new Board();
   		int result=0;
   		
   		boarddata.setBOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
   		boarddata.setBOARD_NAME(request.getParameter("BOARD_NAME"));
   		boarddata.setBOARD_PASS(request.getParameter("BOARD_PASS"));
   		boarddata.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
   		boarddata.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT"));
   		boarddata.setBOARD_RE_REF(Integer.parseInt(request.getParameter("BOARD_RE_REF")));
   		boarddata.setBOARD_RE_LEV(Integer.parseInt(request.getParameter("BOARD_RE_LEV")));
   		boarddata.setBOARD_RE_SEQ(Integer.parseInt(request.getParameter("BOARD_RE_SEQ")));
   		
   		result=boarddao.boardReply(boarddata);
   		if(result==0){
   			System.out.println("답장 실패");
   			return null;
   		}
   		System.out.println("답장 완료");
   		
   		forward.setRedirect(true);
   		forward.setPath(request.getContextPath()+"/Board/Admin/BoardDetailAction.bo?num="+result);
   		return forward;
	}

}
