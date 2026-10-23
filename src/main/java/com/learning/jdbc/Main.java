package com.learning.jdbc;

import java.sql.SQLException;

import com.learning.jdbc.dao.EmployeeDao;
import com.learning.jdbc.dao.EmployeedaoImpl;
import com.learning.jdbc.entity.Employee;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;


//public static void main(String[] args) throws SQLException {

//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java12","root","Maurya");
//Statement statement = connection.createStatement();
//statement.executeUpdate("insert into employee value(9, 'Ankit', 'male', 85000)");
//statement.executeUpdate("insert into employee value(10, 'Riti', 'female', 85000)");
//statement.executeUpdate("insert into employee value(11, 'Niti', 'female', 85000)");

//Statement statement = DriverManager.getConnection("jdbc:mysql://localhost:3306/java12","root","Maurya").createStatement();
//statement.executeUpdate("insert into employee value(12, 'Niti', 'female', 85000)");

//DriverManager.getConnection("jdbc:mysql://localhost:3306/java12","root","Maurya").createStatement().executeUpdate("insert into employee value(13, 'Aarti', 'female', 85000)");

//System.err.println("Transaction comleted.............");




public class Main {
	
	public static void main(String[] args) throws SQLException {
		
//		Employee emp1 = new Employee(14, "Annsh kumar", "Male", 88000);
//		Employee emp1 = new Employee(11, "Ridhi", "Female", 88000); 				 //Update
		
		Employee emp1 = new Employee(15, "Sidhi", "Female", 88000);
		EmployeeDao eDao = new EmployeedaoImpl();
		
//		eDao.saveEmployee(emp1);
//		eDao.updateEmpData(emp1);
//		eDao.deleteEmpById(14);
//		eDao.printAllEmps();
		
//		Employee em = eDao.getEmpById(4);
//		System.out.println(em);
		
//		System.out.println(eDao.getAllEmp());
		
		//SQL Injection
		eDao.printEmpByName("abc' or 1 = 1 ");
		eDao.printEmpByName("Riti'");
		
		System.err.println("Transaction comleted.............");

	}

}