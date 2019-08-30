package com.example.springbootrestunit.service;

import java.util.List;

import com.example.springbootrestunit.model.Book;

public interface BookService {

	Book save(Book book);
	
	List<Book> findAll();
	
}
