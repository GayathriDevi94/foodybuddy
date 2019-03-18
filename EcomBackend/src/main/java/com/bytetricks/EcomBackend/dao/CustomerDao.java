package com.bytetricks.EcomBackend.dao;

import java.util.List;

import com.bytetricks.EcomBackend.model.Customer;

public interface CustomerDao 
{
	boolean insertCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(Customer customer);
	List<Customer> selectAllCustomers();
	Customer selectOneCustomer();

}
