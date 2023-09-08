package com.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.ClientSessionOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.connection.ClusterDescription;

import java.util.List;
import java.io.Closeable;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.conversions.Bson;

public class Util {
	
	private static MongoClient getConnection() {
        int port_no = 27017;
        String url = "localhost";
 
        MongoClient mongoClntObj = new MongoClient() {
			
			@Override
			public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> pipeline,
					Class<TResult> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ChangeStreamIterable<Document> watch(ClientSession clientSession, List<? extends Bson> pipeline) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> pipeline, Class<TResult> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ChangeStreamIterable<Document> watch(ClientSession clientSession) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ChangeStreamIterable<Document> watch(List<? extends Bson> pipeline) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ChangeStreamIterable<Document> watch() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ClientSession startSession(ClientSessionOptions options) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ClientSession startSession() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <TResult> ListDatabasesIterable<TResult> listDatabases(ClientSession clientSession,
					Class<TResult> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <TResult> ListDatabasesIterable<TResult> listDatabases(Class<TResult> resultClass) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListDatabasesIterable<Document> listDatabases(ClientSession clientSession) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListDatabasesIterable<Document> listDatabases() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MongoIterable<String> listDatabaseNames(ClientSession clientSession) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MongoIterable<String> listDatabaseNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MongoDatabase getDatabase(String databaseName) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ClusterDescription getClusterDescription() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
		
        return mongoClntObj;
    }
 
	 public static boolean searchUserInDb(String loginId, String loginPwd) {
	        boolean user_found = false;
	        String db_name = "mymovieplan",
	                db_collection_name = "admindata";
	 

	        MongoDatabase db = getConnection().getDatabase(db_name);
	 

	        MongoCollection col = db.getCollection(db_collection_name);
	 
	          
	        List obj = new ArrayList();
	        obj.add(new BasicDBObject("adminemail", loginId));
	        obj.add(new BasicDBObject("adminpass", loginPwd));
	 
	        
	        BasicDBObject whereQuery = new BasicDBObject();
	        whereQuery.put("$and", obj);
	        System.out.println("Sql query is?= " + whereQuery.toString());
	 
	        FindIterable cursor = col.find(whereQuery);
	        for(Document doc : cursor) {
	            System.out.println("Found?= " + doc);
	            user_found = true;
	        }
	        return user_found;
	    }
	}

	
	
	
}
	

