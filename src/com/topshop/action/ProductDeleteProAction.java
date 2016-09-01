package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.dao.ProductDAO;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductDeleteProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pCode = request.getParameter("pCode");
		System.out.println(pCode);
		ProductDAO dao = new ProductDAO();
		dao.productDelete(pCode);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/Plist/ProductList.product");
		
		return forward;
	}

}
