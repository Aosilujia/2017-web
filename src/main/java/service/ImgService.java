package service;

import org.hibernate.event.SaveOrUpdateEvent;

public interface ImgService {
	public String getImgbyId(int id);
	
	public void save(int id,String img);
	
	public void delete(int id);
}
