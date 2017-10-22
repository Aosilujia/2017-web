package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.CartDao;
import model.Cart;

public class CartDaoImpl extends HibernateDaoSupport implements CartDao{

	@Override
	public Integer save(Cart cart) {
		return (Integer) getHibernateTemplate().save(cart);
	}

	@Override
	public void delete(Cart cart) {
		getHibernateTemplate().delete(cart);
	}

	@Override
	public void update(Cart cart) {
		getHibernateTemplate().merge(cart);
	}

	@Override
	public Cart getCartById(int id) {
		@SuppressWarnings("unchecked")
		List<Cart> carts = (List<Cart>) getHibernateTemplate().find(
				"from Cart as c where c.id=?", id);
		Cart cart = carts.size() > 0 ? carts.get(0) : null;
		return cart;
	}

	@Override
	public List<Cart> getAllCarts() {
		@SuppressWarnings("unchecked")
		List<Cart> carts = (List<Cart>) getHibernateTemplate()
				.find("from Cart");
		return carts;
	}

}
