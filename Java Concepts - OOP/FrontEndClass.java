package com.amazon.shoppingCart;

import java.util.ArrayList;

public class FrontEndClass {

	public static void main(String[] args) {
	
		
		// ScannerClass --> user input
		// Do - While
		UserProfileDAO JAVASDET = new UserProfileDAO();		
		
		UserProfile user1 = new UserProfile();
		user1.setName("Roberto");
		user1.setLastName("Contreras");
		user1.setEmailAddress("roberto@gmail.com");
		user1.setAge(101);
		user1.setZipcode(92836);
		
		JAVASDET.addUser(user1);
		
		UserProfile user2 = new UserProfile();
		user2.setName("Brian");
		user2.setLastName("Brian");
		user2.setEmailAddress("brian@gmail.com");
		user2.setAge(21);
		user1.setZipcode(92836);

		
		JAVASDET.addUser(user2);
		
		UserProfile user3 = new UserProfile();
		user3.setName("Swetha");
		user3.setLastName("Sharabu");
		user3.setEmailAddress("swetha@gmail.com");
		user3.setAge(21);
		user1.setZipcode(92836);

		JAVASDET.addUser(user3);
		
		JAVASDET.displayAllUser();
		
		
		PlatinumUserProfile platUser = new PlatinumUserProfile();
		
		
		
		
	}
}
