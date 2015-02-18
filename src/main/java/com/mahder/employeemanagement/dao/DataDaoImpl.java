package com.mahder.employeemanagement.dao;

import java.io.Serializable;
import java.util.List;






import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mahder.employeemanagement.domain.Employee;

public class DataDaoImpl implements DataDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Integer saveEmployee(Employee employee) {		
		Session sess = getSession();
		Transaction tx = getTransaction(sess);
		sess.save(employee);
		tx.commit();
		Serializable id = sess.getIdentifier(employee);
		sess.close();
		return (Integer) id;
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		Session sess = getSession();
		Transaction tx = getTransaction(sess);
		sess.update(employee);
		tx.commit();
		Serializable id = sess.getIdentifier(employee);
		sess.close();
		return (Integer) id;
	}

	@Override
	public List<Employee> listEmployee() {
		Session sess = getSession();
		List<Employee> empList = sess.createQuery("from Employee").list();
		sess.close();
		return empList;
	}

	@Override
	public Employee getEmployee(int id) {
		Session sess = getSession();
		Employee employee = (Employee) sess.get(Employee.class, id);
		return employee;
	}

	@Override
	public Integer deleteEmployee(int id) {
		Integer num = 0;
		Session sess = getSession();
		Transaction tx = getTransaction(sess);
		Employee employee = getEmployee(id);
		if(employee != null){
			sess.delete(employee);
			tx.commit();
			Serializable i = sess.getIdentifier(employee);
			sess.close();
			num = (Integer) i;
		}
		return num;
	}
	
	private Session getSession(){
		Session session = null;
		if(this.sessionFactory != null){
			session = sessionFactory.getCurrentSession();			
		}else{
			session = sessionFactory.openSession();			
		}
		return session;
	}
	
	private Transaction getTransaction(Session session){
		return session.beginTransaction();
	}

}//end class
