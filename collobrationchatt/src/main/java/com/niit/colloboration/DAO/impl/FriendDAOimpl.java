package com.niit.colloboration.DAO.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloboration.model.Friend;
import com.niit.colloboration.model.User;
import com.niit.collobration.DAO.FriendDAO;
import com.niit.collobration.DAO.UserDAO;
@Repository("friendDAO")
public class FriendDAOimpl implements FriendDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserDAO userDAO;
	public FriendDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
   @Transactional
	@Override
	public boolean save(Friend friend) {
	   try {
		sessionFactory.getCurrentSession().save(friend);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		return false;
	}
   @Transactional
	@Override
	public boolean update(Friend friend) {
	   try {
		sessionFactory.getCurrentSession().update(friend);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// TODO Auto-generated method stub
		return false;
	}
  /* @Transactional
	@Override
	public boolean delete(String id) {
	   Friend friend=get(id);
		sessionFactory.getCurrentSession().delete(friend);
	
		return true;
	}
		*/// TODO Auto-generated method stub
	
	
   @Transactional
	@Override
	public Friend get(String uid,String fid) {
	   String s="from Friend where user_id='"+uid+"' and friend_id='"+fid+"'";
	   List<Friend> friends=sessionFactory.getCurrentSession().createQuery(s).list();
		return friends.get(0);
	}
		// TODO Auto-generated method stub
		
	
   @Transactional
	@Override
	public List<Friend> list() {
	   String q="from Friend";
		List<Friend> li=sessionFactory.getCurrentSession().createQuery(q).list();
		if(li.isEmpty()||li==null)
			return null;
		else
		return li;
		// TODO Auto-generated method stub

	}
   @Transactional
@Override
public List<Friend> listNewFriendRequests(String userId) {
	Session session=sessionFactory.getCurrentSession();
	//User user=userDAO.get(userId);
	List<Friend> friends=session.createQuery("from Friend where friend_id='"+userId+"' and status='N'").getResultList();
	// TODO Auto-generated method stub
	return friends;
}
   @Transactional
@Override
public List<Friend> listmyfriends(String userId) {
	Session session=sessionFactory.getCurrentSession();
	//User user=userDAO.get(userId);
	List<Friend> friends=session.createQuery("from Friend where user_id='"+userId+"' and status='A'").getResultList();
	// TODO Auto-generated method stub
	return friends;
	// TODO Auto-generated method stub
	
}

	

}
