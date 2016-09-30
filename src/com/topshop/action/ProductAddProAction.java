package com.topshop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductAddProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//multipartRequest를 해야함 
		String savePath="D:\\팀프로젝트\\TopMShoppingMall\\WebContent\\image";
		int sizeLimit = 1024*1024*15;
		
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
/*		String fileName= multi.getFilesystemName("userFile");  
		String originFileName = multi.getOriginalFileName("userFile"); 
		멀티파트 뭐시기 아니라고 오류남. */
		
		String mId = multi.getParameter("mId");
		String productCode = multi.getParameter("productCode");
		String productName = multi.getParameter("productName");
		String productCate = multi.getParameter("productCate");
		String productDetail = multi.getParameter("productDetail");
		int productPrice = (Integer.parseInt(multi.getParameter("productPrice")));
		int productCount = (Integer.parseInt(multi.getParameter("productCount")));
		
		
//		String mId = request.getParameter("mId");
//		String productCode = request.getParameter("productCode");
//		String productName = request.getParameter("productName");
//		String productCate = request.getParameter("productCate");
//		String productDetail = request.getParameter("productDetail");
//		int productPrice = (Integer.parseInt(request.getParameter("productPrice")));
//		int productCount = (Integer.parseInt(request.getParameter("productCount")));
		
		System.out.println(mId + "<-- productCode execute ProductAddProAction.java");
		System.out.println(productCode + "<-- productCode execute ProductAddProAction.java");
		System.out.println(productName + "<-- productName execute ProductAddProAction.java");
		System.out.println(productCate + "<-- productCate execute ProductAddProAction.java");
		System.out.println(productDetail + "<-- productDetail execute ProductAddProAction.java");
		System.out.println(productPrice + "<-- productPrice execute ProductAddProAction.java");		
		System.out.println(productCount + "<-- productCount execute ProductAddProAction.java");
		
		Product product = new Product();
		product.setpCode(productCode).setpName(productName).setpCate(productCate);
		product.setpDetail(productDetail).setpPrice(productPrice).setpCount(productCount).setmId(mId);
		
		ProductDAO dao = new ProductDAO();
		dao.productAdd(product);
		
		ActionForward forward = new ActionForward();
    	forward.setRedirect(true);
    	forward.setPath(request.getContextPath() + "/Plist/ProductList.product");

		return forward;
	}
}
