package Domain;

public class Reply {

	private int r_no; // �亯 ��ȣ
	private String r_contents; // �亯 ����
	private String r_date; // �亯 ��¥
	private int b_no; // �Խù� ��ȣ
	
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
	
	// ��� ��� ������(�α��� ȸ�� ����)
	public Reply(String r_contents, String r_date, int b_no) {
		this.r_contents = r_contents;
		this.r_date = r_date;
		this.b_no = b_no;
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
}