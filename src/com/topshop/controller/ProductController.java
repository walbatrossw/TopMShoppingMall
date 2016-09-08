package com.topshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.topshop.action.ProductAddProAction;
import com.topshop.action.ProductDeleteProAction;
import com.topshop.action.ProductDetailFormAction;
import com.topshop.action.ProductListProAction;
import com.topshop.action.ProductUpdateFormAction;
import com.topshop.action.ProductUpdateProAction;
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
			System.out.println("02 /Pin/productAddForm.product // ProductController.java");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() +"/product/productAddForm.jsp");
		}else if(command.equals("/Plist/ProductList.product")){
			System.out.println("03 /Plist/ProductList.product // ProductController.java");
			action = new  ProductListProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Pdel/productDelete.product")){
			System.out.println("04 //Pdel/productDelete.product // ProductController.java");
			action = new  ProductDeleteProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Pup/productUpdatePro.product")){
			System.out.println("04 /Pup/productUpdatePro.product// ProductController.java");
			action = new  ProductUpdateProAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Pup/productUpdateForm.product")){
			System.out.println("04 /Pup/productUpdateForm.product // ProductController.java");
			action = new  ProductUpdateFormAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Pdeta/productDetail.product")){
			System.out.println("04 /Pdeta/productDetail.product // ProductController.java");
			action = new  ProductDetailFormAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
