package dao.impl;  
  
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


import dao.MongoDao;

import com.mongodb.BasicDBObject;  
import com.mongodb.DB;  
import com.mongodb.DBObject;  
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

import org.apache.commons.io.IOUtils;

public class MongoDaoImpl implements MongoDao{  
	
    private final static String HOST = "localhost";// 端口  
    private final static int PORT = 27017;// 端口  
    private final static int POOLSIZE = 100;// 连接数量  
    private final static int BLOCKSIZE = 100; // 等待队列长度  
    /** 
     * MongoClient的实例代表数据库连接池，是线程安全的，可以被多线程共享，客户端在多线程条件下仅维持一个实例即可 
     * Mongo是非线程安全的，目前mongodb API中已经建议用MongoClient替代Mongo 
     */  
    
	private MongoClient mongoClient;
	private GridFS gridFS;

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	private DB connetdb() {
		System.out.println("connecting...");
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB mongoDatabase = mongoClient.getDB("imgs");
		System.out.println("Connect to imgs successfully");
		return mongoDatabase;
	}

	public void delete(int id){
		DB database = connetdb();
		gridFS = new GridFS(database);
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		if (gridFSDBFile!=null){
			gridFS.remove(query);
		}
	}
	
	
	public void save(int id, String img) throws Exception {
		DB database = connetdb();
		gridFS = new GridFS(database);
		InputStream is = new ByteArrayInputStream(img.getBytes("UTF-8"));
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		if (gridFSDBFile!=null){
			gridFS.remove(query);
		}
		GridFSInputFile gridFSInputFile = gridFS.createFile(is);
		gridFSInputFile.setId(id);
		//gridFSInputFile.setFilename(fileName);
		// gridFSInputFile.setChunkSize();
		// gridFSInputFile.setContentType();
		// gridFSInputFile.setMetaData();
		gridFSInputFile.save();
	}

	@Override
	public String getImgbyId(int id) throws Exception {
		DB database = connetdb();
		gridFS = new GridFS(database);
		DBObject query = new BasicDBObject("_id", id);
		GridFSDBFile gridFSDBFile = gridFS.findOne(query);
		InputStream is = gridFSDBFile.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		String img=new String(bytes,"utf-8");
		//String plan = java.util.Base64.getEncoder().encodeToString(bytes);
		return img;
	}
      
}  
