package com.springboot_abhyaas.day1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DBUser { 
	private List<User> userTable=new ArrayList<User>();
	
	public DBUser() {
		userTable.add(new User(1,"one",1));
		userTable.add(new User(2,"two",2));
	}
	
	/*
	 * public DBUser(User user) {
	 * userTable.add(user);
	 * }
	 */
	
	
	public List<User> getAll(){
		return userTable;
	}
	
	public User get1User(int id) {
		for(User user:userTable ) 
			{
				if(user.getId()==id) 
					{
						return user;
					}
			}
				return null;
		}

	public User getUserByName(String name) {
		for(User user:userTable) {
			System.out.println(user.getName()+name);
			if(user.getName().equals(name)) 
			{
				//System.out.println(user.getId()+user.getName());
				return user;
			}
			
		}
		return null;
	}
	
	public User add_User(User user) {
		userTable.add(user);
		System.out.println(userTable);
		return user;
	}
	
	public Boolean del_AUser(int ID) {
		for(User user:userTable){
			return (user.getId()==ID?(boolean)(userTable.remove(user)) :false);
			}
		return null; //in case thats not in the userTable , there should be some return instrn for that too !
	}

}


