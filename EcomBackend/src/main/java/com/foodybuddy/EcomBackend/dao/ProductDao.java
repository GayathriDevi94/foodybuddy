package com.foodybuddy.EcomBackend.dao;

import java.util.List;

import com.foodybuddy.EcomBackend.model.Product;

public interface ProductDao {

	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int prodid);
	List<Product> selectAllProducts();
	List<Product> selectCatProducts(int id);
	Product selectOneProduct(int prodid);
}
