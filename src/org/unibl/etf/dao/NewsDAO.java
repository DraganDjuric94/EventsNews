package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.unibl.etf.dto.Event;
import org.unibl.etf.dto.News;

public class NewsDAO {
	
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static String SQL_SELECT_NEWS_BY_NAME = "SELECT * FROM news WHERE name=?";
	private static String SQL_SELECT_NEWS_BY_ID = "SELECT * FROM news WHERE id=?";
	private static String SQL_SELECT_ALL_NEWS = "SELECT * FROM news";
	private static String SQL_INSERT_NEWS = "INSERT INTO news (date_created, title, text) VALUES (?, ?, ?)";
	
	private static NewsDAO instance = null;
	
	private NewsDAO() {}
	
	public static NewsDAO getInstance() {
		if (instance == null) {
			instance = new NewsDAO();
		}
		
		return instance;
	}
	
	public boolean createNews(News news) {
		boolean created = false;
		
		Connection connection = null;
		
		Date createdDate = new Date(new java.util.Date().getTime());
		
		Object values[] = { createdDate, news.getTitle(), news.getText() };
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_INSERT_NEWS, true, values);
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows == 0)
				created = false;
			else
				created = true;
			
			preparedStatement.close();
		} catch (SQLException e) {
			created = false;
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return created;
	}
	
	public static boolean isDataValid(News news) {
		boolean validData = false;
		
		validData = (news.getTitle() != null && news.getTitle().length() <= 100
				&& news.getText() != null && news.getText().length() <= 2000);
		
		return validData;
	}

}
