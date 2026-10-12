package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.learning.jdbc.entity.Employee;

public class Main {

	public static void main(String[] args) throws SQLException {
		
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java12","root","Maurya");
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into employee value(9, 'Ankit', 'male', 85000)");
//		statement.executeUpdate("insert into employee value(10, 'Riti', 'female', 85000)");
//		statement.executeUpdate("insert into employee value(11, 'Niti', 'female', 85000)");
		
//		Statement statement = DriverManager.getConnection("jdbc:mysql://localhost:3306/java12","root","Maurya").createStatement();
//		statement.executeUpdate("insert into employee value(12, 'Niti', 'female', 85000)");
		
		DriverManager.getConnection("jdbc:mysql://localhost:3306/java12","root","Maurya").createStatement().executeUpdate("insert into employee value(13, 'Aarti', 'female', 85000)");
		System.err.println("Transaction comleted.............");
	}

}