package com.topshop.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.forward.ActionForward;


public interface PActionInterFace {
	
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;

}
