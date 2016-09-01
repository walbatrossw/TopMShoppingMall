package com.topshop.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductListProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_02 execute productListProAction.java");
		
		ProductDAO dao = new ProductDAO();
		
		ArrayList<Product> getArray = dao.allselect();
		request.setAttribute("productArray",getArray);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
    	forward.setPath("/product/productList.jsp");	
    	return forward;
	}
}
