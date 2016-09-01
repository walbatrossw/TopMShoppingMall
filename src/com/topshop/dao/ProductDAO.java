package com.topshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.topshop.dto.Product;

public class ProductDAO {

	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Product product;
	ArrayList<Product> productArray = new ArrayList<Product>();
	
	public ProductDAO(){
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init Mdao ");
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결이 안되요.. " + ex);
			return;
		}
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
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"DELETE FROM TOP_PRODUCT WHERE p_code=?");
		pstmt.setString(1, pCode);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	//allselect
	public  ArrayList<Product> allselect() throws SQLException,ClassNotFoundException{
		System.out.println("02 allselect Productdao.java");
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"select * from TOP_PRODUCT");
		System.out.println(pstmt);
		rs = pstmt.executeQuery();
		while(rs.next()){
			product = new Product();
			System.out.println(product+"<--before goods allselect Gdao.java");
			product.setpCode(rs.getString("p_code"));
			product.setpName(rs.getString("p_name"));
			product.setmId(rs.getString("m_id"));
			product.setpCate(rs.getString("p_cate"));
			product.setpDetail(rs.getString("p_Detail"));
			product.setpPrice(rs.getInt("p_price"));
			product.setpDate(rs.getString("p_date"));
			product.setpCount(rs.getInt("p_count"));
			
			productArray.add(product);
			System.out.println(product+"<--after allselect Productdao.java");
		}
		rs.close();
		pstmt.close();
		conn.close();
		return productArray;
	}
	
	public void productAdd(Product product) throws SQLException, ClassNotFoundException{
		System.out.println("01_02 gInsert Gdao.java 제발..........................");
		System.out.println(product.getpCode()+"<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		conn=ds.getConnection();
		pstmt = conn.prepareStatement(
				"insert into TOP_PRODUCT values(?,?,?,?,?,sysdate,?,?)");
		
		pstmt.setString(1,product.getpCode() );	
		pstmt.setString(2, product.getpCate());
		pstmt.setString(3, product.getpName());
		pstmt.setInt(4, product.getpPrice());
		pstmt.setInt(5, product.getpCount());
		pstmt.setString(6, product.getpDetail());
		pstmt.setString(7, product.getmId());
	
		System.out.println(pstmt + "<-- pstmt productAdd ProductDAO.java");
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
}
