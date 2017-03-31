package com.niit.colloboration.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.colloboration.model.BlogComment;
import com.niit.collobration.DAO.BlogCommentDAO;

@RestController
public class BlogCommentController {
	@Autowired
	private BlogCommentDAO blogcommentDAO;
	@Autowired
	private BlogComment blogcomment;
	
	@RequestMapping(value = "/bcomment/{blogid}/{bcomment}" , method = RequestMethod.POST)
	public ResponseEntity<BlogComment> createBlogComment(@RequestBody BlogComment blogcomment,@PathVariable("blogid") int blogid,@PathVariable("bcomment") String bcomment, HttpSession httpsession) {
		
   		String loggedInuserID = (String) httpsession.getAttribute("loggedInUserID");
	
		blogcomment.setUser_id(loggedInuserID);
		blogcomment.setBcomment_Datetime(null);
		blogcomment.setBlog_id(blogid);
	blogcomment.setBcomment(bcomment);
		
		blogcommentDAO.save(blogcomment);
		
		return new ResponseEntity<BlogComment>(blogcomment, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blogcomments/{id}" , method = RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> getBlogComment(@PathVariable("id") int id){
		System.out.println("list of comments ");
		List<BlogComment> blogcomments = blogcommentDAO.list(id);
		if(blogcomments == null)
		{
			blogcomment = new BlogComment();
			blogcomment.setErrorCode("404");
			blogcomment.setErrorMessage("Blog comments for blog id "+ id);
		}
		
		return new ResponseEntity<List<BlogComment>>(blogcomments, HttpStatus.OK);
	}
	
	

}
