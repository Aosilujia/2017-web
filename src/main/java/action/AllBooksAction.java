package action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Book;
import service.BookService;

public class AllBooksAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String author;
	private String publisher;
	private Date date;

	private BookService bookService;

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public String execute() throws Exception {

		List<Book> books = bookService.getAllBooks();
		request().setAttribute("books", books);

		return SUCCESS;
	}
	
	public String add() throws Exception {

		Book book = new Book(title, author, publisher, date);
		bookService.addBook(book);

		return SUCCESS;
	}
	
	public String delete() throws Exception {

		Book book = bookService.getBookById(id);
		bookService.deleteBook(book);

		return SUCCESS;
	}
	
	public String update() throws Exception {

		Book book = bookService.getBookById(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setDate(date);
		bookService.updateBook(book);

		return SUCCESS;
	}
	
	public String getBookbyId() throws Exception{
		Book book = bookService.getBookById(id);
		request().setAttribute("book", book);
		return SUCCESS;
	}
	
}
