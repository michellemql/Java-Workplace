import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class RegistrationPage {

	public static Scanner scanner;
	public static UserProfileDAO userRegister = new UserProfileDAO();
	
	public static void main(String[] args) {	
		
		System.out.println("Hello! Welcome to User Registration Page!");
		
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
		userRegister = new UserProfileDAO();		
		 
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
			
			boolean result = UserProfileDAO.addUser(user);
			if (result) {
				System.out.println("User has been successfully added!");
				// display new user
			} else {
				System.out.println("User already exists or registration failed. Pleas try again.");
			}
		} 
		else if (action.contains("update")) {
//			doTaskUpdate();
			System.out.println("Which user's info do you want to update? Please enter id.");
			int id = scanner.nextInt();
			UserProfile user = UserProfileDAO.findUser(id);
			if (user == null ) {
				System.out.println("User doesn't exist.");
				return;
			}
			UserProfileDAO.displayOneUser(user.getId());
			System.out.println("What do you want to update?");
			String section = scanner.next();
			
			if (section.contains("firstname")) {
				System.out.println("Enter new first name: ");
			} else if (section.contains("last")) {
				System.out.println("Enter new last name: ");
			} else if (section.contains("email")) {
				System.out.println("Enter new email address: ");
			} else if (section.contains("email")) {
				System.out.println("Enter new password: ");
			} else {
				System.out.println("Sorry, I didn't understand you. Please start over.");
			}
			String updatedInfo = scanner.next();
			boolean result = UserProfileDAO.updateUser(id, section, updatedInfo);
			if (result) {
				System.out.println("User's info has been successfully updated");
				return;
			} else {
				System.out.println("User doesn't exist.");
				return;
			}
			
		} 
		else if (action.contains("delete")) {
			System.out.println("Which user do you want to delete? Please enter id.");
			int id = scanner.nextInt();
			boolean result = UserProfileDAO.deleteUser(id);
			if (result != false) {
				System.out.println("User has been successfully deleted.");
				// display all users return
			} else {
				System.out.println("User doesn't exist. Please try again.");
			}
		} 
		//
		else if (action.contains("display a user") || action.contains("display one user") || action.contains("display single user")) {
			System.out.println("Which user's info do you want to see? Please enter id.");
			int id = scanner.nextInt();
			UserProfile user = UserProfileDAO.displayOneUser(id);
			if (user != null) {
				System.out.print("User Id: " + user.getId() + ", ");
				System.out.print("First Name: " + user.getFirstName() + ", ");
				System.out.print("Last Name: " + user.getLastName() + ", ");
				System.out.print("Email: " + user.getEmail() + ", ");
				System.out.print("Password: " + user.getPassword() + "\n");
				
			} else {
				System.out.println("User doesn't exist.");
				return;
			}	
		}
		else if (action.contains("all")) {
			HashMap<Integer, UserProfile> usersMap = UserProfileDAO.displayAllUser();
			if (usersMap.size() == 0) {
				System.out.println("No user exists. Please add one!");
			}
			for (Map.Entry<Integer, UserProfile> entry : usersMap.entrySet()) {
				UserProfile user = entry.getValue();
				System.out.print("User Id: " + user.getId() + ", "
						+ "First Name: " + user.getFirstName() + ", "
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
	public static void doTaskUpdate() {
		
		
	}
}
