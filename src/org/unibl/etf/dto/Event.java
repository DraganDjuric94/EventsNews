package org.unibl.etf.dto;

import java.sql.Timestamp;

public class Event {
	
	private Integer id;
	private String name;
	private Timestamp dateTime;
	private String description;
	private String image;
	private Category category;
	
	public Event(Integer id, String name, Timestamp dateTime, String description, String image, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.dateTime = dateTime;
		this.description = description;
		this.image = image;
		this.category = category;
	}

	public Event() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
