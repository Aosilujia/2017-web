package service.impl;

import java.util.List;

import dao.CartDao;
import model.Cart;
import service.CartService;

public class CartServiceImpl implements CartService{
	
	private CartDao cartDao;
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	public Integer addCart(Cart cart) {
		return cartDao.save(cart);
	}

	public void deleteCart(Cart cart) {
		cartDao.delete(cart);
	}

	public void updateCart(Cart cart) {
		cartDao.update(cart);
	}

	public Cart getCartById(int id) {
		return cartDao.getCartById(id);
	}

	public List<Cart> getAllCarts() {
		return cartDao.getAllCarts();
	}
}
