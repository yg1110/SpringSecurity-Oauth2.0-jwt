package com.security_blog.yg1110.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.security_blog.yg1110.domain.Post;

@Mapper
public interface PostMapper {
	public void postwrite(Post post);
	public List<Post> postlist();
	public Post post(int post_id);
}