package action;

import java.util.List;

import model.Book;
import model.Order;
import model.Orderitem;
import service.AppService;
import service.BookService;
import service.OrderService;
import service.OrderitemService;

public class AllOrderitemsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private int orderid;
	private int bookid;
	private int amount;

	private OrderService orderService;
	private OrderitemService orderitemService;
	private BookService bookService;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setOrderitemService(OrderitemService orderitemService) {
		this.orderitemService = orderitemService;
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Override
	public String execute() throws Exception {

		List<Orderitem> orderitems = orderitemService.getAllOrderitems();
		request().setAttribute("orderitems", orderitems);

		List<Order> orders = orderService.getAllOrders();
		request().setAttribute("orders", orders);

		List<Book> books = bookService.getAllBooks();
		request().setAttribute("books", books);

		return SUCCESS;
	}
	
	public String add() throws Exception {
		System.out.println(orderid);
		System.out.println(bookid);
		System.out.println(amount);
		Orderitem orderitem = new Orderitem();
		orderitem.setAmount(amount);
		orderitem.setBookid(bookid);
		orderitem.setOrderid(orderid);
		orderitemService.addOrderitem(orderitem);

		return SUCCESS;
	}
	
	public String update() throws Exception {

		Orderitem orderitem = orderitemService.getOrderitemById(id);
		orderitem.setOrderid(orderid);
		orderitem.setBookid(bookid);
		orderitem.setAmount(amount);
		orderitemService.updateOrderitem(orderitem);

		return SUCCESS;
	}
	
	public String delete() throws Exception {

		Orderitem orderitem = orderitemService.getOrderitemById(id);
		orderitemService.deleteOrderitem(orderitem);

		return SUCCESS;
	}
}
