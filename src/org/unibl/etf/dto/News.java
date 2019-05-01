package org.unibl.etf.dto;

import java.sql.Date;

public class News {
	
	private Integer id;
	private Date dateCreated;
	private String title;
	private String text;
	
	public News(Integer id, Date dateCreated, String title, String text) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.title = title;
		this.text = text;
	}

	public News() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
