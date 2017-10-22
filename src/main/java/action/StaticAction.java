package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Order;
import model.Orderitem;
import service.BookService;
import service.OrderService;
import service.OrderitemService;
import javax.json.Json;

public class StaticAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private int id;
	private int userid;
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
	
	public String books(){
		List<Orderitem> orderitems=new ArrayList<Orderitem>();
		orderitems=orderitemService.getAllOrderitems();
		List<Book> books = bookService.getAllBooks();
		int[] sales=new int[100];
		for (int i=0;i<books.size();i++){
			sales[i]=0;
		}
		for (int i=0;i<orderitems.size();i++){
			Orderitem item=orderitems.get(i);
			sales[item.getBookid()]+=item.getAmount();
		}
		request().setAttribute("booksale", sales);
		request().setAttribute("books", books);
		return SUCCESS;
	}
	
	
	
}
