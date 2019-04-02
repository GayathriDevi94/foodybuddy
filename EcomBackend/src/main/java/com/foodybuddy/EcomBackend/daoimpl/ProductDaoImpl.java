package com.foodybuddy.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodybuddy.EcomBackend.dao.ProductDao;
import com.foodybuddy.EcomBackend.model.Category;
import com.foodybuddy.EcomBackend.model.Product;
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public boolean deleteProduct(int prodid) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneProduct(prodid));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public List<Product> selectAllProducts() {
		// TODO Auto-generated method stub
		try
		{
		return sessionFactory.getCurrentSession().createQuery("from Product").list();	
		}
		catch(Exception e)
		{
		return null;
		}	}

	public List<Product> selectCatProducts(int id) {
		// TODO Auto-generated method stub
		try
		{
		return sessionFactory.getCurrentSession().createQuery("from Product where prodcateg="+id).list();	
		}
		catch(Exception e)
		{
		return null;
		}	}

	public Product selectOneProduct(int prodid) {
		// TODO Auto-generated method stub
		try
		{
			return (Product)sessionFactory.getCurrentSession().createQuery("from Product where prodid="+prodid).uniqueResult();
		}
		catch(Exception e)
		{
		return null;
	}	}

}
 