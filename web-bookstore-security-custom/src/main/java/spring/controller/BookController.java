package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import spring.entity.Book;
import spring.entity.Customer;
import spring.service.BookService;
import spring.service.CustomerService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired //Inject Service into Controller
	private BookService bookService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listBooks(Model theModel) {
		
		//get books from service
		List<Book> theBooks = bookService.getBooks();
		
		//add books to the model
		theModel.addAttribute("books",theBooks);
		
		
		return "list-books";
	}
	
	
	@GetMapping("/search")
    public String searchBooks(@RequestParam("theSearchName") String theSearchName, Model theModel) {

        // search books from the service
        List<Book> theBooks = bookService.searchBooks(theSearchName);
        // add the books to the model
        theModel.addAttribute("books", theBooks);

        return "list-books";        
    }
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {
		
		// get the book from the service
		Book theBook = bookService.getBook(theId);
		
		//set book as a model attribute to pre-populate the form
		theModel.addAttribute("book", theBook);
		//send over to our form
		
		System.out.println(theBook);
		
		return "updateBookForm";
	}
	
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		// save the book using our service
		bookService.saveBook(theBook);
		
		return "redirect:/book/list";
	}
	
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int theId) {
		
		//delete book using service
		bookService.deleteBook(theId);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/buy")
	public String buyBook(@ModelAttribute("bookId") int bookId, @ModelAttribute("customerId") String customerId) {
		
		// get the book from the service
		Book theBook = bookService.getBook(bookId);
		// get the customer from the service
		Customer theCustomer = customerService.findByUserName(customerId);
		// save the book ID and ID of currently logged customer using our service in sales2 DB table
		bookService.buyBook(theBook, theCustomer);
		
		return "redirect:/book/list";
	}
	
}
