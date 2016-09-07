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
	public ArrayList<Member> memberList(){
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			conn=ds.getConnection();
			
			String listSql = "SELECT * FROM top_member";
			pstmt = conn.prepareStatement(listSql);
			
			rs = pstmt.executeQuery();
			//회원리스트를 받아와 객체에 담아 리스트에 add
			while(rs.next()){
				Member member = new Member();
				String mId = rs.getString("m_id");
				String mName = rs.getString("m_name");
				int mLevel = rs.getInt("m_level");
				String mAddr = rs.getString("m_addr");
				int mAge = rs.getInt("m_age");
				String mPhone = rs.getString("m_phone");
				String mEmail = rs.getString("m_email");
				
				member.setmId(mId).setmName(mName).setmLevel(mLevel).setmAddr(mAddr).setmAge(mAge).setmPhone(mPhone).setmEmail(mEmail);
				
				memberList.add(member);	
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//리스트 리턴
		return memberList;
	}
	//-------------------------------------------------------------------------------
	// 							로그인 처리 메서드
	//-------------------------------------------------------------------------------
	public Member memberLogin(String mId) throws SQLException{
		Member member = new Member();
		conn=ds.getConnection();
		
		String loginSql = "SELECT m_id, m_name, m_level FROM top_member WHERE m_id=?";
		pstmt = conn.prepareStatement(loginSql);
		pstmt.setString(1, mId);
		
		rs = pstmt.executeQuery();
		System.out.println(pstmt);
		
		if(rs.next()){
			member.setmId((rs.getString("m_id")));
			member.setmName((rs.getString("m_name")));
			member.setmLevel((rs.getInt("m_level")));
		}
		
		return member;
	}
	//-------------------------------------------------------------------------------
	// 							로그인 체크 메서드
	//-------------------------------------------------------------------------------
	public String memberLoginCheck(String mId, String mPw){
		System.out.println("로그인체크 메서드 MemberDao()");
		String result = null;
		
		try {
			conn=ds.getConnection();
			String loginSql = "SELECT m_id, m_pw, m_level, m_name FROM top_member WHERE m_id=? AND m_pw=?";
			pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);
			
			
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			
			if(rs.next()){
				result = "로그인성공";
			}else{
				result = "로그인실패";
			}
				
			return result;
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
