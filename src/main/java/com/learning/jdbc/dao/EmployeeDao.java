package com.learning.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import com.learning.jdbc.entity.Employee;

public interface EmployeeDao {


    public void saveEmployee(Employee e);

    public void updateEmpData(Employee e);

    public void deleteEmpById(int id) throws SQLException;

    public Employee getEmpById(int id);
    
    public void printEmpByName(String name);

    public void printAllEmps();

    public List<Employee> getAllEmp();

}