package UseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class user {
private static final String url="jdbc:mysql://localhost:3306/Bank" ;
private static final String userName="root";
private static final String Password="Vbcd@123";
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
}
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, Password);
	}
	
	

}
