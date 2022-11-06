package com.miniproject.Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection connection()
	{
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz", "root", "tiger123");
	
	return con;
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	return con;
	}

}

