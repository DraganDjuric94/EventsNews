package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.unibl.etf.dto.Event;

public class EventDAO {
	
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String IMAGE_REGEX = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|jpeg|gif|png)";
	
	private static String SQL_SELECT_EVENT_BY_NAME = "SELECT * FROM event WHERE name=?";
	private static String SQL_SELECT_EVENT_BY_ID = "SELECT * FROM event WHERE id=?";
	private static String SQL_SELECT_ALL_EVENTS = "SELECT * FROM event";
	private static String SQL_INSERT_EVENT = "INSERT INTO event (name, date_time, description, image, category_id) VALUES (?, ?, ?, ?, ?)";
	
	private static EventDAO instance = null;
	
	private EventDAO() {}
	
	public static EventDAO getInstance() {
		if (instance == null) {
			instance = new EventDAO();
		}
		
		return instance;
	}
	
	public boolean createEvent(Event event) {
		boolean created = false;
		
		Connection connection = null;
		
		Timestamp eventDateTime = new Timestamp(event.getDateTime().getTime());
		
		Object values[] = { event.getName(), eventDateTime, event.getDescription(), event.getImage(), event.getCategory().getId() };
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_INSERT_EVENT, true, values);
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
	
	public static boolean isDataValid(Event event) {
		boolean validData = false;
		
		validData = (event.getName() != null && event.getName().length() <= 45
				&& CategoryDAO.isDataValid(event.getCategory()) 
				&& event.getDateTime() != null && event.getDateTime().compareTo(new Date()) > 0
				&& event.getDescription() != null && event.getDescription().length() <= 500
				&& event.getImage() != null && event.getImage().length() <= 500 && event.getImage().matches(IMAGE_REGEX));
		
		return validData;
	}
}
