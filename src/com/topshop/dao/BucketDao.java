package com.topshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.topshop.dto.Bucket;

public class BucketDao {
	
	DataSource dataSource;
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public BucketDao() {
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init BoardDAO() ");
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception exception) {
			System.out.println("DB ���� ���� : " + exception);
			return;
		}
	}
	
	//-----------------------------------------------------------
	//						��ٱ��� ���
	//-----------------------------------------------------------
	public int addBucket(Bucket bucket){
		
		
		return 0;
	}
}
