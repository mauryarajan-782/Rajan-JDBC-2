package com.learning.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.learning.jdbc.entity.Employee;

public class EmployeedaoImpl implements EmployeeDao {
	
	private static String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s' , GENDER= '%s' , SALARY = %d WHERE ID = %d";

	static Connection connection = null;

	static {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java12", "root", "Maurya");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveEmployee(Employee e) {
		
		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate("insert into employee values(" + e.getId() + " ,'" + e.getName() + "','" + e.getGender()
					+ "'," + e.getSalary() + ")");
			
			System.err.println("insert into employee values(" + e.getId() + " ,'" + e.getName() + "','" + e.getGender()
			+ "'," + e.getSalary() + ")");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void updateEmpData(Employee e) {
		
		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(String.format("UPDATE EMPLOYEE SET NAME = '%s' , GENDER= '%s' , SALARY = %d WHERE ID = %d",e.getName(),e.getGender(),e.getSalary(),e.getId()));
			
			System.err.println(String.format(UPDATE_QUERY,e.getName(),e.getGender(),e.getSalary(),e.getId()));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void deletEmpById(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printEmpByName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printAllEmps() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

}
