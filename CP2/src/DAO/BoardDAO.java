package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Board;

public class BoardDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//conn = DriverManager.getConnection(
					//"jdbc:mysql://localhost:3307/javafx?serverTimezone=UTC", "root", "1234");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTimeZone=UTC", "root", "dhkfeh!!12");
			System.out.println("DB연동성공");
		} catch (Exception e) {System.out.println("DB연동실패");}
		
	}
	

	public static  BoardDAO boardDAO = new BoardDAO();
	public static BoardDAO getboardDAO() {
		return boardDAO;
	}
	
	
	
	
	// 게시물등록 메소드
	public boolean boardwrite(Board board) {
		String sql = "insert into board(m_no, b_title, b_contents, b_type, c_no) values (?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getM_no());
			pstmt.setString(2, board.getB_title());
			pstmt.setString(3, board.getB_contents());
			pstmt.setInt(4, board.getB_type());
			pstmt.setInt(5, board.getC_no());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}



}
