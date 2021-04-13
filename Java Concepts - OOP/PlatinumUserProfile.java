package com.amazon.shoppingCart;

public class PlatinumUserProfile extends UserProfile{
	
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String getName() {
		return super.getName().toLowerCase();
	}

}
