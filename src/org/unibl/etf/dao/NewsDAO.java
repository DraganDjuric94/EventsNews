package org.unibl.etf.dao;

public class NewsDAO {
	
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static String SQL_SELECT_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name=?";
	private static String SQL_SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
	private static String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM category";
	
	private static NewsDAO instance = null;
	
	private NewsDAO() {}
	
	public static NewsDAO getInstance() {
		if (instance == null) {
			instance = new NewsDAO();
		}
		
		return instance;
	}

}
