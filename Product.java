package Model;

public class Product {
	private String product_name;//same as sql
	private int product_id;//same as sql
	private int product_price;//same as sql 
	private int product_quantity;//same as sql
	private int product_minsell;//same as sql
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_minsell() {
		return product_minsell;
	}
	public void setProduct_minsell(int product_minsell) {
		this.product_minsell = product_minsell;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
 
}
