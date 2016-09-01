package com.topshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.topshop.dto.Board;


public class BoardDAO {
	DataSource dataSource;
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public BoardDAO() {
		try {
			Context init = new InitialContext();
			System.out.println(init + "<-- init BoardDAO() ");
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception exception) {
			System.out.println("DB 연결 실패 : " + exception);
			return;
		}
	}

	// 01 게시글 입력
	public boolean boardInsert(Board board) {
		int num = 0;
		String sql = "";
		int result = 0;
		boolean re = false;

		try {
			connection = dataSource.getConnection();
			System.out.println(connection + "<-- con boardInsert() BoardDAO.java");
			preparedStatement = connection.prepareStatement("select max(board_num) from ADMIN_NOTICE");
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				num = resultSet.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into ADMIN_NOTICE (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql += "BOARD_CONTENT, BOARD_RE_REF," + "BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"
					+ "BOARD_DATE) values(?,?,?,?,?,?,?,?,?,sysdate)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			preparedStatement.setString(2, board.getBOARD_NAME());
			preparedStatement.setString(3, board.getBOARD_PASS());
			preparedStatement.setString(4, board.getBOARD_SUBJECT());
			preparedStatement.setString(5, board.getBOARD_CONTENT());
			preparedStatement.setInt(6, num);
			preparedStatement.setInt(7, 0);
			preparedStatement.setInt(8, 0);
			preparedStatement.setInt(9, 0);

			result = preparedStatement.executeUpdate();
			if (result == 0) {
				re = false;

			} else {
				re = true;
			}

		} catch (Exception ex) {
			System.out.println("boardInsert 에러 : " + ex);
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException ex) {
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
				}
		}
		return re;
	}

	// 02 게시글 리스트
	public List getBoardList(int page, int limit) {

		String board_list_sql = "select * from " + "(select rownum rnum,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT,"
				+ "BOARD_CONTENT,BOARD_RE_REF,BOARD_RE_LEV," + "BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "
				+ "(select * from ADMIN_NOTICE order by BOARD_RE_REF desc,BOARD_RE_SEQ asc)) "
				+ "where rnum>=? and rnum<=?";

		List list = new ArrayList();
		System.out.println(board_list_sql + "<-- board_list_sql getBoardList BoardDAO.java");
		System.out.println(page + "<-- page getBoardList BoardDAO.java");
		System.out.println(limit + "<-- limit getBoardList BoardDAO.java");
		System.out.println();

		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호.
		int endrow = startrow + limit - 1; // 읽을 마지막 row 번호.

		System.out.println(startrow + "<-- startrow getBoardList BoardDAO.java");
		System.out.println(endrow + "<-- endrow getBoardList BoardDAO.java");

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(board_list_sql);
			preparedStatement.setInt(1, startrow);
			preparedStatement.setInt(2, endrow);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Board board = new Board();
				board.setBOARD_NUM(resultSet.getInt("BOARD_NUM"));
				board.setBOARD_NAME(resultSet.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(resultSet.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(resultSet.getString("BOARD_CONTENT"));
				board.setBOARD_RE_REF(resultSet.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(resultSet.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(resultSet.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(resultSet.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(resultSet.getDate("BOARD_DATE"));
				list.add(board);
			}

			return list;
		} catch (Exception ex) {
			System.out.println("getBoardList 에러 : " + ex);
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException ex) {
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

	// 03 게시글 갯수 구하기
	public int getListCount() {
		int x = 0;

		try {

			connection = dataSource.getConnection();
			System.out.println("getConnection");
			preparedStatement = connection.prepareStatement("select count(*) from ADMIN_NOTICE");
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				x = resultSet.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount 에러: " + ex);
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException ex) {
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}
	
	//04 게시글 상세보기
	public Board getDetail(int num) throws Exception {

		Board board = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("select * from ADMIN_NOTICE where BOARD_NUM = ?");
			preparedStatement.setInt(1, num);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				board = new Board();
				board.setBOARD_NUM(resultSet.getInt("BOARD_NUM"));
				board.setBOARD_NAME(resultSet.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(resultSet.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(resultSet.getString("BOARD_CONTENT"));
				board.setBOARD_RE_REF(resultSet.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(resultSet.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(resultSet.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(resultSet.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(resultSet.getDate("BOARD_DATE"));
			}
			return board;
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException ex) {
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
				}
		}
		return null;
		
	}
	
	//05 조회수 업데이트
	public void setReadCountUpdate(int num) throws Exception{
			
			String sql="update ADMIN_NOTICE set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = "+num;
			
			try{
				connection = dataSource.getConnection();
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
			}catch(SQLException ex){
				System.out.println("setReadCountUpdate 에러 : "+ex);
			}
			finally{
				try{
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null) connection.close();
				}
				catch(Exception ex){}
			
		}
	}
	
	//06 게시글 수정
	public boolean boardModify(Board modifyboard) throws Exception{
		
		String sql="update ADMIN_NOTICE set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";
		
		try{
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, modifyboard.getBOARD_SUBJECT());
			preparedStatement.setString(2, modifyboard.getBOARD_CONTENT());
			preparedStatement.setInt(3, modifyboard.getBOARD_NUM());
			preparedStatement.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			if(resultSet!=null)try{resultSet.close();}catch(SQLException ex){}
			if(preparedStatement!=null)try{preparedStatement.close();}catch(SQLException ex){}
			if(connection!=null) try{connection.close();}catch(SQLException ex){}
			}
		return false;
	}
	//07 게시글 삭제
	//08 게시글 댓글
	
	//09 게시글 글쓴이 확인
	public boolean isBoardWriter(int num,String pass){
		String board_sql="select * from ADMIN_NOTICE where BOARD_NUM=?";
		try{
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(board_sql);
			preparedStatement.setInt(1, num);
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
				
			if(pass.equals(resultSet.getString("BOARD_PASS"))){
					return true;
			}
		} catch(SQLException ex) {
				System.out.println("isBoardWriter 에러 : "+ex);
		} finally {
			try{
			if(preparedStatement!=null)preparedStatement.close();
			if(connection!=null) connection.close();
			}catch(Exception ex){
					
			}
		}
			return false;
		}
}
