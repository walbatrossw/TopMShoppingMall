package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductUpdateProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ProductUpdateProAction .java ");
		
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productCate = request.getParameter("productCate");
		String productDetail = request.getParameter("productDetail");
		int productPrice = (Integer.parseInt(request.getParameter("productPrice")));
		int productCount = (Integer.parseInt(request.getParameter("productCount")));
		System.out.println(productCode +"< <productCode ProductUpdateProAction ");
		System.out.println(productName +"< <productName ProductUpdateProAction");
		System.out.println(productCate +"< <productCate ProductUpdateProAction");
		System.out.println(productDetail +"< <productDetail ProductUpdateProAction");
		System.out.println(productPrice +"< <productPrice ProductUpdateProAction");
		System.out.println(productCount +"< <productCount ProductUpdateProAction");
		
		Product product = new Product();
		product.setpCode(productCode);
		product.setpName(productName);
		product.setpCate(productCate);
		product.setpDetail(productDetail);
		product.setpPrice(productPrice);
		product.setpCount(productCount);
		
		ProductDAO dao = new ProductDAO();
		dao.productUpdate(product);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
    	forward.setPath(request.getContextPath() + "/Plist/ProductList.product");

		return forward;
	
	}
}
