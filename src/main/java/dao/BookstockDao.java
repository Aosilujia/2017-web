package dao;

import java.util.List;

import model.Bookstock;

public interface BookstockDao {

	public Integer save(Bookstock bookstock);

	public void delete(Bookstock bookstock);

	public void update(Bookstock bookstock);

	public Bookstock getBookstockById(int id);

	public List<Bookstock> getAllBookstocks();

}