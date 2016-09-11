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
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	//-------------------------------------------------------------------------------
	// 							ȸ������ ���� ó�� �޼���
	//-------------------------------------------------------------------------------
	public int memberUpdate(Member member){
		int result = 0;
		try {
			conn=ds.getConnection();
			
			String memberInfoSql = "UPDATE top_member SET m_pw=?, m_name=?, m_level=?, m_addr=?, m_age=?, m_phone=?, m_email=? WHERE m_id=?";
			pstmt = conn.prepareStatement(memberInfoSql);
			
			pstmt.setString(8, member.getmId());
			pstmt.setString(1, member.getmPw());
			pstmt.setString(2, member.getmName());
			pstmt.setInt(3, member.getmLevel());
			pstmt.setString(4, member.getmAddr());
			pstmt.setInt(5, member.getmAge());
			pstmt.setString(6, member.getmPhone());
			pstmt.setString(7, member.getmEmail());
			
			result = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;	
	}
	
	//-------------------------------------------------------------------------------
	// 							ȸ������ ����Ʈ �޼���
	//-------------------------------------------------------------------------------
	public ArrayList<Member> memberList(){
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			conn=ds.getConnection();
			
			String listSql = "SELECT * FROM top_member";
			pstmt = conn.prepareStatement(listSql);
			
			rs = pstmt.executeQuery();
			//ȸ������Ʈ�� �޾ƿ� ��ü�� ��� ����Ʈ�� add
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
		//����Ʈ ����
		return memberList;
	}
	//-------------------------------------------------------------------------------
	// 							�α��� ó�� �޼���
	//-------------------------------------------------------------------------------
	public Member memberLogin(String mId) throws SQLException{
		Member member = new Member();
		conn=ds.getConnection();
		
		String loginSql = "SELECT * FROM top_member WHERE m_id=?";
		pstmt = conn.prepareStatement(loginSql);
		pstmt.setString(1, mId);
		
		rs = pstmt.executeQuery();
		System.out.println(pstmt);
		
		if(rs.next()){
			String mName = rs.getString("m_name");
			int mLevel = rs.getInt("m_level");
			String mAddr = rs.getString("m_addr");
			int mAge = rs.getInt("m_age");
			String mPhone = rs.getString("m_phone");
			String mEmail = rs.getString("m_email");
			
			member.setmId(rs.getString("m_id")).setmName(mName).setmLevel(mLevel).setmAddr(mAddr).setmAge(mAge).setmPhone(mPhone).setmEmail(mEmail);
			
		}
		
		return member;
	}
	//-------------------------------------------------------------------------------
	// 							�α��� üũ �޼���
	//-------------------------------------------------------------------------------
	public String memberLoginCheck(String mId, String mPw){
		System.out.println("�α���üũ �޼��� MemberDao()");
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
				result = "�α��μ���";
			}else{
				result = "�α��ν���";
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
	// 							ȸ����� �޼���
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
			
	
			//04�ܰ� :Query���� ����
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
