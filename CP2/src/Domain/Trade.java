package Domain;

public class Trade {

	private int t_no;
	private int t_tradeprice;
	private int m_no;
	private int c_no;
	
	
	public Trade(int t_no, int t_tradeprice, int m_no, int c_no) {
		this.t_no = t_no;
		this.t_tradeprice = t_tradeprice;
		this.m_no = m_no;
		this.c_no = c_no;
	}


	public int getT_no() {
		return t_no;
	}


	public void setT_no(int t_no) {
		this.t_no = t_no;
	}


	public int getT_tradeprice() {
		return t_tradeprice;
	}


	public void setT_tradeprice(int t_tradeprice) {
		this.t_tradeprice = t_tradeprice;
	}


	public int getM_no() {
		return m_no;
	}


	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public int getC_no() {
		return c_no;
	}


	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	
	
	
}
