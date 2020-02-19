package com.restdatabase.manytomany.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restdatabase.manytomany.model.Book;
import com.restdatabase.manytomany.model.Publisher;
import com.restdatabase.manytomany.repository.PublisherRepository;


@RestController
public class PublishController {
	@Autowired
	private PublisherRepository pubrepo;
	
	
	@GetMapping("/publishers")
	List<Publisher> findAllPublishers(){
		return pubrepo.findAll();
	}
	
	@GetMapping("/publishers/{id}")
	public Optional<Publisher> getPublisher(@PathVariable("id") int id ) {
		return pubrepo.findById(id);
	  
	}
	
	
	@GetMapping("/publishers/{id}/books")
	public Set<Book> getPublisherBooks(@PathVariable("id") int id ) {
		Optional<Publisher> publish = pubrepo.findById(id);
		return publish.get().getBooks();
	}
	
	
	@PostMapping("/publishers")
	 public Publisher createPublisher(@RequestBody Publisher pub) {
		pubrepo.save(pub);
		return pub;
	}
	
	@PutMapping("/publishers")
	 public Publisher createOrUpdatePublisher(@RequestBody Publisher pub) {
		pubrepo.save(pub);
		return pub;
	}
	
	@DeleteMapping("/publishers/{id}")
	 public void deletePublisher(@PathVariable("id") int id ) {
		Publisher pub = pubrepo.getOne(id);
		System.out.println(pub);
		pubrepo.delete(pub);
	}
	  
	
	@PatchMapping("/publishers")
	 public Publisher updateBookCategory(@RequestBody Publisher pub) {
		
		String [] ignoreProperties = new String[6];
		
		if(pub.getName() == null) {
			ignoreProperties[1]="name";
		}
		
		Optional<Publisher> olddata = pubrepo.findById(pub.getId());
		if(olddata.get()!=null)	{	
     		BeanUtils.copyProperties(pub,olddata.get(),ignoreProperties);
			pubrepo.save(olddata.get());
			return olddata.get();
			
			
		}
		return null;
		
		
	}
		

}
