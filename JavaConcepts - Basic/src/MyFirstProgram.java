package com.amazon.shoppingCart;

public class MyFirstProgram {

	public static void main(String[] args) {
	
		UserProfile user1 = new UserProfile();
		user1.setName("Roberto");
		user1.setLastName("Contreras");
		user1.setEmailAddress("roberto@gmail.com");
		user1.setAge(101);
		
		UserProfile user2 = new UserProfile();
		user2.setName("Brian");
		user2.setLastName("Brian");
		user2.setEmailAddress("brian@gmail.com");
		user2.setAge(21);

		System.out.println(user1.getName());
		System.out.println(user1.getAge());
		System.out.println(user2.getName());
		System.out.println(user2.getAge());


	}

	public void myMethod() {
		System.out.println("This is a method");
	}
}
