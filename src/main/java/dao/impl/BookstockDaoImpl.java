package dao.impl;

import java.util.List;

import model.Bookstock;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BookstockDao;

public class BookstockDaoImpl extends HibernateDaoSupport implements BookstockDao {

	public Integer save(Bookstock bookstock) {
		return (Integer) getHibernateTemplate().save(bookstock);
	}

	public void delete(Bookstock bookstock) {
		getHibernateTemplate().delete(bookstock);
	}

	public void update(Bookstock bookstock) {
		getHibernateTemplate().merge(bookstock);
	}

	public Bookstock getBookstockById(int id) {
		@SuppressWarnings("unchecked")
		List<Bookstock> bookstocks = (List<Bookstock>) getHibernateTemplate().find(
				"from Bookstock as b where b.id=?", id);
		Bookstock bookstock = bookstocks.size() > 0 ? bookstocks.get(0) : null;
		return bookstock;
	}

	public List<Bookstock> getAllBookstocks() {
		@SuppressWarnings("unchecked")
		List<Bookstock> bookstocks = (List<Bookstock>) getHibernateTemplate()
				.find("from Bookstock");
		return bookstocks;
	}

}
