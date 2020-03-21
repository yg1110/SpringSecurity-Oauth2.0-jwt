package com.security_blog.yg1110.servicer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security_blog.yg1110.domain.FileInfo;
import com.security_blog.yg1110.domain.Post;
import com.security_blog.yg1110.mapper.PostMapper;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostMapper postMapper;

	@Override
	public int PostData_Insert(Post post) {
		return postMapper.PostData_Insert(post);
	}

	@Override
	public void Crawling_PostData_Insert(Post post) {
		postMapper.Crawling_PostData_Insert(post);
	}

	@Override
	public void PostFile_Insert(FileInfo fileInfo) {
		postMapper.PostFile_Insert(fileInfo);
	}

	@Override
	public List<Post> postlist() {
		return postMapper.postlist();
	}

	@Override
	public Post post(int post_id) {
		return postMapper.post(post_id);
	}
	
	@Override
	public FileInfo postfile(int post_id) {
		return postMapper.postfile(post_id);
	}
}