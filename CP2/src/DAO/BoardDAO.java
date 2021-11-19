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
	
	public static  BoardDAO boardDAO = new BoardDAO(); // BoardDAO에 있는 필드,메소드들을 다른 클래스에서도 쓸 수 있게 하기 위해서 boardDAO 전역변수로 선언
	
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(	"jdbc:mysql://localhost:3307/coinproject?serverTimezone=UTC", "root", "1234");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root", "dhkfeh!!12");
//			System.out.println("DB연동성공");
		} catch (Exception e) {System.out.println("DB연동실패");}
		
	}
	

	public static BoardDAO getboardDAO() {  //저장된 boardDAO를 호출하기 위해 쓰는 메소드
		return boardDAO;
	}
	
	
	
	// 코인 게시판 게시물등록 메소드
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//회원 넘버 빼오는 메소드
	public int boardgetMno(String m_id) {
		try {
			String sql = "select m_no from board where m_id=?";
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
	
	
	
	
	
//// 일반 게시물 출력
//		public ObservableList<Board> ABoardList() {
//			ObservableList<Board> Aboards = FXCollections.observableArrayList();
//			String sql = "select * from board where b_type = 1 order by b_no desc";
//				// 1번 공지사항 타입을 번호로 빼오는것
//			try {
//				pstmt = conn.prepareStatement(sql);
//				rs=pstmt.executeQuery();
//				while(rs.next()) {
//					Board boards = new Board(rs.getInt(1), rs.getString(3), rs.getString(5));
//					Aboards.add(boards);
//				} return Aboards;
//			} catch (Exception e) { } return Aboards;
//		}
//	
	//일반 게시판 빼오기
	/**
	 * @param type
	 * @return
	 */
	public ObservableList<Board> MBoardList( int type, int c_num ) {
		ObservableList<Board> Mboards = FXCollections.observableArrayList();
		String sql = "select * from board where b_type = ? and c_no=? order by b_no desc";
									//게시판 타입이 2번이고 코인넘버가 1인 게시판을 검색한다. 그리고 게시판 넘버에 따라 내림차순으로 정리한다.
		try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, type);
				pstmt.setInt(2, c_num);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					
					Board boards = new Board(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(7));
//					System.out.println("게시판빼오기"+boards.toString());
					Mboards.add(boards);

				} 
				return Mboards;
			
		} catch (Exception e) { System.out.println( e ); } return Mboards;
	}
	
	public ObservableList<Board> QBoardList( int type ) {
		ObservableList<Board> Mboards = FXCollections.observableArrayList();
		String sql = "select * from board where b_type = ?  order by b_no desc";						
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, type);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					
					Board boards = new Board(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(7));
//					System.out.println("게시판빼오기"+boards.toString());
					Mboards.add(boards);

				} 
				return Mboards;
			
		} catch (Exception e) { System.out.println( e ); } return Mboards;
	}

	
	//코인 테이블에 뭐가 있는지 모를 때 필드 개수 빼오기 -> 빼온 필드 개수
	public int CoinRecordCount() {
		String sql = "select count(*) from coin";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			
		}
		return 0;
	}

	//c_name으로 c_no 다시 찾아서 보드에 MReiviewWriteController에서 넣어서 코인으로 게시판 구분지을수 있도록
	public int getc_no (String c_name) {
		String sql = "select c_no from coin where c_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	

	public int ChangeNo() {
		try {
			String sql = "select m_no from board";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	//	public String ChangeName(int m_no) {
	//		String sql = "select m_id"
	//	}
	
	//리뷰게시판 글 삭제
	public boolean ReviewDelete(int b_no) {
		String sql = "delete from board where b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	//리뷰 게시판 글 수정
	public boolean ReviewUpdate(String b_title, String b_contents, int b_no) {
		String sql = "update board set b_title=?, b_contents=? where b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_title);
			pstmt.setString(2, b_contents);
			pstmt.setInt(3, b_no);
			pstmt.executeUpdate();
			System.out.println("a");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("b");
		return false;
	}
	
}
