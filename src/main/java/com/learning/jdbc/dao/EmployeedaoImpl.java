package com.learning.jdbc.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import com.learning.jdbc.entity.Employee;

public class EmployeedaoImpl implements EmployeeDao {

	private static String INSERT_QUERY = "INSERT INTO EMPLOYEE VALUE (%d,'%s','%s',%d)";
	private static String UPDATE_QUERY = "UPDATE EMPLOYEE SET NAME = '%s' , GENDER= '%s' , SALARY = %d WHERE ID = %d";
	private static String DELETE_QUERY = "DELETE FROM EMPLOYEE WHERE ID = %d";
	private static String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
	private static String SELECT_BY_ID_QUERY = "SELECT * FROM EMPLOYEE WHERE ID = %d";

	static Connection connection = null;

	static {

		try {

//			Properties ps = new Properties();
//			ps.put("user", "root");
//			ps.put("password", "Maurya");
//			
//			Driver driver = new com.mysql.cj.jdbc.Driver();
//			
//			connection = driver.connect("jdbc:mysql://localhost:3306/java12", ps);

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

			statement.executeUpdate(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));

			System.err.println(String.format(UPDATE_QUERY, e.getName(), e.getGender(), e.getSalary(), e.getId()));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	

	@Override
	public void deleteEmpById(int id) throws SQLException {

		try (Statement statement = connection.createStatement()) {

			statement.executeUpdate(String.format(DELETE_QUERY, id));

			System.err.println(String.format(String.format(DELETE_QUERY, id)));
		}

	}
	

	@Override
	public Employee getEmpById(int id) {
		Employee emp = new Employee();
		
		System.err.println(SELECT_BY_ID_QUERY);
		
		try (Statement statement = connection.createStatement()) {

			ResultSet resultset = statement.executeQuery(String.format(SELECT_BY_ID_QUERY, id));

			resultset.next();
				
				emp.setId(resultset.getInt(1));
				emp.setName(resultset.getString(2));
				emp.setGender(resultset.getString(3));
				emp.setSalary(resultset.getInt(4));

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return emp;
	}
	

	@Override
	public void printAllEmps() {
		
		try (Statement statement = connection.createStatement()) {

			System.err.println(SELECT_QUERY);

			ResultSet resultset = statement.executeQuery(SELECT_QUERY);

			while (resultset.next()) {

				System.out.println("Id = " + resultset.getInt(1) + "\t Name =" + resultset.getString(2) + "\t Gender ="
						+ resultset.getString(3) + "\t Salary =" + resultset.getInt(4));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void printAllEmps(String name) {
		// TODO Auto-generated method stub
		
	}

}
