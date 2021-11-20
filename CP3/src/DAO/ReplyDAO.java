package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReplyDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ReplyDAO() {
	      try {
//	         Class.forName("com.mysql.cj.jdbc.Driver");
//	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/coinproject?serverTimezone=UTC", "root", "1234");
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root", "dhkfeh!!12");
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	}
	

	// 객체 변환 메소드
		public static ReplyDAO replyDAO = new ReplyDAO();
		public static ReplyDAO getreplyDAO() {return replyDAO;}
		
		// 답변을 등록하기 위해서
		public boolean Areply(Reply reply) {
		String sql = "insert into reply(r_no, r_contents, b_no) values (?, ?, ?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getR_no());
			pstmt.setString(2, reply.getR_contents());
			pstmt.setInt(3, reply.getB_no());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {System.out.println(e.getMessage());}
		return false; } 
		
		// 답변 보이는 테이블 뷰
		public ObservableList<Reply> AQnAReplyList(){
			ObservableList<Reply> Areplys = FXCollections.observableArrayList();
			String sql = "select * from reply where r_no = 3 order by b_no desc";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery(sql);
				
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Reply replys = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					Areplys.add(replys);
				} return Areplys;
			} catch (Exception e) { } return Areplys;
		}
		
//		// 답변 보이는 테이블 뷰
//				public Reply MQnAReplyList(int r_no){
//					String sql = "select * from reply where r_no = ? order by b_no desc";
//					
//					try {
//						pstmt = conn.prepareStatement(sql);
//						
//						rs = pstmt.executeQuery(sql);
//						
//						rs=pstmt.executeQuery();
//						while(rs.next()) {
//							Reply replys = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
//						} return replys;
//					} catch (Exception e) { } return null; 
//				}
}
