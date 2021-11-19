package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Coin;

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
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/coinproject?serverTimezone=UTC", "root", "1234");
//      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root", "dhkfeh!!12");
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
   }
   
   // db�� ������ �ִ� �޼ҵ�
   public void inPrice(String c_name, int c_price, int c_holding) {
      try {
         
         String sql = "insert into coin(c_name, c_price, c_holding) values (?, ?, ?)";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, c_name);
         pstmt.setInt(2, c_price);
         pstmt.setInt(3, c_holding);
         
         pstmt.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }
   
   
   // db���� ������ �������� �޼ҵ�
   public int outPrice(String c_name) {
      try {
         
         String sql = "select c_price from coin where c_name = ?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, c_name);
         
         rs = pstmt.executeQuery();
         if(rs.next()) {
            return rs.getInt(1);
         }
         return 0;
         
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return 0;
      }
   }
   
   // db�� ������ �ǽð� ������Ʈ�ϴ� �޼ҵ�
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
   
   // ���� ������ ������ �޼ҵ�
   public int coinCol() {
      try {
         
         String sql = "select count(*) from coin";
         pstmt = conn.prepareStatement(sql);
         
         rs = pstmt.executeQuery();
         if(rs.next()) {
            return rs.getInt(1);
         }
         return 0;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return 0;
      }
   }
   
   
   // ���� �̸�, ����, �Ѱ����� ������ �޼ҵ�
   public Coin getCoinStatus(int c_no) {
      try {
         
         String sql = "select c_name, c_price, c_holding from coin where c_no = ?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, c_no);
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            Coin coin = new Coin(rs.getString(1), rs.getInt(2), rs.getInt(3));
            return coin;
         }
         return null;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }
   
   // ���� ��ȣ�� �޾� ���� �̸��� ��ȯ���ִ� �޼ҵ�
   public String getCoinName(int c_no) {
      try {
         
         String sql = "select c_name from coin where c_no = ?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, c_no);
         
         rs = pstmt.executeQuery();
         while(rs.next()) {
            return rs.getString(1);
         }
         return null;
      } catch (SQLException e) {
         System.out.println(e.getMessage());
         return null;
      }
   }
   
   
   
}