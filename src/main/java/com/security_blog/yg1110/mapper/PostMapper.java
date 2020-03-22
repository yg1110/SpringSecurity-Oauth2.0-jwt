package com.security_blog.yg1110.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.security_blog.yg1110.domain.FileInfo;
import com.security_blog.yg1110.domain.Post;

@Mapper
public interface PostMapper {
	public int PostData_Insert(Post post);
	public void Crawling_PostData_Insert(Post post);
	public void PostFile_Insert(FileInfo fileInfo);
	public List<Post> postlist();
	public Post post(int post_id);
	public FileInfo postfile(int post_id);
	public FileInfo postfiledown(String fileName);

}