package dao;

import java.util.List;

import model.UserInfo;

public interface UserInfoDao {

	public Integer save(UserInfo userinfo);

	public void delete(UserInfo userinfo);

	public void update(UserInfo userinfo);

	public UserInfo getUserInfoById(int id);

	public List<UserInfo> getAllUserInfos();
	
}