package com.niit.colloboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.colloboration.model.Friend;
import com.niit.colloboration.model.User;
import com.niit.collobration.DAO.FriendDAO;

@RestController
public class FriendController {

    @Autowired
    FriendDAO friendDAO;

    @Autowired
    Friend friend;

   /* @RequestMapping(value="/myFriend",method = RequestMethod.GET)
public ResponseEntity<List<Friend>> getMyFriend(HttpSession session) {

            User loggedInUser = (User) session.getAttribute("loggedInUser");
            List<Friend> myFriend = friendDAO.get(loggedInUser.getUser_id());
            return new ResponseEntity<List<Friend>>(myFriend, HttpStatus.OK);
    }*/

    @RequestMapping(value="/addFriend/{friendID}", method = RequestMethod.POST)
    public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendID") String friendID,HttpSession session) {

            User loggedInUser=(User) session.getAttribute("loggedInUser");
            friend.setUser_id(loggedInUser.getUser_id());
            friend.setFriend_id(friendID);
            friend.setStatus("N");
            friend.setIsonline('Y');
            friendDAO.save(friend);
            return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }

    @RequestMapping(value="/unFriend/{friendID}", method = RequestMethod.GET)
    public ResponseEntity<Friend> unFriend(@PathVariable("friendID") String friendID, HttpSession session) {

            User loggedInUser = (User) session.getAttribute("loggedInUser");
            friend.setUser_id(loggedInUser.getUser_id());
            friend.setFriend_id(friendID);
            friend.setStatus("U");//N -> New , R-> Rejected , A -> Accepted
            friendDAO.save(friend);
            return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }

    @RequestMapping(value="/rejectFriend/{friendID}", method = RequestMethod.PUT)
    public ResponseEntity<Friend> rejectFriendFriendRequest(@PathVariable("friendID") String friendID, HttpSession session){

            User loggedInUser = (User) session.getAttribute("loggedInUser");
            
            friend=friendDAO.get(friendID, loggedInUser.getUser_id());
            friend.setStatus("R");
            friendDAO.update(friend);
            return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }

   /* @RequestMapping(value="/getMyFriendRequests1",method = RequestMethod.GET)
    public ResponseEntity<Friend> getMyFriendRequests1(HttpSession session) {

            User loggedInUser = (User) session.getAttribute("loggedInUser");
            friendDAO.get(loggedInUser.getUser_id());
            return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }*/

    @RequestMapping(value="/acceptFriend/{friendID}", method = RequestMethod.PUT)
    public ResponseEntity<Friend> acceptFriendRequest(@PathVariable("friendID") String friendID, HttpSession session) {

            User loggedInUser = (User) session.getAttribute("loggedInUser");
           /* friend.setFriend_id(loggedInUser.getUser_id());
            friend.setUser_id(friendID);*/
            friend=friendDAO.get(friendID, loggedInUser.getUser_id());
            friend.setStatus("A");
            friendDAO.update(friend);
            return new ResponseEntity<Friend>(friend, HttpStatus.OK);
    }

    //Just for testing purpose from restclient.
   /* @RequestMapping(value="/myFriends/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Friend>> getMyFriendsTemp(@PathVariable("id") String id) {

            List<Friend> myFriend = friendDAO.get(id);
            return new ResponseEntity<List<Friend>>(myFriend, HttpStatus.OK);
    }*/

@RequestMapping(value="/getMyFriendRequests/",method=RequestMethod.GET)
public ResponseEntity<List<Friend>> getMyFriendRequests(HttpSession session)
{
	System.out.println("getting new friend requests from DB");
	User user=(User) session.getAttribute("loggedInUser");
	System.out.println("Logged in user id "+user.getUser_id());
	List<Friend> myFriendRequests = friendDAO.listNewFriendRequests(user.getUser_id());
	return new ResponseEntity<List<Friend>>(myFriendRequests,HttpStatus.OK);
}


@RequestMapping(value="/myFriends/",method=RequestMethod.GET)
public ResponseEntity<List<Friend>> myFriends(HttpSession session)
{
	System.out.println("getting accepted friends from DB");
	User user=(User) session.getAttribute("loggedInUser");
	System.out.println("Logged in user id "+user.getUser_id());
	List<Friend> myFriends = friendDAO.listmyfriends(user.getUser_id());
	return new ResponseEntity<List<Friend>>(myFriends,HttpStatus.OK);
}


}
