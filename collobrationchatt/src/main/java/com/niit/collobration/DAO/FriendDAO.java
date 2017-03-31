package com.niit.collobration.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.colloboration.model.Friend;
@Repository("friendDAO")
public interface FriendDAO {
	public boolean save(Friend friend);
	public boolean update(Friend friend);
	//public boolean delete(String id);
	public Friend get(String uid,String fid);
	public List<Friend> list();
	public List<Friend> listNewFriendRequests(String userId);
	public List<Friend> listmyfriends(String userId);
	
	

}
