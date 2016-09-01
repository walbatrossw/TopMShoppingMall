package com.topshop.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.topshop.dao.ProductDAO;
import com.topshop.dto.Member;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductListProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_02 execute productListProAction.java");
		HttpSession session = request.getSession();
		Member member = null;
		String mId = null;
		member = (Member) session.getAttribute("member");
		ProductDAO dao = new ProductDAO();
		//System.out.println(member.getmId() + "<-- 넘어온 값");
		if(member != null){
			mId = member.getmId();
		}
		ArrayList<Product> getArray = dao.allselect(mId);
		request.setAttribute("productArray",getArray);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
    	forward.setPath("/product/productList.jsp");	
    	return forward;
	}
}
