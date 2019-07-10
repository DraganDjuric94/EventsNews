package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.unibl.etf.dto.Category;

public class CategoryDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static String SQL_SELECT_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name=?";
	private static String SQL_SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";
	private static String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM category";
	
	private static CategoryDAO instance = null;
	
	private CategoryDAO() {}
	
	public static CategoryDAO getInstance() {
		if (instance == null) {
			instance = new CategoryDAO();
		}
		
		return instance;
	}
	
	public Category readCategoryById(Integer id) {
		Category foundCategory = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object values[] = {id};
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_CATEGORY_BY_ID, false, values);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				foundCategory = new Category(resultSet.getInt("id"), resultSet.getString("name"));
			}
			
			preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}

		return foundCategory;
	}
	
	public Category readCategoryByName(String name) {
		Category foundCategory = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object values[] = {name};
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_CATEGORY_BY_NAME, false, values);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				foundCategory = new Category(resultSet.getInt("id"), resultSet.getString("name"));
			}
			
			preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}

		return foundCategory;
	}
	
	public List<Category> readAllCategories() {
		List<Category> allCategories = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_CATEGORIES);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.isBeforeFirst()) {    
			    allCategories = new ArrayList<>();
			    
			    while (resultSet.next()) {
					allCategories.add(new Category(resultSet.getInt("id"), resultSet.getString("name")));
				}
			}
			
			preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return allCategories;
	}
	
	public static boolean isDataValid(Category category) {
		return getInstance().readAllCategories().contains(category);
	}
	
}
