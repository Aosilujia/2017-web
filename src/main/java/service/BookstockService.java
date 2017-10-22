package service;

import java.util.List;
import model.Bookstock;

public interface BookstockService {
	/**
	 * bookstock
	 * 
	 */
	public Integer addBookstock(Bookstock bookstock);

	public void deleteBookstock(Bookstock bookstock);

	public void updateBookstock(Bookstock bookstock);

	public Bookstock getBookstockById(int id);

	public List<Bookstock> getAllBookstocks();

	
}
