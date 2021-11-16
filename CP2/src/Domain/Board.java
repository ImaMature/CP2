package Domain;

public class Board {
	
	private int b_no;
	private int m_no;
	private String b_title;
	private String b_contents;
	private int b_type;
	private int c_no;
	
	public Board() {}

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
	}

	public Board(String b_title, String b_contents, String b_date) {
		super();
		this.b_title = b_title;
		this.b_contents = b_contents;
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
	

	
	
	
	
	
}
