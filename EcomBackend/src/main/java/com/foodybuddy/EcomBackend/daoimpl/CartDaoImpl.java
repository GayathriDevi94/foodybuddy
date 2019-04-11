package com.foodybuddy.EcomBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodybuddy.EcomBackend.dao.CartDao;
import com.foodybuddy.EcomBackend.model.Cart;
import com.foodybuddy.EcomBackend.model.Customer;

@Transactional
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean insertCart(Cart cart) {
		
		// TODO Auto-generated method stub
		
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}
	

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	@Override
	public boolean deleteCart(int itemid) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneCart(itemid));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}	

	@Override
	public List<Cart> selectAllCarts(Customer customer) {
		// TODO Auto-generated method stub
		try
		{
		return sessionFactory.getCurrentSession().createQuery("from Cart where customer="+customer.getCustid()).list();	
		}
		catch(Exception e)
		{
		return new ArrayList<Cart>();
		}	}

	@Override
	public Cart selectOneCart(int itemid) {
		// TODO Auto-generated method stub
		try
		{
			return (Cart)sessionFactory.getCurrentSession().createQuery("from Cart where itemid="+itemid).uniqueResult();
		}
		catch(Exception e)
		{
		return null;
	}	}

}

