/**
 * 
 */
package com.mahder.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mahder.employeemanagement.dao.DataDao;
import com.mahder.employeemanagement.domain.Employee;

/**
 * @author mneway
 *
 */
@Service
public class DataServiceImpl implements DataService {
	@Autowired
	private DataDao dataDao;

	/* (non-Javadoc)
	 * @see com.mahder.employeemanagement.service.DataService#saveEmployee(com.mahder.employeemanagement.domain.Employee)
	 */
	@Override
	@Transactional
	public int saveEmployee(Employee employee) {
		return dataDao.saveEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.mahder.employeemanagement.service.DataService#updateEmployee(com.mahder.employeemanagement.domain.Employee)
	 */
	@Override
	@Transactional
	public int updateEmployee(Employee employee) {
		return dataDao.updateEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.mahder.employeemanagement.service.DataService#deleteEmployee(int)
	 */
	@Override
	@Transactional
	public int deleteEmployee(int id) {
		return dataDao.deleteEmployee(id);
	}

	/* (non-Javadoc)
	 * @see com.mahder.employeemanagement.service.DataService#listEmployee()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Employee> listEmployee() {
		return dataDao.listEmployee();
	}

	/* (non-Javadoc)
	 * @see com.mahder.employeemanagement.service.DataService#getEmployee(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public Employee getEmployee(int id) {
		return dataDao.getEmployee(id);
	}

}//end class