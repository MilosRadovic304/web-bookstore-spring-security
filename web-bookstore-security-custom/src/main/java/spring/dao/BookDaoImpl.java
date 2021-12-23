package spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import spring.entity.Book;
import spring.entity.Customer;

//@Repository is specific for DAO implementations
//it ensures that DAO class will be available for component scanning
//Spring will automatically register DAO implementation thanks to component scanning

@Repository
public class BookDaoImpl implements BookDao{

	
	//used to inject the Hibernate session factory into DAO
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Book> getBooks() {
		
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query .. sort by last name
		Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);
		
		
		//execute query and get result list
		List<Book> books = theQuery.getResultList();
		
		//return the results
		
		return books;
	}
	
	

	@Override
	public void saveBook(Book theBook) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the book 
		currentSession.saveOrUpdate(theBook);
		
	}
	
	

	@Override
	public Book getBook(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using primary key
		Book theBook = currentSession.get(Book.class, theId);
		
		return theBook;
	}

	@Override
	public void deleteBook(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete from database using primary key
		Query theQuery = currentSession.createQuery("delete from Book where id=:bookId");
		
		theQuery.setParameter("bookId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Book> searchBook(String theSearchTitle) {
		
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchTitle != null && theSearchTitle.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Book where lower(title) like :theTitle or lower(author) like :theTitle", Book.class);
            theQuery.setParameter("theTitle", "%" + theSearchTitle.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Book", Book.class);            
        }
        
        // execute query and get result list
        List<Book> books = theQuery.getResultList();
                
        // return the results        
        return books;
	}



	@Override
	public void buyBook(Book theBook, Customer theCustomer) {

		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
		
        currentSession.saveOrUpdate(theBook);
 
        theBook.addCustomer(theCustomer);
        
        
	}

	
	
}
