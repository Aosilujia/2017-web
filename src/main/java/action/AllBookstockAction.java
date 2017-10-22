package action;

import java.util.List;

import model.Book;
import model.Bookstock;
import service.BookstockService;

public class AllBookstockAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int stock;
	private double price;

	private BookstockService appService;

	public void setBookstockService(BookstockService bookstockService) {
		this.appService = bookstockService;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String execute() throws Exception {
		
		List<Bookstock> bookstocks = appService.getAllBookstocks();
		request().setAttribute("bookstocks", bookstocks);


		return SUCCESS;
	}
	
	public String update() throws Exception{
		Bookstock bookstock = appService.getBookstockById(id);
		bookstock.setStock(stock);
		bookstock.setPrice(price);
		appService.updateBookstock(bookstock);

		return SUCCESS;
	}
	
/*	public String add() throws Exception {

		Bookstock bookstock = new Bookstock(0,stock,price);
		appService.addBookstock(bookstock);

		return SUCCESS;
	}
	*/
	public String delete() throws Exception {

		Bookstock bookstock=appService.getBookstockById(id);
		bookstock.setStock(0);
		bookstock.setPrice(0);
		appService.updateBookstock(bookstock);
		return SUCCESS;
	}
}
