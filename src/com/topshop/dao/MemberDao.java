package com.topshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.topshop.dto.Member;

public class MemberDao {
	
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao(){
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init MemberDao() ");
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	//-------------------------------------------------------------------------------
	// 							로그인 처리 메서드
	//-------------------------------------------------------------------------------
	public Member memberLogin(String mId) throws SQLException{
		Member member = new Member();
		PreparedStatement loginPstmt = null;
		
		String loginSql = "SELECT member_no, member_id, member_name FROM member WHERE member_id=?";
		loginPstmt = conn.prepareStatement(loginSql);
		loginPstmt.setString(1, mId);
		
		rs = loginPstmt.executeQuery();
		System.out.println(loginPstmt);
		
		if(rs.next()){
			member.setmId((rs.getString("m_id")));
			member.setmName((rs.getString("m_name")));
			member.setmLevel((rs.getInt("member_level")));
		}
		
		return member;
	}
	//-------------------------------------------------------------------------------
	// 							로그인 체크 메서드
	//-------------------------------------------------------------------------------
	public String memberLoginCheck(String mId, String mPw){
		String result = null;
		
		try {
			conn=ds.getConnection();
			String loginSql = "SELECT m_id, m_level, m_name FROM top_member WHERE member_id=? AND member_pw=?";
			pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			
			if(rs.next()){
				if(rs.next()){
					
					if(rs.getString("member_pw").equals(mPw)){
						result = "로그인성공";
					}else{
						result = "비밀번호불일치";
					}
					
				}else{
					result = "아이디불일치";
				}
				
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close();
		}
		
		
		return result;
	}
	//-------------------------------------------------------------------------------
	// 							회원등록 메서드
	//-------------------------------------------------------------------------------
	public int mInsert(Member m){
		System.out.println("01 mInsert() MemberDao.java");
		
		int result = 0;
		
		try {
			conn=ds.getConnection();
			System.out.println("getConnection");
			//03단계 :Query실행을 위한 statement 또는 prepareStatement객체생성 끝
			pstmt = conn.prepareStatement(
					"INSERT INTO top_member VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			System.out.println(pstmt + "<-- pstmt 1");
			System.out.println(pstmt.getClass() + "<-- pstmt.getClass() 1");
	
			pstmt.setString(1, m.getmId());
			pstmt.setString(2, m.getmPw());
			pstmt.setString(3, m.getmName());
			pstmt.setInt(4, m.getmLevel());
			pstmt.setString(5, m.getmAddr());
			pstmt.setInt(6, m.getmAge());
			pstmt.setString(7, m.getmPhone());
			pstmt.setString(8, m.getmEmail());
			
			System.out.println(pstmt + "<-- pstmt 2");
			
	
			//04단계 :Query실행 시작
			result = pstmt.executeUpdate();		
			
		}catch (SQLException e) {
			e.printStackTrace();	
		}finally{
			close();
		}
		return result;
	}
	
	public void close(){
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
}
