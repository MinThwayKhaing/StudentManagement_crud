package DAO;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class MyConnection {
	static Connection con=null;
public  static Connection getConnection() {

try {

Class.forName("com.mysql.jdbc.Driver");

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ojt_database_student",
"root","root");

} catch (ClassNotFoundException e) {
	
System.out.println("Driver class not found");

} catch (SQLException e) {

System.out.println("Database Coonectin not found");

}
	return con;
}

}