package com.mahder.employeemanagement.dao;

import com.mahder.employeemanagement.domain.Employee;
import java.util.List;

public interface DataDao {
	public Integer saveEmployee(Employee employee);
	public Integer updateEmployee(Employee employee);
	public List<Employee> listEmployee();
	public Employee getEmployee(int id);
	public Integer deleteEmployee(int id);
}//end interface