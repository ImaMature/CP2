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
	
	public static  BoardDAO boardDAO = new BoardDAO(); // BoardDAO�� �ִ� �ʵ�,�޼ҵ���� �ٸ� Ŭ���������� �� �� �ְ� �ϱ� ���ؼ� boardDAO ���������� ����
	
	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(	"jdbc:mysql://localhost:3307/coinproject?serverTimezone=UTC", "root", "1234");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root", "dhkfeh!!12");
//			System.out.println("DB��������");
		} catch (Exception e) {System.out.println("DB��������");}
		
	}
	

	public static BoardDAO getboardDAO() {  //����� boardDAO�� ȣ���ϱ� ���� ���� �޼ҵ�
		return boardDAO;
	}
	
	
	
	// ���� �Խ��� �Խù���� �޼ҵ�
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//ȸ�� �ѹ� ������ �޼ҵ�
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
	
	
	
	
	
//// �Ϲ� �Խù� ���
//		public ObservableList<Board> ABoardList() {
//			ObservableList<Board> Aboards = FXCollections.observableArrayList();
//			String sql = "select * from board where b_type = 1 order by b_no desc";
//				// 1�� �������� Ÿ���� ��ȣ�� �����°�
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
	//�Ϲ� �Խ��� ������
	/**
	 * @param type
	 * @return
	 */
	public ObservableList<Board> MBoardList( int type, int c_num ) {
		ObservableList<Board> Mboards = FXCollections.observableArrayList();
		String sql = "select * from board where b_type = ? and c_no=? order by b_no desc";
									//�Խ��� Ÿ���� 2���̰� ���γѹ��� 1�� �Խ����� �˻��Ѵ�. �׸��� �Խ��� �ѹ��� ���� ������������ �����Ѵ�.
		try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, type);
				pstmt.setInt(2, c_num);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					
					Board boards = new Board(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(7));
//					System.out.println("�Խ��ǻ�����"+boards.toString());
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
//					System.out.println("�Խ��ǻ�����"+boards.toString());
					Mboards.add(boards);

				} 
				return Mboards;
			
		} catch (Exception e) { System.out.println( e ); } return Mboards;
	}

	
	//���� ���̺� ���� �ִ��� �� �� �ʵ� ���� ������ -> ���� �ʵ� ����
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

	//c_name���� c_no �ٽ� ã�Ƽ� ���忡 MReiviewWriteController���� �־ �������� �Խ��� ���������� �ֵ���
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
	
	//����Խ��� �� ����
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
	//���� �Խ��� �� ����
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
