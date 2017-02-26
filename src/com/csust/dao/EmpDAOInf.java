package com.csust.dao;

import java.util.List;

import com.csust.model.Employee;

public interface EmpDAOInf {
	List<Employee> getAllEmps();
	boolean passIsValid(String name,String password);
	boolean insertEmp(Employee employee);
	boolean deleteEmp(String jobID);
}
