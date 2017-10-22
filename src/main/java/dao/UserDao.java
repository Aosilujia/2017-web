package dao;

import java.util.List;

import model.User;

public interface UserDao {

	public Integer save(User user);

	public void delete(User user);

	public void update(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();

	public List<User> findByNameAndPass(User user);
	
	public boolean checkUsername(User user);
}