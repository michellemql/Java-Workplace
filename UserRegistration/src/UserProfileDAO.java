import java.util.HashMap;
import java.util.Map;

public class UserProfileDAO {
	
	public static HashMap<Integer, UserProfile> usersMap = new HashMap<>();;
	public static int id = 1;
	
	public static boolean addUser(UserProfile user) {
		if (userExists(id)) {
			return false;
		} else if (user.getFirstName() == null 
				|| user.getLastName() == null 
				|| user.getEmail() == null 
				|| user.getPassword() == null) {
			return false;
		} else {
			user.setId(id); 
			usersMap.put(user.getId(), user);
			id++;
		}
		return true;
	}
	
	public static HashMap<Integer, UserProfile> displayAllUser() {
		return usersMap;
	}
	
	public static UserProfile displayOneUser(int id) {
		if (userExists(id)) {
			UserProfile user = findUser(id);
			return user;
		}
		return null;
	}
	
	public static boolean updateUser(int id, String section, String updatedInfo) {
		if (!userExists(id)) {
			return false;
		}
		UserProfile user = findUser(id);
		String data = updatedInfo.toLowerCase();
		if (data.contains("first")) {
			updateUserFirstName(user, data);
		} else if (data.contains("last")) {
			updateUserLastName(user, data);
		} else if (data.contains("email")) {
			updateUserEmail(user, data);
		} else if (data.contains("password")) {
			updateUserPassword(user, data);
		} else {
			return false;
		}
		return true;
	}
	
	public static void updateUserFirstName(UserProfile user, String firstName) {
		user.setFirstName(firstName);
	}
	
	public static void updateUserLastName(UserProfile user, String lastName) {
		user.setLastName(lastName);
	}
	
	public static void updateUserEmail(UserProfile user, String email) {
		user.setEmail(email);
	}
	
	public static void updateUserPassword(UserProfile user, String password) {
		user.setPassword(password);
		user.setPasswordComfirm(password);
	}
	
	
	public static boolean deleteUser(int id) {
		if (usersMap.containsKey(id)) {
			usersMap.remove(id);	
			return true;
		}
		
		return false;
	}
	
	
	public static boolean userExists(int id) {
		if (usersMap.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public static UserProfile findUser(int id) {
		if (userExists(id)) {
			return usersMap.get(id);
		}
		return null;
	}
	
	
}


