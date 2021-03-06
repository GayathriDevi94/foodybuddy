package com.foodybuddy.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodybuddy.EcomBackend.dao.CustomerDao;
import com.foodybuddy.EcomBackend.model.Customer;
import com.foodybuddy.EcomBackend.model.UserCred;

@Transactional
@Repository

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			UserCred uc = new UserCred();
			uc.setUsername(customer.getCustemailid());
			uc.setPassword(customer.getCustpass());
			uc.setRole("ROLE_CUSTOMER");
			uc.setStatus(false);
			sessionFactory.getCurrentSession().save(customer);
			sessionFactory.getCurrentSession().save(uc);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteCustomer(String custemailid) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(custemailid, Customer.class);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Customer").list();
		} catch (Exception e) {
			return null;
		}
	}
	public Customer selectOneCustomer(String custemailid) {
		// TODO Auto-generated method stub
		try {
			return (Customer) sessionFactory.getCurrentSession()
					.createQuery("from Customer where custemailid='" + custemailid + "'").uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

}
