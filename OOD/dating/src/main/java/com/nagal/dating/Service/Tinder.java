package com.nagal.dating.Service;

import com.nagal.dating.model.Gender;
import com.nagal.dating.model.User;

import java.util.*;

public class Tinder {

	private List<User> users;
	private Map< String, Set<String>> LikeMap;
	private Map<String,User> nameUserMapping;
	private Map< String, Set <String>> matches;

	public Tinder() {
		this.users = new ArrayList<>();
		LikeMap = new HashMap<>();
		this.nameUserMapping = new HashMap<>();
		this.matches=new HashMap<>();
	}

	public boolean create_account(String name, int x, int y, int age, Gender gender){
		User user=new User(name,x,y,age,gender);
		users.add(user);
		nameUserMapping.put(name,user);
		LikeMap.put(user.getName(),new HashSet<>());
		return true;
	}

	public void potential_match(String username){
		if(!nameUserMapping.containsKey(username)) {
			System.out.println("the user is not registered");
			return;
		}

		User user=nameUserMapping.get(username);
		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				// this score is negative then it is sorted in ascending order.
				// o1-o2 will return when proximity score is minimum.
				// o2-o1 will return when proxmimity score is large first.
				return  User.diffScore(user,o2) - User.diffScore(user,o1);
			}
		});
		for(User itrUser:users ){
			if(itrUser!=user) System.out.println(itrUser.getName());
		}
	}

	public boolean like(String likedby,String  liked){
		LikeMap.get(likedby).add(liked);
		return true;
	}

    private	void preprocess(){

	    for(User user:users) {

		    for (String itruser : LikeMap.get(user.getName())) {

			    if (LikeMap.get(itruser).contains(user.getName())) {
				    if (!matches.containsKey(user.getName())) {
					    matches.put(user.getName(), new HashSet<>());
				    }
				    if (!matches.containsKey(itruser)) {
					    matches.put(itruser, new HashSet<>());
				    }

				    matches.get(user.getName()).add(itruser);
				    matches.get(itruser).add(user.getName());
			    }
		    }
	    }
	    return;
    }

	public void showMatches(String username){
		preprocess();
		if(!matches.containsKey(username)){
			System.out.println("No Matches for this user");
			return;
		}
		System.out.println("Matches for user" + username);
		for(String userb: matches.get(username)){
			if(LikeMap.get(userb).contains(username)) System.out.println(" " + userb);
		}
		return;
	}



	public void showAllMatches() {
		preprocess();
		for(String user: matches.keySet()){
			if(matches.get(user).size()>0){
				System.out.println("Matches for " + user);

				for(String userb: matches.get(user)){
					System.out.println(" " + userb);
				}
			}
		}
		return;
	}


	public void deleteAccount(String username){

		User userToDelete=nameUserMapping.get(username);
		for(User user:users) {
			for (String itr : LikeMap.get(nameUserMapping.get(user.getName()))) {
				if (LikeMap.get(itr).contains(userToDelete))
					LikeMap.get(itr).remove(userToDelete);
			}
		}
		LikeMap.remove(userToDelete);
		users.remove(userToDelete);
	}

}
