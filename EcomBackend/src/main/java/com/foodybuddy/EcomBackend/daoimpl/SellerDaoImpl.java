package com.foodybuddy.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodybuddy.EcomBackend.dao.SellerDao;
import com.foodybuddy.EcomBackend.model.Seller;
import com.foodybuddy.EcomBackend.model.UserCred;
@Transactional
@Repository

public class SellerDaoImpl implements SellerDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insertSeller(Seller seller) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(seller);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public boolean updateSeller(Seller seller) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(seller);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public boolean deleteSeller(String sellername) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneSeller(sellername));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}
	

	public List<Seller> selectAllSellers() {
		// TODO Auto-generated method stub
		try
		{
		return sessionFactory.getCurrentSession().createQuery("from Seller").list();	
		}
		catch(Exception e)
		{
		return null;
		}	}

	public Seller selectOneSeller(String sellername) {
		// TODO Auto-generated method stub
		try
		{
			return (Seller)sessionFactory.getCurrentSession().createQuery("from Seller where sellername='"+sellername+"'").uniqueResult();
		}
		catch(Exception e)
		{
		return null;
	}	}

}
