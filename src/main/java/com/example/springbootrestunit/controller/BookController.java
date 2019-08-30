package com.example.springbootrestunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestunit.model.Book;
import com.example.springbootrestunit.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@PostMapping("/books") 
	public Book save(@RequestBody Book book) {
		return service.save(book);
	}
	
	@GetMapping("/books") 
	public List<Book>  getBooks() {
		return service.findAll();
	}
	
    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
	
	
}
