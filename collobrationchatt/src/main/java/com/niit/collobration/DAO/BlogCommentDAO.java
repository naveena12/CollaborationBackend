package com.niit.collobration.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.colloboration.model.BlogComment;


@Repository("blogcommentDAO")
public interface BlogCommentDAO  {
	
	public boolean save(BlogComment blogcomment);
	public boolean update(BlogComment blogcomment);
	public void delete(int id);
	public BlogComment get(int blogid);
	public List<BlogComment> list(int id);

	

}
