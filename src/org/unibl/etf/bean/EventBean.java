package org.unibl.etf.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.unibl.etf.dao.CategoryDAO;
import org.unibl.etf.dto.Category;
import org.unibl.etf.dto.Event;

@ManagedBean
@SessionScoped
public class EventBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Category> categories = null;
	private Event event = new Event();
	
	public List<Category> getCategories() {
		if (categories == null) {
			categories = CategoryDAO.getInstance().readAllCategories();
		}
		
		return categories;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void resetEvent() {
		event = new Event();
	}
	
}
