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
			System.out.println("DB��������");
		} catch (Exception e) {System.out.println("DB��������");}
		
	}
	

	public static  BoardDAO boardDAO = new BoardDAO(); // BoardDAO�� �ִ� �ʵ�,�޼ҵ���� �ٸ� Ŭ���������� �� �� �ְ� �ϱ� ���ؼ� boardDAO ���������� ����
	public static BoardDAO getboardDAO() {  //����� boardDAO�� ȣ���ϱ� ���� ���� �޼ҵ�
		return boardDAO;
	}
	
	//ȸ�� �ѹ� ������ �޼ҵ�
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
			// 1�� �������� Ÿ���� ��ȣ�� �����°�
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
	
	// �Խù���� �޼ҵ�
	public boolean boardwrite(Board board) { // �Խ��� ���⸦ ���� �޼ҵ� board �����ο� �ִ°� �޾ƿ��� ���ؼ� �Ű������� board ����. 
		String sql = "insert into board(m_no, b_title, b_contents, b_type, c_no) values (?, ?, ?, ?, ?)";
					// board table(DB)�� m_no, b_title b_contetns b_type c_no�� ���޹��� ���� �ִ´�.
					//m_no�� member db���� fk�� �޾ƿ�. b_title�� b_contents�� boardwritecontroller���� .gettext�� �޾ƿ�.
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
