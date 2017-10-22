package action;

import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.User;
import service.UserService;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private UserService appService;

	public void setUserService(UserService userService) {
		this.appService = userService;
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

	
	@Override
	public String execute() throws Exception{
		
		String result="false";
		User user=new User(username,password,"user");
		User theuser=appService.checkUser(user);
		if (theuser!=null){
			String role=theuser.getRole();
			HttpSession httpSession=session();
			httpSession.setMaxInactiveInterval(1800);
			httpSession.setAttribute("uid", theuser.getId());
			httpSession.setAttribute("users", username);
			httpSession.setAttribute(role, true);
			result="true";
			ServletActionContext.getResponse().getWriter().print(result);
			return null;}
		
		else {
			result="false";
			ServletActionContext.getResponse().getWriter().print(result);
			return null;}
	}
}