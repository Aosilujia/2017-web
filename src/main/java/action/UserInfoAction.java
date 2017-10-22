package action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.UserInfo;
import service.UserInfoService;

public class UserInfoAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private int id;
	private String nickname;
	private String area;
	private String email;
	private int sex;
	private Date birthday;
	
	private UserInfoService userinfoService;
	
	public void setUserinfoService(UserInfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getSex() {
		return sex;
	}
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String execute() throws Exception {
		List<UserInfo> users = userinfoService.getAllUserInfos();
		request().setAttribute("userinfo", users);

		return SUCCESS;
	}
	
	public String getInfobyId()throws Exception{
		HttpSession session=session();
		int uid=0;
		if (session.getAttribute("uid") != null) {
			uid=(int)session.getAttribute("uid");
		}
		UserInfo info=userinfoService.getUserInfoById(uid);

		session.setAttribute("info", info);
		session.setAttribute("id", id);
		return SUCCESS;
	}
	
	
}
