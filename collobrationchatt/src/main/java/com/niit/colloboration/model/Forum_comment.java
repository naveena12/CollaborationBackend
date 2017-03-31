package com.niit.colloboration.model;

public class Forum_comment {
	private  String forum_comment_id;
	private String  forum_id;
	private  String forum_name;
	private String  user_id;
	private  String message;
	public String getForum_comment_id() {
		return forum_comment_id;
	}
	public void setForum_comment_id(String forum_comment_id) {
		this.forum_comment_id = forum_comment_id;
	}
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_name() {
		return forum_name;
	}
	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
