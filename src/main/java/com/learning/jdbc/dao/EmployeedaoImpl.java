package com.learning.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.learning.jdbc.entity.Employee;

public class EmployeedaoImpl implements EmployeeDao {
	
	private static String INSERT_QUERY = "INSERT INTO EMPLOYEE VALUE (%d,'%s','%s',%d)";
	private static String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s' , GENDER= '%s' , SALARY = %d WHERE ID = %d";
	private static String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = %d";

	static Connection connection = null;

	static {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java12", "root", "Maurya");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public void saveEmployee(Employee e) {
//		
//		try (Statement statement = connection.createStatement()) {
//
//			statement.executeUpdate("insert into employee values(" + e.getId() + " ,'" + e.getName() + "','" + e.getGender()
//					+ "'," + e.getSalary() + ")");
//			
//			System.err.println("insert into employee values(" + e.getId() + " ,'" + e.getName() + "','" + e.getGender()
//			+ "'," + e.getSalary() + ")");
//
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//
//	}
	
	@Override
	public void saveEmployee(Employee e) {
		
		try (Statement statement = connection.createStatement()) {
			
			statement.executeUpdate(String.format(INSERT_QUERY, e.getId(), e.getName(), e.getGender(), e.getSalary()));
			
			System.err.println(String.format(INSERT_QUERY, e.getId(), e.getName(), e.getGender(), e.getSalary()));
			
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
	public void deleteEmpById(int id) throws SQLException{
		
		try (Statement statement = connection.createStatement()) {
			
			statement.executeUpdate(String.format(DELETE_QUERY, id));
			
			System.err.println(String.format(String.format(DELETE_QUERY, id)));
		}

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
