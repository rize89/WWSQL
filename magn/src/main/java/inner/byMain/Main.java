package inner.byMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	private static final String SQL = "INSERT INTO TEST(FIELD) VALUES(?);";

	static { // driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException: Driver is't run");
		}
	}

	public static void main(String[] args) throws SQLException {

		Main someObj = new Main();
		
		Scanner scn;

		someObj.setUrl("jdbc:mysql://localhost:3306/userDB");
		someObj.setUsername("root");
		someObj.setPassword("1111");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userDB", "root", "1111");
			System.out.println("Got our connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement stmt = connection.createStatement();
		ResultSet rset = stmt.executeQuery(SQL);
		while ( rset.next()) {
			stmt.executeUpdate(SQL);
			System.out.println(stmt);
			System.out.println(rset);
			}
		rset.close(); 
	}
	
	private String url;
	private String username;
	private String password;



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
