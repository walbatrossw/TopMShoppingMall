package com.topshop.boardadminaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.BoardDAO;
import com.topshop.forward.BoardActionForward;
import com.topshop.inter.BoardActionInterface;


public class BoardListAction implements BoardActionInterface {

	@Override
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("04_02 execute BoardListAction.java"); 
		BoardDAO boarddao=new BoardDAO();
		List boardlist=new ArrayList();
		
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=boarddao.getListCount(); //�� ����Ʈ ���� �޾ƿ�
		boardlist = boarddao.getBoardList(page,limit); //����Ʈ�� �޾ƿ�
		
		//�� ������ ��
 		int maxpage=(int)((double)listcount/limit+0.95); //0.95�� ���ؼ� �ø� ó��
 		//���� �������� ������ ���� ������ ��(1, 11, 21 ��...)
 		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
 		//���� �������� ������ ������ ������ ��(10, 20, 30 ��...)
		int endpage = startpage+10-1;

 		if (endpage> maxpage) endpage= maxpage;

 		
 		request.setAttribute("page", page); //���� ������ ��
 		request.setAttribute("maxpage", maxpage); //�ִ� ������ ��
 		request.setAttribute("startpage", startpage); //���� �������� ǥ���� ù ������ ��
 		request.setAttribute("endpage", endpage); //���� �������� ǥ���� �� ������ ��
		request.setAttribute("listcount",listcount); //�� ��
		request.setAttribute("boardlist", boardlist);
		
		BoardActionForward forward= new BoardActionForward();
	 	forward.setRedirect(false);
 		forward.setPath("/boards/admin/boardList.jsp");
 		return forward;
	}

}
