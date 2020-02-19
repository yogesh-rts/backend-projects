


package com.restdatabase.manytomany.Controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restdatabase.manytomany.model.Book;
import com.restdatabase.manytomany.repository.BookRepository;




@RestController
public class BookController {
	@Autowired
	private BookRepository bookrepo;
	
	
	@GetMapping("/books")
	Page<Book> findAllBooks(Pageable pageable){
		return bookrepo.findAll(pageable);
	}
	
	@GetMapping("/books/{id}")
	public Optional<Book> getBook(@PathVariable("id") int id) {
		return bookrepo.findById(id);
	}
	
	@PostMapping("/books")
	 public Book createBook(@RequestBody Book book) {
		bookrepo.save(book);
		return book;
	}
	
	@PutMapping("/books")
	 public Book createOrUpdateBook(@RequestBody Book book) {
		bookrepo.save(book);
		return book;
	}
	
	@DeleteMapping("/books/{id}")
	 public void deleteBook(@PathVariable("id") int id ) {
		Book book = bookrepo.getOne(id);
		System.out.println(book);
		bookrepo.delete(book);
	}
	  
	
	@PatchMapping("/bookcategory")
	 public Book updateBookCategory(@RequestBody Book book) {
		
		String [] ignoreProperties = new String[6];
		
		if(book.getName() == null) {
			ignoreProperties[1]="name";
		}
		
		Optional<Book> olddata = bookrepo.findById(book.getId());
		if(olddata.get()!=null)	{	
     		BeanUtils.copyProperties(book,olddata.get(),ignoreProperties);
			bookrepo.save(olddata.get());
			return olddata.get();
			
			
		}
		return null;
		
		
	}
		
}

