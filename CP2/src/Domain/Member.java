package Domain;

public class Member {

	private int m_no;
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private int m_money;
	private int m_holdingcoin;
	private String m_inputcoinname;
	
	
	public Member() {}
	

	public Member(int m_no, String m_id, String m_pw, String m_name, String m_email, int m_money, int m_holdingcoin) {
		super();
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_money = m_money;
		this.m_holdingcoin = m_holdingcoin;
	}




	public Member(String m_id, String m_pw, String m_name, String m_email) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
	}

	
	

	public Member(int m_no, String m_id, String m_pw, String m_name, String m_email, int m_money, int m_holdingcoin,
			String m_inputcoinname) {
		this.m_no = m_no;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_money = m_money;
		this.m_holdingcoin = m_holdingcoin;
		this.m_inputcoinname = m_inputcoinname;
	}



	public Member(String m_inputcoinname) {
		this.m_inputcoinname = m_inputcoinname;
	}




	public Member(String[] memberCoin) {
		this.m_inputcoinname = m_inputcoinname;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getM_pw() {
		return m_pw;
	}


	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getM_email() {
		return m_email;
	}


	public void setM_email(String m_email) {
		this.m_email = m_email;
	}


	public int getM_money() {
		return m_money;
	}


	public void setM_money(int m_money) {
		this.m_money = m_money;
	}


	public int getM_holdingcoin() {
		return m_holdingcoin;
	}


	public void setM_holdingcoin(int m_holdingcoin) {
		this.m_holdingcoin = m_holdingcoin;
	}


	public String getM_inputcoinname() {
		return m_inputcoinname;
	}


	public void setM_inputcoinname(String m_inputcoinname) {
		this.m_inputcoinname = m_inputcoinname;
	}



	
	
	
}
