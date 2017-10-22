package service.impl;

import java.util.List;

import service.OrderitemService;
import model.Orderitem;
import dao.OrderitemDao;

public class OrderitemServiceImpl implements OrderitemService{
	private OrderitemDao orderitemDao;
	public void setOrderitemDao(OrderitemDao orderitemDao) {
		this.orderitemDao = orderitemDao;
	}
	/**
	 * order item
	 * 
	 */
	public Integer addOrderitem(Orderitem orderitem) {
		return orderitemDao.save(orderitem);
	}

	public void deleteOrderitem(Orderitem orderitem) {
		orderitemDao.delete(orderitem);
	}

	public void updateOrderitem(Orderitem orderitem) {
		orderitemDao.update(orderitem);
	}

	public Orderitem getOrderitemById(int id) {
		return orderitemDao.getOrderitemById(id);
	}

	public List<Orderitem> getAllOrderitems() {
		return orderitemDao.getAllOrderitems();
	}

}
