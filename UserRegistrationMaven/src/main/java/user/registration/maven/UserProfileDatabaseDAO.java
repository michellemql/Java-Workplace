package user.registration.maven;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserProfileDatabaseDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://user-database.cyntodbzcul4.us-west-1.rds.amazonaws.com:3306/userdb";
	private final String USER = "admin";
	private final String PASS = "michelle123";
	
	private static Connection conn;
	Statement stmt = null;
	private static ResultSet rs;
	
	public UserProfileDatabaseDAO() {
		// TODO Auto-generated constructor stub
		try {
				Class.forName("com.mysql.jdbc.Driver");
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Creating table in given database...");
				stmt = conn.createStatement();
				
				String sql = "CREATE TABLE IF NOT EXISTS UserProfileTable" + 
							" first_name VARCHAR(255) not NULL, " + 
		                    " last_name VARCHAR(255) not NULL, " +  
							" email VARCHAR(255) not NULL, " +
							" password VARCHAR(255)) ";
				stmt.executeUpdate(sql);
				System.out.println("Created table in given database...");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// addUser ();
		
	}
	
	public static void addUser(String firstName, String lastName, String email, String password, String passwordComfirm) {
		UserProfile newUser = new UserProfile(firstName, lastName, email, password, passwordComfirm);
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Could not add the user.");
			e.printStackTrace();
		}
		
		String sql = "INSERT IGNORE INTO BankAccount VALUES ('" + 
						newUser.getFirstName() + "','" +
						newUser.getLastName() + "','" +
						newUser.getEmail() + "','" +
						newUser.getPassword() + 
						newUser.getPassword() + "');";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Incorrect input, user could not be added.");
			e.printStackTrace();
		}
		return;
	}
	
	public static void addUser(UserProfile user) {
		addUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPasswordComfirm()); 
		return;
	}
	
	public boolean checkUserExists(String email) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery("SELECT count(*) FROM UserProfileTable where email = '" + email + "';");
			rs.next();
			if (rs.getInt("count(*)") == 0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static void deleteUser(String email) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "DELETE FROM UserProfileTable WHERE email='" + email + "';";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not delete the user.");
			e.printStackTrace();
		}
	}
		
	// Display user
	public static UserProfile getUser(String email) {
		Statement stmt = null;
		UserProfile user = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not create statement");
			e.printStackTrace();
		}
		String sql = "SELECT * FROM UserProfileTable WHERE email='" + email + "';";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			System.out.println("Incorrect input, could not execute statement");
			e.printStackTrace();
		}
		return null;
	}
	
	// Display all users
	public static ArrayList<UserProfile> getAllUsers() {
		ArrayList<UserProfile> users = new ArrayList<>();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not create statement");
			e.printStackTrace();
		}
		String sql = "SELECT * FROM UserProfileTable;";
		try {
			rs = stmt.executeQuery(sql);
			UserProfile user;
			while (rs.next()) {
				user = new UserProfile(null, null, null, null, null);
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			System.out.println("Incorrect input, could not execute statement");
			e.printStackTrace();
		}
		return null;
	}
	
	// Update a user
	public static void updateUser(UserProfile user) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "UPDATE UserProfileTable SET first_name = '" + user.getFirstName() + "'," + 
						"last_name = '" + user.getLastName() + "'," +
						"email = '" + user.getEmail() + "'," +
						"password = '" + user.getPassword() + "'" +
						"WHERE email = '" + user.getEmail() + "';";
		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not delete");
			e.printStackTrace();
		}
	}
	
	public static void updateUserEmail(String email, String emailNew) {
		UserProfile user = getUser(email);
		user.setEmail(emailNew);
		updateUser(user);
	}
	
	public static void updateUserPassword(String email, String password, String passwordNew) {
		UserProfile user = getUser(email);
		user.setPassword(passwordNew);
		updateUser(user);
	}
}
