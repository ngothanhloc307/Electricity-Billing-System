package electricity;

import java.sql.*;
public class Connect {
	
	Connection con;
	Statement stmt;
	Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","root");
				stmt = con.createStatement();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.getStackTrace();
		} 
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
