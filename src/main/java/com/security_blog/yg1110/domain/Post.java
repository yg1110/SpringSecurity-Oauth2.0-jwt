package com.security_blog.yg1110.domain;

public class Post {
	private int post_id;
	private String title;
	private String content;
	private String date;
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
}
