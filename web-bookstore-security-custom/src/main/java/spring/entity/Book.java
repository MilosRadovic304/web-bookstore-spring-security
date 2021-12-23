package spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

//Entity Class is a Java class that is mapped to a database table
//Hibernate and spring will know where to scan for our Entity classes by looking in the spring configuration file 
//called spring-web-servlet.xml and bean id =sessionFactory


@Entity
@Table(name="book2") //the name of the table in the DB
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID") //mapping java field to a table column id
	private int id;
	
	@Column(name="TITLE") //mapping java field to a table column title
	private String title;
	
	@Column(name="AUTHOR") //mapping java field to a table column author
	private String author;
	
	
	
	//Books can have many customers, since this is many to many relationship we need to add an additional table in DB called Sales
	//Cascading - when we perform some action on the target entity, the same action will be applied to the associated entity.
	@ManyToMany(fetch=FetchType.LAZY, //taking entries from the DB one by one, this is good for performance of the app
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}) //set all cascadable operations except delete
	//so if we delete a book we will not delete a customer
	@JoinTable(
		name="sales2",
		joinColumns=@JoinColumn(name="book_id"), //refers to book_id column in the sales table
		inverseJoinColumns=@JoinColumn(name="customer_id")	//refers to customer_id column in the sales table
		)
	private List<Customer> customers;
	
	
	// default constructor
	public Book() {		
		
	}


	//getters and setters:
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	
	

	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	
	//convenience method
	public void addCustomer(Customer theCustomer) {
		
		if(customers == null) {
			
			customers = new ArrayList<>();
		}
		
		customers.add(theCustomer);
	}
	
	


	//toString method
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
	
}
