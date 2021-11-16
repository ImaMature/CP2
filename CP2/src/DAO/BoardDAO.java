package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	

	public static  BoardDAO boardDAO = new BoardDAO(); // BoardDAO에 있는 필드,메소드들을 다른 클래스에서도 쓸 수 있게 하기 위해서 boardDAO 전역변수로 선언
	public static BoardDAO getboardDAO() {  //저장된 boardDAO를 호출하기 위해 쓰는 메소드
		return boardDAO;
	}
	
	//회원 넘버 빼오는 메소드
	public int boardgetMno(String m_id) {
		try {
			String sql = "select m_no from board where m_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				return rs.getInt(1);
			}else {
				return 0;
			}
		}catch (Exception e) {
			System.out.println("boardgetMno" + e.getMessage());
		}
		return 0;
	}
	
	public ObservableList<Board> MBoardList() {
		ObservableList<Board> Mboards = FXCollections.observableArrayList();
		String sql = "select b_no from board where b_type = 2 order by c_no desc";
		int i = 0;
		try {
			// 1번 공지사항 타입을 번호로 빼오는것
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Board boards = new Board(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6));
					{
					Mboards.add(boards);
				} return Mboards;
			}
		} catch (Exception e) { } return Mboards;
	}
	
	// 게시물등록 메소드
	public boolean boardwrite(Board board) { // 게시판 쓰기를 위한 메소드 board 도메인에 있는걸 받아오기 위해서 매개변수로 board 선언. 
		String sql = "insert into board(m_no, b_title, b_contents, b_type, c_no) values (?, ?, ?, ?, ?)";
					// board table(DB)에 m_no, b_title b_contetns b_type c_no에 전달받은 값을 넣는다.
					//m_no는 member db에서 fk로 받아옴. b_title과 b_contents는 boardwritecontroller에서 .gettext로 받아옴.
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
