package action;

import java.util.List;

import model.User;
import service.UserService;

public class AllUsersAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String role;

	private UserService userService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {

		List<User> users = userService.getAllUsers();
		request().setAttribute("users", users);

		return SUCCESS;
	}
	
	public String add() throws Exception {

		User user = new User(username, password, role);
		userService.addUser(user);

		return SUCCESS;
	}
	
	public String update() throws Exception {

		User user = userService.getUserById(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		userService.updateUser(user);

		return SUCCESS;
	}
	
	public String delete() throws Exception {

		User user = userService.getUserById(id);
		userService.deleteUser(user);

		return SUCCESS;
	}
}
