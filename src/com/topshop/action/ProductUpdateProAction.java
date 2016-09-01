package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductUpdateProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ProductUpdateProAction .java ");
		
		String mId = request.getParameter("mId");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productCate = request.getParameter("productCate");
		String productDetail = request.getParameter("productDetail");
		int productPrice = (Integer.parseInt(request.getParameter("productPrice")));
		int productCount = (Integer.parseInt(request.getParameter("productCount")));
		
		
		
		
		return null;
	}
}
