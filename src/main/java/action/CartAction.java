package action;

import java.io.Console;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import model.Book;
import model.Cart;
import model.Orderitem;
import service.BookService;
import service.CartService;
import service.OrderService;
import service.OrderitemService;
import model.Order;

import org.hibernate.StaleObjectStateException;
import org.hibernate.sql.Delete;
import org.json.JSONObject;

public class CartAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private int amount;
	private String cart;
	private int arrayid;

	private CartService cartService;
	private OrderService orderService;
	private OrderitemService orderitemService;
	private BookService bookService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setOrderitemService(OrderitemService orderitemService) {
		this.orderitemService = orderitemService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public String getCart() {
		return cart;
	}

	public void setArrayid(int arrayid) {
		this.arrayid = arrayid;
	}
	
	public int getArrayid() {
		return arrayid;
	}
	
	public String execute() throws Exception {
		List<Cart> carts = cartService.getAllCarts();
		request().setAttribute("carts", carts);
		return SUCCESS;
	}

	private String Lts(List<Orderitem> list) {
		String string = "";
		Orderitem orderitem;
		for (int i = 0; i < list.size(); i++) {
			orderitem = list.get(i);

			string = string + orderitem.getBookid() + ":" + orderitem.getAmount() + " ";
		}
		return string;

	}

	private Orderitem Sto(String string) {
		Orderitem orderitem = new Orderitem();
		String[] arr = string.split(":");
		orderitem.setBookid(Integer.parseInt(arr[0]));
		orderitem.setAmount(Integer.parseInt(arr[1]));
		return orderitem;
	}

	private List<Orderitem> Stl(String string) {
		List<Orderitem> items = new ArrayList<Orderitem>();
		String[] arr = string.split("\\s+");
		for (String ss : arr) {
			if (ss.equals("") || ss.equals("[]")) {
				break;
			}
			items.add(Sto(ss));
		}
		return items;
	}

	@SuppressWarnings("unchecked")
	public String view() throws Exception {
		List<Orderitem> items0 = new ArrayList<Orderitem>();
		List<Orderitem> items1 = new ArrayList<Orderitem>();
		List<Book> books = new ArrayList<Book>();
		HttpSession httpSession = session();
		int uid = 0;
		if (httpSession.getAttribute("uid") != null) {
			uid = (int) httpSession.getAttribute("uid");
			String cart = cartService.getCartById(uid).getCart();
			if (cart != null) {
				items0 = Stl(cart);
			}
			if (httpSession.getAttribute("newcarts") != null) {
				items1 = (List<Orderitem>) httpSession.getAttribute("newcarts");
				httpSession.setAttribute("newcarts", null);
				System.out.println(items1.size());
			}
			items0.addAll(items1);
			httpSession.setAttribute("carts", items0);
			for (int i = 0; i < items0.size(); i++) {
				int bid = items0.get(i).getBookid();
				Book book = bookService.getBookById(bid);
				books.add(book);
			}
			httpSession.setAttribute("cartbooks", books);
			if (httpSession.getAttribute("cartflag") != null) {
				if (!httpSession.getAttribute("cartflag").equals(0)) {
					if (uid != 0) {
						Cart newcart = cartService.getCartById(uid);
						newcart.setCart(Lts(items0));
						cartService.updateCart(newcart);
						httpSession.setAttribute("cartflag", 0);
					}
				}
			}
		}
		else{
			if (httpSession.getAttribute("newcarts") != null) {
				items1 = (List<Orderitem>) httpSession.getAttribute("newcarts");
			}
			httpSession.setAttribute("carts", items1);
			for (int i = 0; i < items1.size(); i++) {
				int bid = items1.get(i).getBookid();
				Book book = bookService.getBookById(bid);
				books.add(book);
			}
			httpSession.setAttribute("cartbooks", books);
		}
		return SUCCESS;
	}

	public void edit() throws Exception {
		int uid = 0;
		HttpSession httpSession = session();
		Orderitem newitem = new Orderitem();
		List<Orderitem> items = new ArrayList<Orderitem>();
		
		if (httpSession.getAttribute("carts")!=null){
			items=(List<Orderitem>)httpSession.getAttribute("carts");
		}
		newitem=items.get(arrayid);
		newitem.setAmount(amount);
		newitem.setBookid(bookid);
		items.set(arrayid,newitem);
		if (httpSession.getAttribute("uid") != null) {
			uid = (int) httpSession.getAttribute("uid");
			Cart origincart = cartService.getCartById(uid);
			origincart.setCart(Lts(items));
			cartService.updateCart(origincart);
			
		}
		else{
			httpSession.setAttribute("newcarts", items);
			
		}
	}

	public void delete() throws Exception{
		int uid = 0;
		HttpSession httpSession = session();
		Orderitem newitem = new Orderitem();
		List<Orderitem> items = new ArrayList<Orderitem>();
		
		if (httpSession.getAttribute("carts")!=null){
			items=(List<Orderitem>)httpSession.getAttribute("carts");
		}
		items.remove(arrayid);
		if (httpSession.getAttribute("uid") != null) {
			uid = (int) httpSession.getAttribute("uid");
			Cart origincart = cartService.getCartById(uid);
			origincart.setCart(Lts(items));
			cartService.updateCart(origincart);
			
		}
		else{
			httpSession.setAttribute("newcarts", items);
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public String add() throws Exception {

		HttpSession httpSession = session();
		Orderitem newitem = new Orderitem(0, bookid, amount);
		List<Orderitem> items = new ArrayList<Orderitem>();
		if (httpSession.getAttribute("newcarts") != null) {
			items = (List<Orderitem>) httpSession.getAttribute("newcarts");
		}
		items.add(newitem);
		httpSession.setAttribute("cartflag", 1);
		httpSession.setAttribute("newcarts", items);
		return SUCCESS;
	}

	public String takeorder() throws Exception {
		System.out.println("here");
		Date date = new Date(System.currentTimeMillis());
		List<Orderitem> items = new ArrayList<Orderitem>();
		int uid = 0;
		HttpSession httpSession = session();
		if (httpSession.getAttribute("uid") != null) {
			uid = (int) httpSession.getAttribute("uid");

			Cart cart = cartService.getCartById(uid);
			if (cart.getCart() != null && !((cart.getCart()).equals(""))) {
				items = Stl(cart.getCart());
			}
			Order order = new Order();
			order.setUserid(uid);
			order.setDate(date);
			int orderid=orderService.addOrder(order);
			System.out.println("orderid="+orderid);
			for (int i = 0; i < items.size(); i++) {
				Orderitem orderitem = items.get(i);
				orderitem.setOrderid(orderid);
				orderitemService.addOrderitem(orderitem);

			}
			cart.setCart("");
			cartService.updateCart(cart);
		}
		return SUCCESS;
	}

}