package org.unibl.etf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.unibl.etf.dto.Event;
import org.unibl.etf.dto.News;

@ManagedBean
@SessionScoped
public class NewsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private News news = new News();

	public News getNews() {
		return news;
	}
	
	public void resetNews() {
		news = new News();
	}
}
