package testDbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDbConn {

	public static void main(String[] args) {
		
		String user ="system";
		String pass ="milos";
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//get connection to database
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			
			String query = "select * from customer";
			
			Statement statement = myConn.createStatement();

			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				System.out.println(result.getString("last_name"));
			}
			
			System.out.println("Connection successful!!!");
			
			myConn.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}

	}

}
