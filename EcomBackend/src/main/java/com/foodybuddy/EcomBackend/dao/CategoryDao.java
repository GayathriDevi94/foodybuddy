package com.foodybuddy.EcomBackend.dao;

import java.util.List;

import com.foodybuddy.EcomBackend.model.Category;

public interface CategoryDao {
	
	boolean insertCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(String categname);
	List<Category> selectAllCategories();
	Category selectOneCategory(String categname);

}
