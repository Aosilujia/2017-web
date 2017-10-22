package model;

public class Cart {
	private int id;
	private String cart;
	
	public Cart() {

	}
	
	public Cart(int id,String cart){
		this.id=id;
		this.cart=cart;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setCart(String cart) {
		this.cart = cart;
	}
	
	public String getCart() {
		return cart;
	}
	
}
