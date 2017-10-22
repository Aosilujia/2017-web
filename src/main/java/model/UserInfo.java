package model;

import java.sql.Date;

public class UserInfo {

	private int id;
	private String nickname;
	private String email;
	private String area;
	private int sex;
	private Date birthday;

	public UserInfo() {
	}

	public UserInfo(String nickname, String email, String area, int sex, Date birthday) {
		this.nickname=nickname;
		this.email=email;
		this.area=area;
		this.sex=sex;
		this.birthday=birthday;
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
		this.nickname=nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea(){
		return area;
	}
	
	public void setArea(String area){
		this.area=area;
	}
	public int getSex(){
		return sex;
	}
	
	public void setSex(int sex){
		this.sex=sex;
	}
	
	public Date getBirthday(){
		return birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
}
