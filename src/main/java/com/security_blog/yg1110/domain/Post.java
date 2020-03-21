package com.security_blog.yg1110.domain;

public class Post {
	private int post_id;
	private String username;
	private String title;
	private String content;
	private String date;
	private String thumbnail;
	private String excerpt;

	
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", username=" + username + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", thumbnail=" + thumbnail + ", excerpt=" + excerpt + "]";
	}
	public Post(String username, String title, String content, String date, String thumbnail, String excerpt) {
		super();
		this.username = username;
		this.title = title;
		this.content = content;
		this.date = date;
		this.thumbnail = thumbnail;
		this.excerpt = excerpt;
	}
	
}
