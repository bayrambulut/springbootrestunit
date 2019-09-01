package com.example.springbootrestunit.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springbootrestunit.exception.BookNotFoundException;
import com.example.springbootrestunit.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookRepositoryTest {

	static Logger logger = Logger. getLogger(BookRepositoryTest.class.getName());

	
	@Autowired
	BookRepository repository;
	
	@Before
	public void pre() {
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void repository_test() throws Exception {
		
		Book book = new Book("Book", "Author");		
		Book savedBook = repository.save(book); 
		
		Book readBook = repository.findById(savedBook.getId())
		         .orElseThrow(() -> BookNotFoundException.build(savedBook.getId()));
		
		logger.info("id : " + book.getId());
		assertEquals(book.getId(), readBook.getId());
		assertEquals(book.getName(), "Book");
		assertEquals(book.getAuthor(), "Author");
				
	}
}
