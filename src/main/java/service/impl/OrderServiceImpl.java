package service.impl;

import java.util.List;

import service.OrderService;
import model.Order;
import dao.OrderDao;


public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	/**
	 * order
	 * 
	 */
	public Integer addOrder(Order order) {
		return orderDao.save(order);
	}

	public void deleteOrder(Order order) {
		orderDao.delete(order);
	}

	public void updateOrder(Order order) {
		orderDao.update(order);
	}

	public Order getOrderById(int id) {
		return orderDao.getOrderById(id);
	}

	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

}
