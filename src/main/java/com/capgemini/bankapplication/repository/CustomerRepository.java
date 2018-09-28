package com.capgemini.bankapplication.repository;

import com.capgemini.bankapplication.model.Customer;

public interface CustomerRepository {
	public Customer authenticate(Customer customer);
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);
	
	

}
