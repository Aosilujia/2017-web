package service.impl;

import java.util.List;

import dao.UserInfoDao;
import model.UserInfo;
import service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService{
	private UserInfoDao userinfoDao;
	
	public void setUserinfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	
	@Override
	public Integer addUserInfo(UserInfo userinfo) {
		return userinfoDao.save(userinfo);
	}

	@Override
	public void deleteUserInfo(UserInfo userinfo) {
		userinfoDao.delete(userinfo);
		
	}

	@Override
	public void updateUserInfo(UserInfo userinfo) {
		userinfoDao.update(userinfo);
		
	}

	@Override
	public UserInfo getUserInfoById(int id) {
		return userinfoDao.getUserInfoById(id);
	}

	@Override
	public List<UserInfo> getAllUserInfos() {
		return userinfoDao.getAllUserInfos();
	}


}
