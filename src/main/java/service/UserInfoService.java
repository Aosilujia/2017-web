package service;

import java.util.List;

import model.UserInfo;

public interface UserInfoService {
	public Integer addUserInfo(UserInfo userinfo);

	public void deleteUserInfo(UserInfo userinfo);

	public void updateUserInfo(UserInfo userinfo);

	public UserInfo getUserInfoById(int id);

	public List<UserInfo> getAllUserInfos();

}
