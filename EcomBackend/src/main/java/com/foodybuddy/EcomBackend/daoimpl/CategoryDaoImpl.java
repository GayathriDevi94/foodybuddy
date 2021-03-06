package com.foodybuddy.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodybuddy.EcomBackend.dao.CategoryDao;
import com.foodybuddy.EcomBackend.model.Category;
@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	public boolean insertCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public boolean deleteCategory(String categname) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneCategory(categname));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	}

	public List<Category> selectAllCategories() {
		// TODO Auto-generated method stub
		try
		{
		return sessionFactory.getCurrentSession().createQuery("from Category").list();	
		}
		catch(Exception e)
		{
		return null;
		}	}

	public Category selectOneCategory(String categname) {
		// TODO Auto-generated method stub
		try
		{
			return (Category)sessionFactory.getCurrentSession().createQuery("from Category where categname='"+categname+"'").uniqueResult();
		}
		catch(Exception e)
		{
		return null;
	}	}

}
