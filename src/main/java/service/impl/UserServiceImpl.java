package service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import dao.LoginDao;
import dao.UserDao;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private LoginDao loginDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void setLoginDao(LoginDao loginDao){
		this.loginDao=loginDao;
	}
	/**
	 * user
	 * 
	 */
	public Integer addUser(User user) {
		return userDao.save(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public User checkUser(User user){
        List<User> users= (loginDao.findByNameAndPass(user));
		User theuser = users.size() > 0 ? users.get(0) : null;
		return theuser;
	}

	@Override
	public boolean checkUsername(User user) {
		return userDao.checkUsername(user);
	} 
}
