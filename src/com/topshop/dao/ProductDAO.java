package com.topshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.topshop.dto.Product;
import com.topshop.dto.ProductImgs;

public class ProductDAO {

	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Product product;
	ProductImgs productImgs;
	ArrayList<Product> productArray = new ArrayList<Product>();
	
	public ProductDAO(){
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init productDao() ");
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/Mysql");
	  	    // 오라클
	  	   // ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결이 안되요.. " + ex);
			return;
		}
	}
	
	public ProductImgs selectImgs(String pCode) throws SQLException, ClassNotFoundException{
		conn=ds.getConnection();
		pstmt = conn.prepareStatement("select * from top_product_image where p_code=?");
		pstmt.setString(1, pCode);
		rs = pstmt.executeQuery();	
		if(rs.next()){
			productImgs = new ProductImgs();
			productImgs.setImageCode(rs.getInt("image_code"));
			productImgs.setImageName(rs.getString("image_name"));
			productImgs.setImageType(rs.getString("image_type"));
			productImgs.setImageExt(rs.getString("image_ext"));
			productImgs.setImageSize(rs.getLong("image_size"));
		}
		rs.close();
		pstmt.close();
		conn.close();		
		return productImgs;
		
	}
	
	public void productImg(ProductImgs productImgs) throws SQLException, ClassNotFoundException{
		conn=ds.getConnection();
		String fileUploadSql = "insert into top_product_image (P_code, image_name, image_size, image_type,image_ext) values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(fileUploadSql);
		pstmt.setInt(1, productImgs.getpCode());
		pstmt.setString(2, productImgs.getImageName());
		pstmt.setFloat(3, productImgs.getImageSize());
		pstmt.setString(4, productImgs.getImageType());
		pstmt.setString(5, productImgs.getImageExt());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	//productUpdate
		public void productUpdate(Product product) throws SQLException, ClassNotFoundException{
			System.out.println("05 productUpdate ProductDAO.java");
			conn=ds.getConnection();
			pstmt = conn.prepareStatement("UPDATE TOP_PRODUCT SET p_name=?,p_cate=?,p_price=?,p_count=?,p_detail=? WHERE p_code=?");
			System.out.println(pstmt + "<-- pstmt 1");
			
			pstmt.setString(1, product.getpName());
			pstmt.setString(2, product.getpCate());	
			pstmt.setInt(3, product.getpPrice());
			pstmt.setInt(4, product.getpCount());
			pstmt.setString(5, product.getpDetail());
			pstmt.setString(6,product.getpCode() );	
			
			System.out.println(pstmt + "<-- pstmt 2");
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
	//productSelectforUpdate
	public Product productSelectforUpdate(String pCode) throws ClassNotFoundException, SQLException{
		System.out.println(" mSelectforUpdate Gdao.java");
		
		conn=ds.getConnection();
		pstmt = conn.prepareStatement("select * from TOP_PRODUCT where p_code=?");
		pstmt.setString(1, pCode);
		rs = pstmt.executeQuery();	
		if(rs.next()){
			product = new Product();
			
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setmId(rs.getString("m_id"));
			product.setpCate(rs.getString("p_cate"));
			product.setpDetail(rs.getString("p_Detail"));
			product.setpPrice(rs.getInt("p_price"));
			product.setpDate(rs.getString("p_date"));
			product.setpCount(rs.getInt("p_count"));
		}
		rs.close();
		pstmt.close();
		conn.close();		
		return product;
	}
	
	//productDelete
	public void productDelete(String pCode) throws SQLException, ClassNotFoundException{
		System.out.println("06 productDelete productDao.java");
		System.out.println(pCode);
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"DELETE FROM TOP_PRODUCT WHERE p_code=?");
		pstmt.setString(1, pCode);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	//select for detail
	
	public Product productSelectforDetail(String pCode) throws ClassNotFoundException, SQLException{
		System.out.println(pCode+" <<<<<<productSelectforDetail Gdao.java");
		
		
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"SELECT p.p_code as  p_code, p.p_cate as p_cate, p.p_name as p_name, p.p_price as p_price,p.p_date as p_date, "
				+ "p.p_detail as p_detail,p.p_count as p_count, m.m_id as p_id, m.m_name as p_mname, m.m_phone as p_phone "
				+ "FROM top_member m, top_product p "
				+ "WHERE p.p_code = ?");
	
		pstmt.setString(1, pCode);
		rs = pstmt.executeQuery();	
		if(rs.next()){
			product = new Product();
			
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setmId(rs.getString("p_id"));
			product.setpCate(rs.getString("p_cate"));
			product.setpDetail(rs.getString("p_detail"));
			product.setpPrice(rs.getInt("p_price"));
			product.setpDate(rs.getString("p_date"));
			product.setpCount(rs.getInt("p_count"));
			product.setmName(rs.getString("p_mname"));
			product.setmPhone(rs.getString("p_phone"));
			
		}
		rs.close();
		pstmt.close();
		conn.close();		
		return product;
	}
	
	//allselect
	public  ArrayList<Product> allselect(String mId) throws SQLException,ClassNotFoundException{
		System.out.println("02 allselect Productdao.java");
		conn=ds.getConnection();
		if(mId != null){
			pstmt = conn.prepareStatement(
					"SELECT p.p_code as  p_code, p.p_cate as p_cate, p.p_name as p_name, p.p_price as p_price, "
					+ "p.p_count as p_count, m.m_id as p_id, m.m_name as p_mname, m.m_phone as p_phone "
					+ "FROM top_member m, top_product p "
					+ "WHERE m.m_id = ? AND p.m_id = ?");
			pstmt.setString(1, mId);
			pstmt.setString(2, mId);
		}else{
			pstmt = conn.prepareStatement(
					"SELECT p.p_code as  p_code, p.p_cate as p_cate, p.p_name as p_name, p.p_price as p_price, "
					+ "p.p_count as p_count, m.m_id as p_id, m.m_name as p_mname, m.m_phone as p_phone "
					+ "FROM top_member m, top_product p");
		}
		
		System.out.println(pstmt);
		rs = pstmt.executeQuery();
		while(rs.next()){
			product = new Product();
			System.out.println(product+"<--before goods allselect Gdao.java");
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setmId(rs.getString("p_id"));
			product.setpCate(rs.getString("p_cate"));
			product.setpPrice(rs.getInt("p_price"));
			product.setpCount(rs.getInt("p_count"));
			product.setmName(rs.getString("p_mname"));
			product.setmPhone(rs.getString("p_phone"));
			
			productArray.add(product);
			System.out.println(product+"<--after allselect Productdao.java");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return productArray;
	}
	
	public int productAdd(Product product) throws SQLException, ClassNotFoundException{
		System.out.println("01_02 gInsert Gdao.java 제발..........................");
		System.out.println(product.getpCode()+"<<<<<<<<<<<<<<<<<<<<<<<<<<");
		String sql = "insert into TOP_PRODUCT(P_CATE, P_NAME, P_PRICE, P_COUNT, P_DATE, P_DETAIL, M_ID) values(?,?,?,?,now(),?,?)";
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				sql,Statement.RETURN_GENERATED_KEYS);
		
		pstmt.setString(1, product.getpCate());
		pstmt.setString(2, product.getpName());
		pstmt.setInt(3, product.getpPrice());
		pstmt.setInt(4, product.getpCount());
		pstmt.setString(5, product.getpDetail());
		pstmt.setString(6, product.getmId());
	
		System.out.println(pstmt + "<-- pstmt productAdd ProductDAO.java");
		pstmt.executeUpdate();
		ResultSet resultSet = pstmt.getGeneratedKeys();
		int  lastKey = 0;
		if(resultSet.next()){
			lastKey = resultSet.getInt(1);
			System.out.println("다시 받아온 프라이머리키 >>>"+lastKey);
		}
		
		
		pstmt.close();
		conn.close();
		return lastKey;
	}
}
