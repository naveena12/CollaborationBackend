package com.niit.colloboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class BlogComment extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bcomment_id;
	private int blog_id;
	private Date  bcomment_Datetime;
	private String bcomment;
	private String user_id;
	public int getBcomment_id() {
		return bcomment_id;
	}
	public void setBcomment_id(int bcomment_id) {
		this.bcomment_id = bcomment_id;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public  Date getBcomment_Datetime() {
		return bcomment_Datetime;
	}
	public void setBcomment_Datetime(Date bcomment_Datetime) {
		if(bcomment_Datetime==null)
		this.bcomment_Datetime = new Date(System.currentTimeMillis());
	}
	public String getBcomment() {
		return bcomment;
	}
	public void setBcomment(String bcomment) {
		this.bcomment = bcomment;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	

}
