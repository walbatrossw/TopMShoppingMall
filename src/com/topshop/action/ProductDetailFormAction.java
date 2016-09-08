package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductDetailFormAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ProductDetailFormAction .java ");
		
		String productCode = request.getParameter("pCode");
		System.out.println(productCode +"< <productCode ProductDetailFormAction ");

		
		ProductDAO dao = new ProductDAO();
		Product product =dao.productSelectforDetail(productCode);
		
		request.setAttribute("productDetail",product);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
    	forward.setPath("/product/productDetailForm.jsp");	
    	return forward;
	}

}
