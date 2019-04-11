package com.foodybuddy.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodybuddy.EcomBackend.dao.AddressDao;
import com.foodybuddy.EcomBackend.model.Address;
@Repository("AddressDao")
@Transactional
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Address> selectAllAddress(int custid) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Address where customer_custid="+custid).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Address selectOneAddress(int addressid) {
		try {
			return (Address) sessionFactory.getCurrentSession().createQuery("from Address where addressid=" + addressid).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

}
}
