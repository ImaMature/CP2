package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReplyDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static ReplyDAO replyDAO = new ReplyDAO();

	public ReplyDAO() {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/coinproject?serverTimezone=UTC", "root", "1234");
//	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root", "dhkfeh!!12");
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	}
	
	public static ReplyDAO getReplyDAO () {
		return replyDAO;
	}
	
}
