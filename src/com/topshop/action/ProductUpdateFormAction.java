package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductUpdateFormAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		String pCode = request.getParameter("pCode");
		System.out.println(pCode + "<-- pCode ProductUpdateFormAction.java");
	
		ProductDAO dao = new ProductDAO();
		Product product =dao.productSelectforUpdate(pCode);
		
		request.setAttribute("product",product);
	   	
		forward.setRedirect(false);
   		forward.setPath("/product/productUpdateForm.jsp");
   		return forward;
	
	}

}
