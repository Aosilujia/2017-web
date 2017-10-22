package action;

import service.UserService;

import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import model.User;

public class RegisterAction extends BaseAction{
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
	public String execute() throws Exception{
		String result="false";
		User user=new User(username,password,"user");
		if (userService.checkUsername(user)){
			userService.addUser(user);
			result="success";
			ServletActionContext.getResponse().getWriter().print(result);
			return null;
		}
		else{
			ServletActionContext.getResponse().getWriter().print(result);
			return null;
		}
	}
}
