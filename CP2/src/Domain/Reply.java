package Domain;

import DAO.MemberDAO;
import DAO.ReplyDAO;

public class Reply {

	private int r_no; // 답변 번호
	private String r_contents; // 답변 내용
	private String r_date; // 답변 날짜
	private int b_no; // 게시물 번호
	private String m_id;
	
	
	public Reply() {}
	
	public Reply( String r_contents , int b_no) {
		
		this.r_contents = r_contents;
		
		this.b_no = b_no;
	}


	public Reply(int r_no, String r_contents, String r_date, int b_no) {
		this.r_no = r_no;
		this.r_contents = r_contents;
		this.r_date = r_date;
		this.b_no = b_no;
	}
	
//	//AQnAReplyList
//	public Reply(int r_no, String r_contents, String r_date, int b_no, String m_id) {
//		this.r_no = r_no;
//		this.r_contents = r_contents;
//		this.r_date = r_date;
//		this.b_no = b_no;
//		this.m_id = MemberDAO.getMemberDAO().getMid(ReplyDAO.getreplyDAO().B_noToM_no(b_no));
//	
//	}
	
	// 댓글 등록 생성자(로그인 회원 입장)
	public Reply(String r_contents, String r_date, int b_no) {
		this.r_contents = r_contents;
		
		this.b_no = b_no;
	}

	public Reply(String r_contents, String r_date) {
		this.r_contents = r_contents;
		this.r_date = r_date;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_contents() {
		return r_contents;
	}

	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}