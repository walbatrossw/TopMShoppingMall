package com.topshop.boardadminaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;


public class BoardDeleteAction implements BoardActionInterface {

	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardActionForward forward = new BoardActionForward();
		request.setCharacterEncoding("UTF-8");
		
		boolean result = false;
		boolean usercheck = false;
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO boarddao=new BoardDAO();
	   	usercheck=boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
	   	
	   	if(usercheck==false){
	   		response.setContentType("text/html;charset=UTF-8");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('삭제할 권한이 없습니다.');");
	   		out.println("location.href='"+ request.getContextPath()+"/Boards/Admin/BoardList.bo';");
	   		out.println("</script>");
	   		out.close();
	   		return null;
	   	}
	   	
	   	result=boarddao.boardDelete(num);
	   	if(result==false){
	   		System.out.println("게시판 삭제 실패");
	   		return null;
	   	}
	   	
	   	System.out.println("게시판 삭제 성공");
	   	forward.setRedirect(true);
   		forward.setPath(request.getContextPath()+"/Boards/Admin/BoardList.bo");
   		return forward;
	}

}
