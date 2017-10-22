package dao;

import java.util.List;

import model.User;

public interface LoginDao {
	public List<User> findByNameAndPass(User user);
}
