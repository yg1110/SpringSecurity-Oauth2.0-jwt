package com.security_blog.yg1110.servicer;

import java.util.List;

import com.security_blog.yg1110.domain.Post;

public interface IPostService {
	void postwrite(Post post);
	List<Post> postlist();
	Post post(int post_id);
}