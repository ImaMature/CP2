package Domain;

import DAO.BoardDAO;
import DAO.MemberDAO;

public class Board {
	
	private int b_no;
	private int m_no;
	private String b_title;
	private String b_contents;
	private String b_date;
	private int b_type;
	private int c_no;
	private String writer;
	
	public Board() {}

	//코인 리뷰 게시물 작성
	public Board(int m_no, String b_title, String b_contents, String b_date, int c_no) {
		this.m_no = m_no;
		this.writer = MemberDAO.getMemberDAO().getMid(m_no);
		this.b_contents = b_contents;
		this.b_title = b_title;
		this.b_date = b_date;
		this.c_no = c_no;
	}

	//문의게시판
	public Board(int m_no, String b_title, String b_contents, int b_type, int c_no) {
		this.m_no = m_no;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_type = b_type;
		this.c_no = c_no;
	}

	public Board(int b_no, int m_no, String b_title, String b_contents, int b_type, int c_no) {
		this.b_no = b_no;
		this.m_no = m_no;
		this.b_title = b_title;
		this.b_contents = b_contents;
		this.b_type = b_type;
		this.c_no = c_no;
		int nameList = BoardDAO.getboardDAO().ChangeNo();
		this.writer = MemberDAO.getMemberDAO().getMid(nameList);
		
	}
	//게시물 출력
	public Board(String b_title, String writer, String b_date) {
		this.b_title = b_title;
		int nameList = BoardDAO.getboardDAO().ChangeNo();
		this.writer = MemberDAO.getMemberDAO().getMid(nameList);
		this.b_date = b_date;
	}
	
	// admin게시물 출력 생성자
		public Board(int b_no, String b_title, String b_date) {
			this.b_no = b_no;
			this.b_title = b_title;
			this.b_date = b_date;
		}

//	public Board(String b_title, String writer, String b_date, int c_no) {
//		this.b_title = b_title;
//		this.writer = writer;
//		this.b_date = b_date;
//		this.c_no = c_no;
//	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	public int getB_type() {
		return b_type;
	}

	public void setB_type(int b_type) {
		this.b_type = b_type;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

}
