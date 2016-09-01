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
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/Oracletop");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결이 안되요.. " + ex);
			return;
		}
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
