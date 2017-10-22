package action;

import java.sql.Date;
import java.util.List;

import model.Order;
import model.User;
import service.OrderService;
import service.UserService;

public class AllOrdersAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userid;
	private Date date;

	private OrderService orderService;
	private UserService userService;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {

		List<Order> orders = orderService.getAllOrders();
		request().setAttribute("orders", orders);

		List<User> users = userService.getAllUsers();
		request().setAttribute("users", users);

		return SUCCESS;
	}
	
	public String update() throws Exception {

		Order order = orderService.getOrderById(id);
		order.setUserid(userid);
		order.setDate(date);
		orderService.updateOrder(order);

		return SUCCESS;
	}
	
	public String add() throws Exception {

		Order order = new Order(userid, date,0);
		orderService.addOrder(order);

		return SUCCESS;
	}
	
	public String delete() throws Exception {

		Order order = orderService.getOrderById(id);
		orderService.deleteOrder(order);

		return SUCCESS;
	}
}
