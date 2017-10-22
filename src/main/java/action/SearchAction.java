package action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import service.BookService;
import service.ImgService;

public class SearchAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String author;
	private String publisher;
	private Date date;
	private String word;

	private BookService bookService;
	private ImgService imgService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setWord(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setImgService(ImgService imgService) {
		this.imgService = imgService;
	}

	public String book() {
		List<Book> books = bookService.searchBooks(word);
		request().setAttribute("books", books);
		List<String> covers = new ArrayList<String>();
		for (int i = 0; i < books.size(); i++) {
			int bookid = books.get(i).getId();
			covers.add(imgService.getImgbyId(bookid));
		}
		request().setAttribute("covers", covers);
		return SUCCESS;
	}
}
