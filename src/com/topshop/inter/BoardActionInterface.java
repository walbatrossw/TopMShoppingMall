package com.topshop.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.forward.BoardActionForward;

public interface BoardActionInterface {
	public BoardActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
