package spring.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.BookDao;
import spring.dao.CustomerDAO;
import spring.dao.RoleDao;
import spring.entity.Book;
import spring.entity.Customer;
import spring.entity.Role;
import spring.user.AppUser;

//@Service is applied to Service implementations
//Spring will automatically register the Service implementation thanks to component-scanning

@Service
public class ServiceImpl implements CustomerService, BookService{

	//need to implements customer DAO - inject DAO into Service
	//Spring will scan for component that implements CustomerDAO interface
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional //automatically begin and end transaction in Hibernate
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);

	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		
		return customerDAO.getCustomers(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);

	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerDAO.searchCustomers(theSearchName);
	}

	
	/////////////////////////////////////////////////////////////////
	
	@Autowired //inject Book DAO into Service
	//Spring will scan for component that implements BookDao interface
	private BookDao bookDao;
	
	
	@Override
	@Transactional
	public List<Book> getBooks() {
		
		return bookDao.getBooks();
	}

	@Override
	@Transactional
	public void saveBook(Book theBook) {
		
		bookDao.saveBook(theBook);
		
	}

	@Override
	@Transactional
	public Book getBook(int theId) {
		
		return bookDao.getBook(theId);
	}

	@Override
	@Transactional
	public void deleteBook(int theId) {
		
		bookDao.deleteBook(theId);
		
	}

	@Override
	@Transactional
	public List<Book> searchBooks(String theSearchTitle) {
		
		return bookDao.searchBook(theSearchTitle);
	}

	@Override
	@Transactional
	public void buyBook(Book theBook, Customer theCustomer) {
		
		bookDao.buyBook(theBook, theCustomer);
		
	}

	
	//#######################
	

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Customer findByUserName(String userName) {
		// check the database if the user already exists
		return customerDAO.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(AppUser crmUser) {
		Customer customer = new Customer();
		 // assign user details to the user object
		customer.setUserName(crmUser.getUserName());
		customer.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		customer.setFirstName(crmUser.getFirstName());
		customer.setLastName(crmUser.getLastName());
		customer.setEmail(crmUser.getEmail());

		// give user default role of "employee"
		customer.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

		 // save user in the database
		customerDAO.save(customer);
	}

	//@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Customer customer = customerDAO.findByUserName(userName);
		if (customer == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(customer.getUserName(), customer.getPassword(),
				mapRolesToAuthorities(customer.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	
}
