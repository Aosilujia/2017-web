package dao;  
  
import java.util.ArrayList;  
  
import com.mongodb.DB;  
import com.mongodb.DBCollection;  
import com.mongodb.DBObject;  
  

public interface MongoDao {  

	public void delete(int id);

	public void save(int id, String img) throws Exception ;
	
	public String getImgbyId(int id) throws Exception;
      
}  