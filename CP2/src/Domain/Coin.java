package Domain;

public class Coin {

	
	private int c_maxcoin;
	private int c_price;
	private String c_name;
	
	
	public Coin( int c_maxcoin, int c_price, String c_name) {
		this.c_maxcoin = c_maxcoin;
		this.c_price = c_price;
		this.c_name = c_name;
	}

	public Coin() {}


	public int getC_maxcoin() {
		return c_maxcoin;
	}


	public void setC_maxcoin(int c_maxcoin) {
		this.c_maxcoin = c_maxcoin;
	}


	public int getC_price() {
		return c_price;
	}


	public void setC_price(int c_price) {
		this.c_price = c_price;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	
	
	
}
