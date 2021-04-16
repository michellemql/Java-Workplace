package user.registration.maven;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class UserProfileFrontEnd {

	public static Scanner scanner;
	public static UserProfileDatabaseDAO userRegister = new UserProfileDatabaseDAO();
	
	public static void main(String[] args) {	
		
		System.out.println("Hello! Welcome to User Registration Page!");
		UserProfileDatabaseDAO userDAO = new UserProfileDatabaseDAO();
		while (true) {
			doTask();
			System.out.println("Is there anything else I can help you with? (yes/no)");
			String answer = scanner.nextLine();
			if (answer.equals("yes")) {
				doTask();
				answer = "";
			} else if (answer.equals("no")){
				answer = "";
				System.out.println("Thank you. Bye.");
				break;
			}
		}
		scanner.close();

	}
	
	public static void doTask() {
		scanner = new Scanner(System.in);
		System.out.println("How can I help you? (Please select one: Add a user, Update a user, Delete a user, Display a user, Display all users)");
		String input = scanner.nextLine();
		String action = input.toLowerCase();
		userRegister = new UserProfileDatabaseDAO();		
		 
		if (action.contains("add")) {
			System.out.println("First Name: ");
			String firstName = scanner.nextLine();
			System.out.println("Last Name: ");
			String lastName = scanner.nextLine();
			System.out.println("Email: ");
			String email = scanner.nextLine();
			System.out.println("Password : ");
			String password = scanner.nextLine();
			System.out.println("Comfirm Password : ");
			String passwordComfirm = scanner.nextLine();
			
			UserProfile user = new UserProfile(firstName, lastName, email, password, passwordComfirm);
			
			UserProfileDatabaseDAO.addUser(user);
		} 
		else if (action.contains("update")) {
			System.out.println("Which user's info do you want to update? Please enter email address.");
			String email = scanner.nextLine();
			UserProfile user = UserProfileDatabaseDAO.getUser(email);
			if (user == null ) {
				System.out.println("User doesn't exist.");
				return;
			}
			System.out.println("What do you want to update? (email or password)");
			String section = scanner.next();
			
			if (section.contains("email")) {
				System.out.println("Enter new email address: ");
				String updatedInfo = scanner.next();
				UserProfileDatabaseDAO.updateUserEmail(user.getEmail(), updatedInfo);
			} else if (section.contains("password")) {
				System.out.println("Enter new password: ");
				String updatedInfo = scanner.next();
				UserProfileDatabaseDAO.updateUserPassword(user.getEmail(), user.getPassword(), updatedInfo);
			} else {
				System.out.println("Sorry, I don't understand you. Please try again.");
			}
			
		} 
		else if (action.contains("delete")) {
			System.out.println("Which user do you want to delete? Please enter email address.");
			String email = scanner.nextLine();
			UserProfileDatabaseDAO.deleteUser(email);
		} 
		else if (action.contains("display a user") || action.contains("display one user") || action.contains("display single user")) {
			System.out.println("Which user's info do you want to see? Please enter email address.");
			String email = scanner.nextLine();
			UserProfile user = UserProfileDatabaseDAO.getUser(email);
			if (user != null) {
				System.out.print("First Name: " + user.getFirstName() + ", ");
				System.out.print("Last Name: " + user.getLastName() + ", ");
				System.out.print("Email: " + user.getEmail() + ", ");
				System.out.print("Password: " + user.getPassword() + "\n");
				
			} else {
				System.out.println("User doesn't exist.");
				return;
			}	
		}
		else if (action.contains("all")) {;
			ArrayList<UserProfile> users = UserProfileDatabaseDAO.getAllUsers();
			if (users.size() == 0) {
				System.out.println("No user exists. Please add one!");
			}
			System.out.println("All users' info: ");
			for (UserProfile user : users) {
				
				System.out.print("First Name: " + user.getFirstName() + ", "
						+ "Last Name: " + user.getLastName() + ", " 
						+ "Email: " + user.getEmail()
						+ "Password: " + user.getPassword() + "\n");
			}
			return;
		} 
		else {
			System.out.println("Sorry, I didn't understand you. Please start over.");
			return;
		}
		
	}
}
