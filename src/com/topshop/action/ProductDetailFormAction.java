package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductDetailFormAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//¹¹ ¼¿·ºÆ® Äõ¸®~~ 
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
    	forward.setPath("/product/productDetailForm.jsp");	
    	return forward;
	}

}
