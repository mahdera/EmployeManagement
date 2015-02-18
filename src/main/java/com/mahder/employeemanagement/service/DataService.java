package com.mahder.employeemanagement.service;

import java.util.List;

import com.mahder.employeemanagement.domain.Employee;

public interface DataService {
	public int saveEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int id);
	public List<Employee> listEmployee();
	public Employee getEmployee(int id);
}//end interface