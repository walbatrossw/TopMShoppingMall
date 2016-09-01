package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductAddProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String mId = request.getParameter("mId");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productCate = request.getParameter("productCate");
		String productDetail = request.getParameter("productDetail");
		int productPrice = (Integer.parseInt(request.getParameter("productPrice")));
		int productCount = (Integer.parseInt(request.getParameter("productCount")));
		
		System.out.println(mId + "<-- productCode execute ProductAddProAction.java");
		System.out.println(productCode + "<-- productCode execute ProductAddProAction.java");
		System.out.println(productName + "<-- productName execute ProductAddProAction.java");
		System.out.println(productCate + "<-- productCate execute ProductAddProAction.java");
		System.out.println(productDetail + "<-- productDetail execute ProductAddProAction.java");
		System.out.println(productPrice + "<-- productPrice execute ProductAddProAction.java");		
		System.out.println(productCount + "<-- productCount execute ProductAddProAction.java");
		
		Product product = new Product();
		product.setpCode(productCode).setpName(productName).setpCate(productCate);
		product.setpDetail(productDetail).setpPrice(productPrice).setpCount(productCount).setmId(mId);
		
		ProductDAO dao = new ProductDAO();
		dao.productAdd(product);
		
		ActionForward forward = new ActionForward();
    	forward.setRedirect(true);
    	forward.setPath(request.getContextPath() + "/Plist/ProjectList.product");

		return forward;
	}
}
