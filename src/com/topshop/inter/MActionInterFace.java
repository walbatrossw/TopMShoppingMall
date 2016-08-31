package com.topshop.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.forward.MemberForward;

public interface MActionInterFace {
	public MemberForward action(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
