package com.oynomak.model;

import java.util.*;
import com.oynomak.model.User;

public class UsersList{

	private static List<User> list;

	public static List<User> getAllUsers(){

		return list;
	}

	public static void addUser(User user){
		list.add(user);
	}

	public static void removeUser(long id){
		
		User userToBeRemoved = null;
		for(User user: list){
			if(user.getId() == id){
				userToBeRemoved = user;
				break;
			}
		}
		if(userToBeRemoved != null)
			list.remove(userToBeRemoved);
	}

}