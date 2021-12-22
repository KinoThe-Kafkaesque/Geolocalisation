package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connection connection;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracker", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver introvable");
		} catch (SQLException e) {
			System.out.println("Impossible d'établir la connexion");
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	
	

}