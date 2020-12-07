package inner.conToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ConToDB {

	public static void main(String[] args) {

		try {
			String url = "jdbc:mysql://localhost/userDB?useUnicode=true&serverTimezone=UTC&useSSL=false";
			String username = "root";
			String password = "1111";
			Scanner scanner = new Scanner(System.in);

			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

//             System.out.print("Input product name: ");
//             String name = scanner.nextLine();

			System.out.print("Input N: ");
			int price = scanner.nextInt();
			for (int i = 0; i < price; i++) {
				try (Connection conn = DriverManager.getConnection(url, username, password)) {

					String sql = "INSERT INTO userDB.TEST(FIELD) VALUES(?);";
					PreparedStatement preparedStatement = conn.prepareStatement(sql);

					preparedStatement.setInt(1, i);
					preparedStatement.addBatch();

					int rows = preparedStatement.executeUpdate();

					System.out.printf("%d rows added", rows);
				}
			}
		} catch (Exception ex) {
			System.out.println("Connection failed...");

			System.out.println(ex);
		}
	}

}
