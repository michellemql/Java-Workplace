package user.registration.maven;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserProfile {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String passwordComfirm;
	
	
	public UserProfile(String firstName, String lastName, String email, String password, String passwordComfirm) {	
		this.firstName = firstName;
		this.lastName = lastName;		
		
		// validate email: non-empty & must contains '@'
		if (!validEmail(email)) {
			System.out.println("Invalid email.");
		} else {
			this.email = email;
		}
		
		// validate password: password must match with passwordComfirm 
		// && length >= 8, contains at least 1 uppercase letter, 1 lowercase letter, and 1 number
		if (!isValidPassword(password)) {
			System.out.println("Invalid password. Password must contain at least 8 characters and at most 20 characters, at least 1 uppercase letter, 1 lowercase letter, and 1 number");
		} 
		if (!password.equals(passwordComfirm)) {
			System.out.println("Passwords do not match.");
		} else {
			this.password = password;
		}
	}
 
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.length() == 0 || email.indexOf('@') == -1) {
			System.out.println("Invalid Email Address. Please enter again.");
		} else {
			this.email = email;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordComfirm() {
		return passwordComfirm;
	}

	public void setPasswordComfirm(String passwordComfirm) {
		this.passwordComfirm = passwordComfirm;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
	
	/*** Input validation helper functions ***/
	
	// validate email
	public boolean validEmail(String email) {
		if (email.indexOf('@') == -1) {
			return false;
		}
		return true;
	}
	// validate password
	public boolean isValidPassword(String password) {
		// Also add "(?=.*[@#$%^&+=])" if want a password must contain at least one special character 
		// which includes !@#$%&*()-+=^.
		if (password == null) return false;
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}
	/*
	public void ShowAccountDetails() {
		System.out.println("Account Number = " + this.accountNumber);
		System.out.println("Name  = " + this.firstName + " " + this.lastName);
		System.out.println("Email = " + this.email);
		System.out.println("Phone Number = " + this.phoneNumber);
		System.out.println("Balance = " + balance);
	}
	*/
}
