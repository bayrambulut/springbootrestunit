package com.example.springbootrestunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootrestunit.model.Book;
import com.example.springbootrestunit.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository repository;

	@Override
	public Book save(Book book) {
		return repository.save(book);
	}
	
	@Override
	public List<Book> findAll() {
		return repository.findAll();
	}
	
}
