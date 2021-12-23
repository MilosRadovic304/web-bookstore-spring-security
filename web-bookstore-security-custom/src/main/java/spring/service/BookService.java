package spring.service;

import java.util.List;

import spring.entity.Book;
import spring.entity.Customer;



public interface BookService {

	public List<Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theId);

	public void deleteBook(int theId);

	public List<Book> searchBooks(String theSearchTitle);

	void buyBook(Book theBook, Customer theCustomer);
	
}
