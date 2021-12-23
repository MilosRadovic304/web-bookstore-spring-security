package spring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import spring.entity.Customer;
import spring.user.AppUser;



public interface CustomerService extends UserDetailsService{

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
    Customer findByUserName(String userName);

    void save(AppUser crmUser);
	
}
