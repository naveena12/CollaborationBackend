package com.niit.colloboration.DAO.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloboration.model.Blog;
import com.niit.colloboration.model.BlogComment;

import com.niit.collobration.DAO.BlogCommentDAO;

@Repository("blogCommentDAO")
public class BlogCommentDAOimpl implements BlogCommentDAO {
	
	@Autowired (required=true)
	private SessionFactory sessionFactory;
	public BlogCommentDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
	
	
    @Transactional
	public boolean save(BlogComment blogcomment) {
    	try {
			sessionFactory.getCurrentSession().save(blogcomment);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
   @Transactional
	public boolean update(BlogComment blogcomment) {
	   try {
		sessionFactory.getCurrentSession().update(blogcomment);
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		return false;
	}
    @Transactional
	public void delete(int id) {
    	try {
    		BlogComment blogComment=get(id);
			sessionFactory.getCurrentSession().delete(blogComment);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
    @Transactional
	public BlogComment get(int id) {
    	String hql="from BlogComment where id="+"'"+id+"'";;
 		 @SuppressWarnings({ "rawtypes", "deprecation" })
			Query query= sessionFactory.getCurrentSession().createQuery(hql);
 		 @SuppressWarnings("deprecation")
			List<BlogComment> li=(List<BlogComment>)query.list();
 		 if(li==null||li.isEmpty())
 			 return null;
 		 else
 			 return li.get(0);
		
		// TODO Auto-generated method stub
		
	}
    @Transactional
	public List<BlogComment> list(int id) {
		@SuppressWarnings("unchecked")
		String s="from BlogComment where blog_id="+id;
		  List<BlogComment> li=sessionFactory.getCurrentSession().createQuery(s).list();
			return li;
		// TODO Auto-generated method stub

	}
	

}
