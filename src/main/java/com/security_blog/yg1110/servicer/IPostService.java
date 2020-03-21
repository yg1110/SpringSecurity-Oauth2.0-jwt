package com.security_blog.yg1110.servicer;

import java.util.List;

import com.security_blog.yg1110.domain.FileInfo;
import com.security_blog.yg1110.domain.Post;

public interface IPostService {
	public int PostData_Insert(Post post);
	public void Crawling_PostData_Insert(Post post);
	public void PostFile_Insert(FileInfo fileInfo);
	public List<Post> postlist();
	public Post post(int post_id);
	public FileInfo postfile(int post_id);
}