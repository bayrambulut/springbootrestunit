package com.example.springbootrestunit.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.springbootrestunit.model.Book;
import com.example.springbootrestunit.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookService service;

	ObjectMapper mapper;
	
	@Before
	public void start()  {		
		mapper = new ObjectMapper();
	}
	
	
	@Test
	public void save_test() throws JsonProcessingException, Exception {
		
		Book book = new Book(1L, "Book1", "Author1");
		when(service.save(any(Book.class))).thenReturn(book);
		
		mockMvc.perform(post("/books/")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(book)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Book1")))
				.andExpect(jsonPath("$.author", is("Author1")))
				;
				
	}
	
	@Test
	public void getBooks_test() throws Exception {
		
		List<Book> books = Arrays.asList(
				new Book(1L, "Book1", "Author1"),
				new Book(2L, "Book2", "Author2")
				);
		when(service.findAll()).thenReturn(books);
		
		mockMvc.perform(get("/books/")
			.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[0].name", is("Book1")))
			.andExpect(jsonPath("$[0].author", is("Author1")))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[1].name", is("Book2")))
			.andExpect(jsonPath("$[1].author", is("Author2")))
			;
		
	}
	
} 
