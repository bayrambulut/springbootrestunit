package com.example.springbootrestunit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestunit.model.Book;
import com.example.springbootrestunit.service.BookService;

@RestController
public class BookController {

	static Logger logger = Logger. getLogger(BookController.class.getName());

	
	@Autowired
	BookService service;
	
	@PostMapping("/books") 
	public Book save(@RequestBody Book book) {
		Book b = service.save(book);
		logger.info("saved book ....." + b);
		return b;
	}
	
	@GetMapping("/books") 
	public List<Book>  getBooks() {
		logger.info("gettting books .....");
		return service.findAll();
	}
	
    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
	
	
}
