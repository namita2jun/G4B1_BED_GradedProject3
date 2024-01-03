package com.greatlearning.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Tickets {
	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   private String title;
   
   private String shortDescription;
   
   @DateTimeFormat(pattern="dd/mm/yyyy")
   private Date createdOn;
   
   private String content;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getShortDescription() {
	return shortDescription;
}

public void setShortDescription(String shortDescription) {
	this.shortDescription = shortDescription;
}

public Date getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public Tickets(int id, String title, String shortDescription, Date createdOn, String content) {
	super();
	this.id = id;
	this.title = title;
	this.shortDescription = shortDescription;
	this.createdOn = createdOn;
	this.content = content;
}

@Override
public String toString() {
	return "Tickets [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", createdOn="
			+ createdOn + ", content=" + content + "]";
}
}
