package com.amazon.shoppingCart;

import java.util.ArrayList;

public class UserProfileDAO {
	
	ArrayList<UserProfile> javaSDETClass = new ArrayList();
	
	//CRUD --> Create, Read, Update and Delete
	
	//Create User method
	public void addUser(UserProfile user) {
		javaSDETClass.add(user);
	}
	
	//ReadUsers
	public void displayAllUser() {
		for (int j = 0; j < javaSDETClass.size(); j++)
		{
			System.out.print("Name of user - " + javaSDETClass.get(j).getName());
			System.out.println(" " + javaSDETClass.get(j).getLastName());
			System.out.println("Email Address - " + javaSDETClass.get(j).getEmailAddress());
			
			System.out.println();
		}
	}
	
	//display only one user
	
	//Updating user
	
	//Delete User
	
	
}
