package Domain;

public class Coin {
   private String c_name;
   private int c_price;
   private int c_maxcoin;
   private int c_no;
   private int m_no;
   
   public Coin() {
	   
   }
   public String getC_name() {
      return c_name;
   }
   public void setC_name(String c_name) {
      this.c_name = c_name;
   }
   public int getC_price() {
      return c_price;
   }
   public void setC_price(int c_price) {
      this.c_price = c_price;
   }
   public int getC_maxcoin() {
      return c_maxcoin;
   }
   public void setC_maxcoin(int c_maxcoin) {
      this.c_maxcoin = c_maxcoin;
   }
   public int getC_no() {
	   return c_no;
   }
   public void setC_no(int c_no) {
	   this.c_no = c_no;
   }
   
   public Coin(String c_name, int c_price, int c_maxcoin) {
      super();
      this.c_name = c_name;
      this.c_price = c_price;
      this.c_maxcoin = c_maxcoin;
   }
   
   public Coin(int c_no, int c_maxcoin, int c_price, String c_name) {
	      super();
	      this.c_name = c_name;
	      this.c_price = c_price;
	      this.c_maxcoin = c_maxcoin;
	      this.c_no = c_no;
	   }
   
   
   
   
   
}