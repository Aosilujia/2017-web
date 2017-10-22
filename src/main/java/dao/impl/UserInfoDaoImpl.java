package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserInfoDao;
import model.UserInfo;

class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDao  {

	@Override
	public Integer save(UserInfo userinfo) {
		return (Integer) getHibernateTemplate().save(userinfo);
	}

	@Override
	public void delete(UserInfo userinfo) {
		getHibernateTemplate().delete(userinfo);
		
	}

	@Override
	public void update(UserInfo userinfo) {
		getHibernateTemplate().merge(userinfo);
		
	}

	@Override
	public UserInfo getUserInfoById(int id) {
		@SuppressWarnings("unchecked")
		List<UserInfo> users = (List<UserInfo>) getHibernateTemplate().find(
				"from UserInfo as u where u.id=?", id);
		UserInfo user = users.size() > 0 ? users.get(0) : null;
		return user;
	}

	@Override
	public List<UserInfo> getAllUserInfos() {
		@SuppressWarnings("unchecked")
		List<UserInfo> users = (List<UserInfo>) getHibernateTemplate()
				.find("from UserInfo");
		return users;
	}
}
