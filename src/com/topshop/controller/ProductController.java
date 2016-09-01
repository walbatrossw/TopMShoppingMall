package com.topshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.action.ProductAddProAction;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductController() {
        super();
    }
    private void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("03 doPro ProductController.java");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		
		System.out.println(RequestURI + "<-- RequestURI ProductController.java");
		System.out.println(contextPath + "<-- contextPath ProductController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() ProductController.java");
		System.out.println(command + "<-- command ProductController.java");
		System.out.println("----------ProductController.java----------------");
		System.out.println();
		ActionForward forward = null;
		PActionInterFace action= null;
		
		if(command.equals("/Pin/productAddPro.product")){
			System.out.println("01 /Pin/productAddPro.product // ProductController.java");
			action = new  ProductAddProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Pin/productAddForm.product")){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() +"/product/productAddForm.jsp");
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				
				response.sendRedirect(forward.getPath());
			}else{
				
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp 이동경로]  MemberController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ProductController");
		doPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost ProductController");
		doPro(request,response);
	}

}
