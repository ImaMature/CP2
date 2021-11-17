package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Board;
import Domain.Member;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MemberDAO memberDAO = new MemberDAO();
	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/coinproject?serverTimeZone=UTC", "root" , "1234");
//			conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/coinproject?serverTimeZone=UTC", "root" , "dhkfeh!!12");
		} catch (Exception e) {
			System.out.println("DB연동문제"+e.getMessage());
		}
	}
	
	public static MemberDAO getMemberDAO() {return memberDAO;} 
	
	//회원가입
	public boolean RealSignupAction(Member member) { //Member 클래스에 있는 필드들을 받아오기 위해서 member라는 매개변수 선언
		
		String sql = "insert into member (m_id, m_pw, m_name, m_email, m_money, m_holdingcoin) values(?,?,?,?,0,0)"; 
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, member.getM_id());
			preparedStatement.setString(2, member.getM_pw());
			preparedStatement.setString(3, member.getM_name());
			preparedStatement.setString(4, member.getM_email());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//아이디 중복체크
	public boolean idcheck(String m_id) {
		String sql = "select m_id from member where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {return false;}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	//로그인
	public boolean LoginAction(String m_id, String m_pw) {
		String sql = "select * from member where m_id = ? and m_pw =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public String findid(String m_name, String m_email) {
		try{
			String sql = "select m_id from member where m_name=? and m_email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_name);
			pstmt.setString(2, m_email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}else {
				return null;
			}
				
		}catch (Exception e) {
			System.out.println("아이디찾기 오류" + e.getMessage());
		}
		return null;
		
	}
	
	public String findpw(String m_id, String m_email) {
		try {
			String sql = "select m_pw from member where m_id =? and m_email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_email);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1); 
			}else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("비밀번호찾기 오류" + e.getMessage());
		}
		return null;
	}
	//search m_no from m_id
	//회원 아이디를 기준으로 회원 번호 빼오기
	public int getMemberNo(String m_id) {
		try {
			String sql = "select m_no from member where m_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				return rs.getInt(1);
			}else {
				return 0;
			}
		}catch (Exception e) {
			System.out.println("getMemberNo" + e.getMessage());
		}
		return 0;
	}
	
	//search member(회원조회) method 회원번호 기준
	public Member getmemberinfo(int loginNo) {
		String sql = "select*from member where m_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, loginNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Member member = new Member(rs.getInt(1),rs.getString(2)," ",rs.getString(4), 
						rs.getString(5), rs.getInt(6),rs.getInt(7));
				return member;
			}else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("getmemberinfo() method error");
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//delete member(회원탈퇴) method
	public boolean deletemember(String m_id) {
		String sql = "delete from member where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("deletemember method err");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//update (회원정보수정) method
	public boolean MInfoUpdate(String m_name, String m_email, String m_pw, String m_id) {
		String sql = "update member set m_name=?, m_email=?, m_pw=? where m_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_name);
			pstmt.setString(2, m_email);
			pstmt.setString(3, m_pw);
			pstmt.setString(4, m_id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("MInfoUpdate method err");
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	
}
