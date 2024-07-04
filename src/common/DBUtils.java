package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	
	private static Connection connection;
	private static java.sql.Statement statement;
	
	static {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","lokesh06");
			statement = connection.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = statement.executeQuery(query);
		return result;
	}
	
	public static void executeQuery(String query) throws SQLException {
		statement.execute(query);
	}
}


