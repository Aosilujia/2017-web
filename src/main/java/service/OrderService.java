package service;

import java.util.List;

import model.Order;

public interface OrderService {
	/**
	 * order
	 * 
	 */
	public Integer addOrder(Order order);

	public void deleteOrder(Order order);

	public void updateOrder(Order order);

	public Order getOrderById(int id);

	public List<Order> getAllOrders();

}
