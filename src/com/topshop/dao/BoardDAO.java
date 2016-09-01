package com.topshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
