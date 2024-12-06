package accesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SConnection {
	   public static Connection getConnection() throws SQLException {
	        // Connect to your MySQL database
	        String url = "jdbc:mysql://localhost:3306/entrainements";
	        String username = "root";
	        String password = "";
	        return DriverManager.getConnection(url, username, password);

}
}
