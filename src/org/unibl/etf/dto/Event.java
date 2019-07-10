package org.unibl.etf.dto;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Date dateTime;
	private String description;
	private String image;
	private Category category;
	
	public Event(Integer id, String name, Date dateTime, String description, String image, Category category) {
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", dateTime=" + dateTime + ", description=" + description
				+ ", image=" + image + ", category=" + category + "]";
	}
	
	
	
}
