package service.impl;

import dao.MongoDao;
import service.ImgService;

public class ImgServiceImpl implements ImgService{
	private MongoDao mongoDao;
	
	public void setMongoDao(MongoDao mongoDao) {
		this.mongoDao = mongoDao;
	}
	@Override
	public String getImgbyId(int id) {
		try {
			return mongoDao.getImgbyId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(int id, String img) {
		try {
			mongoDao.save(id, img);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		mongoDao.delete(id);
	}

}
