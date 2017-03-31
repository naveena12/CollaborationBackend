package com.niit.colloboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Blog extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blog_id;
	private String blog_title;
	private Date blog_Datetime;
	private String description;
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public Date getBlog_Datetime() {
		return blog_Datetime;
	}
	public void setBlog_Datetime(Date blog_Datetime) {
		if(blog_Datetime==null)
		this.blog_Datetime = new Date(System.currentTimeMillis());
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
