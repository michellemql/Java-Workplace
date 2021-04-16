//package com.amazon.shoppingCart;

public class UserProfile {
	
	private String name;
	private String lastName;
	private int phoneNumber;
	private String emailAddress;
	private int ssnNumber;
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age<100)
		{
			this.age = age;
		}
		else
		{
			this.age = 0;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getSsnNumber() {
		return ssnNumber;
	}
	public void setSsnNumber(int ssnNumber) {
		this.ssnNumber = ssnNumber;
	}
	
}
