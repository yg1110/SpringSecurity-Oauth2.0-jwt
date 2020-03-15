package com.security_blog.yg1110.servicer;

import java.util.List;

import com.security_blog.yg1110.domain.Post;

public interface IPostService {
	public void postwrite(Post post);
	public List<Post> postlist();
	public Post post(int post_id);
}