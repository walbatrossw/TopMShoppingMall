package com.topshop.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.topshop.dao.ProductDAO;
import com.topshop.dto.Product;
import com.topshop.dto.ProductImgs;
import com.topshop.forward.ActionForward;
import com.topshop.inter.PActionInterFace;

public class ProductAddProAction implements PActionInterFace {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//multipartRequest를 해야함 
		String savePath="D:\\팀프로젝트\\TopMShoppingMall\\WebContent\\image";
		int sizeLimit = 1024*1024*15;
		// new DefaultFileRenamePolicy()​기능 :파일업로드할때 동일한 이름의 파일이 존재할때 파일이름끝에 자동적으로 숫자1씩 증가시켜서 다른이름으로 저장되도록 하는 기능
	
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		


		
		String mId = (String)multi.getParameter("mId");
		String productName = (String)multi.getParameter("productName");
		String productCate = (String)multi.getParameter("productCate");
		String productDetail = (String)multi.getParameter("productDetail");
		int productPrice = (Integer.parseInt(multi.getParameter("productPrice")));
		int productCount = (Integer.parseInt(multi.getParameter("productCount")));
		
		Product product = new Product();
		product.setpName(productName).setpCate(productCate).setpDetail(productDetail).setpPrice(productPrice).setpCount(productCount).setmId(mId);
		
		ProductDAO dao = new ProductDAO();
		int lastKey = dao.productAdd(product);
		
		//이미지 파일 저장
		File img = multi.getFile("productImg");
		String fileName= multi.getFilesystemName("productImg");  //파일이름
		String originFileName = multi.getOriginalFileName("productImg"); //원본파일이름
		String fileType=multi.getContentType("productImg");
		long fileSize = img.length();
		String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1);
		ext = ext.toLowerCase();
		
		System.out.println(fileName);
		System.out.println(originFileName);
		System.out.println(img);
		System.out.println(fileSize);
		System.out.println(ext);
		
		ProductImgs productImgs = new ProductImgs();
		productImgs.setImageName(fileName);
		productImgs.setpCode(lastKey);
		productImgs.setImageType(fileType);
		productImgs.setImageSize(fileSize);
		productImgs.setImageExt(ext);

		dao.productImg(productImgs);//파일정보 db에 입력
		
		ActionForward forward = new ActionForward();
    	forward.setRedirect(true);
    	forward.setPath(request.getContextPath() + "/Plist/ProductList.product");

		return forward;
	}
}
