package spring.dao;

import java.util.List;

import spring.entity.Customer;

//DAO = Data Access Object

public interface CustomerDAO {

	public List <Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
	Customer findByUserName(String userName);
	
	void save(Customer theCustomer);
	
}
