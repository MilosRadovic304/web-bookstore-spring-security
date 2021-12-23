package spring.dao;

import java.util.List;

import spring.entity.Book;
import spring.entity.Customer;

//DAO = Data Access Object

public interface BookDao {

	public List <Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theId);

	public void deleteBook(int theId);

	public List<Book> searchBook(String theSearchTitle);
	
	public void buyBook(Book theBook, Customer theCustomer);
	
}
