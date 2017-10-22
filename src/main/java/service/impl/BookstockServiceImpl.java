package service.impl;

import java.util.List;


import model.Bookstock;
import service.BookstockService;
import dao.BookstockDao;

public class BookstockServiceImpl implements BookstockService{
	private BookstockDao bookstockDao;
	
	public void setBookstockDao(BookstockDao bookstockDao){
		this.bookstockDao = bookstockDao;
	}

	/**
	 * bookstock
	 * 
	 */
	public Integer addBookstock(Bookstock bookstock) {
		return bookstockDao.save(bookstock);
	}

	public void deleteBookstock(Bookstock bookstock) {
		bookstockDao.delete(bookstock);
	}

	public void updateBookstock(Bookstock bookstock) {
		bookstockDao.update(bookstock);
	}

	public Bookstock getBookstockById(int id) {
		return bookstockDao.getBookstockById(id);
	}

	public List<Bookstock> getAllBookstocks() {
		return bookstockDao.getAllBookstocks();
	}

	
}
