package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Coin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoinDAO {
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;

   public static CoinDAO dao = new CoinDAO();

   public static CoinDAO getDAO() {
      return dao;
   }

   public CoinDAO() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/coinproject?serverTimeZone=UTC", "root", "1234");
//         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root", "dhkfeh!!12");
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

   }

   // db에 가격을 넣는 메소드
   public void inPrice(String c_name, int c_price, int c_maxcoin) {
      try {

         String sql = "insert into coin(c_name, c_price, c_maxcoin) values (?, ?, ?)";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, c_name);
         pstmt.setInt(2, c_price);
         pstmt.setInt(3, c_maxcoin);

         pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   // db에서 가격을 가져오는 메소드
   public int outPrice(String c_name) {
      try {

         String sql = "select c_price from coin where c_name = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, c_name);

         rs = pstmt.executeQuery();
         if (rs.next()) {
            return rs.getInt(1);
         }
         return 0;

      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return 0;
      }
   }

   // db에 가격을 실시간 업데이트하는 메소드
   public void updateCoin(int c_no, int c_price) {
      try {

         String sql = "update coin set c_price = ? where c_no = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setInt(1, c_price);
         pstmt.setInt(2, c_no);

         pstmt.executeUpdate();

      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   // 코인 개수를 가져올 메소드
   public int coinCol() {
      try {

         String sql = "select count(*) from coin";
         pstmt = conn.prepareStatement(sql);

         rs = pstmt.executeQuery();
         if (rs.next()) {
            return rs.getInt(1);
         }
         return 0;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return 0;
      }
   }

   // 코인 이름, 가격, 총개수를 가져올 메소드
   public Coin getCoinStatus(int c_no) {
      try {

         String sql = "select c_name, c_price, c_maxcoin from coin where c_no = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setInt(1, c_no);

         rs = pstmt.executeQuery();
         while (rs.next()) {
            Coin coin = new Coin(rs.getString(1), rs.getInt(2), rs.getInt(3));
            return coin;
         }
         return null;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }

   // 코인 번호를 받아 코인 이름을 반환해주는 메소드
   public String getCoinName(int c_no) {
      try {

         String sql = "select c_name from coin where c_no = ?";
         pstmt = conn.prepareStatement(sql);

         pstmt.setInt(1, c_no);

         rs = pstmt.executeQuery();
         while (rs.next()) {
            return rs.getString(1);
         }
         return null;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }

   // 모든 코인의 이름을 반환해주는 메소드
   public String getAllCoinName() {
      try {

         String sql = "select c_name from coin";
         pstmt = conn.prepareStatement(sql);

         rs = pstmt.executeQuery();
         while (rs.next()) {
            return rs.getString(1);
         }
         return null;

      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }

   // 코인의 이름을 받아 번호를 반환해주는 메소드
   public int getCoinNo(String c_name) {
      try {

         String sql = "select c_no from coin where c_name = ?";
         pstmt = conn.prepareStatement(sql);

         rs = pstmt.executeQuery();
         if (rs.next()) {
            return rs.getInt(1);
         }
         return 0;

      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return 0;
      }
   }

   
   
   
   //코인 테이블 뷰(회원정보에 보일거)
   public ObservableList<Coin> coinManagelist(){
	   ObservableList<Coin> coins = FXCollections.observableArrayList();
	   
	   String sql = "select * from coin order by c_no desc";
	   try {
		   pstmt = conn.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while(rs.next()) {
			   Coin coin = new Coin(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			   coins.add(coin);
		   }
		   return coins;
	   } catch (Exception e) {
		   // TODO: handle exception
	   }
	   return null;
	   
   }
   
   
   //코인삭제
   //DB 다른 테이블에서 c_no가 fk되어있어서 삭제할 수 없다고 자꾸 뜨는데 애초에 db만들때 ON DELETE CASCADE를 해줬어야함
   //1. ALTER TABLE 테이블명 DROP FOREIGN KEY 포린키이름; 이 문법으로 DB에서 포린키 삭제하고
   // 2. 
//   ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건이름] FOREIGN KEY(컬럼명)
//
//   REFERENCES [부모테이블명](PK컬럼명) [ON DELETE CASCADE / ON UPDATE CASCADE];
   
   // 위 문법으로 포린키 추가해줘야됨
   // 참조 
   //	https://daily-life-of-bsh.tistory.com/207
   //	https://blog.naver.com/PostView.nhn?blogId=imf4&logNo=220779978513
   //	코인 리뷰 게시판 때문
   public boolean coindelete (int c_no) {
	   String sql = "delete from coin where c_no=?";
		  try {
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, c_no);
			  pstmt.executeUpdate();
			  return true;
		  } catch (Exception e) {
				System.out.println("colindelet : " + e.getMessage());
		  }
		return false;		   
   }
   
   //코인 등록하기
   public boolean coinReg(String c_name, int c_price, int c_maxcoin) {
	      try {

	         String sql = "insert into coin(c_name, c_price, c_maxcoin) values (?, ?, ?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, c_name);
	         pstmt.setInt(2, c_price);
	         pstmt.setInt(3, c_maxcoin);
	         pstmt.executeUpdate();
	         return true;
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
		return false;
	   }
   
}
   
