package com.learning.jdbc;

import java.sql.SQLException;

import com.learning.jdbc.dao.EmployeeDao;
import com.learning.jdbc.dao.EmployeedaoImpl;
import com.learning.jdbc.entity.Employee;


public class Main {
	
	public static void main(String[] args) throws SQLException {
		
//		Employee emp1 = new Employee(14, "Annsh kumar", "Male", 88000);
//		Employee emp1 = new Employee(11, "Ridhi", "Female", 88000); 				 //Update
//		Employee emp1 = new Employee(15, "Sidhi", "Female", 88000);
		
		Employee emp1 = new Employee(16, "Anoop", "male", 88000);
		
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
//		eDao.printEmpByName("Riti'");
		
		System.err.println("Transaction comleted.............");

	}

}