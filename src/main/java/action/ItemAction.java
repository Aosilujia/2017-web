package action;

import java.sql.Date;

import model.Book;
import service.BookService;
import service.ImgService;

public class ItemAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String author;
	private String publisher;
	private Date date;

	private BookService bookService;
	private ImgService imgService;

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
	
	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}
	
	
	public String getBookbyId() throws Exception{
		Book book = bookService.getBookById(id);
		request().setAttribute("book", book);
		String Img="";
		Img=imgService.getImgbyId(id);
		request().setAttribute("cover", Img);
		return SUCCESS;
	}
}
