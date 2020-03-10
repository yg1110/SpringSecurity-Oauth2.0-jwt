package com.security_blog.yg1110.servicer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security_blog.yg1110.domain.Post;
import com.security_blog.yg1110.mapper.PostMapper;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostMapper postMapper;

	@Override
	public void postwrite(Post post) {
		postMapper.postwrite(post);
	}

	@Override
	public List<Post> postlist() {
		return postMapper.postlist();
	}

	@Override
	public Post post(int post_id) {
		return postMapper.post(post_id);
	}
	
}