package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/mvc";
	static final String USER = "root";
	static final String PASS = "1234";
	
	public static Connection createConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		return conn;
	}
}
