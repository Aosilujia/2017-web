package dao.impl;

import java.util.List;

import model.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LoginDao;

public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {

	@Override
	public List<User> findByNameAndPass(User user) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getHibernateTemplate().find(
				"from User as u where u.username=? and u.password=?",user.getUsername(),user.getPassword());
		return users;
	}

}
