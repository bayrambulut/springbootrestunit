package com.example.springbootrestunit.exception;

public class BookNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5061407806582473647L;
	private Long id;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public BookNotFoundException(String message) {
        super(message);
    }

	
    public static BookNotFoundException build(Long id) {
    	
        return new BookNotFoundException("Not Found bookId " + id);

    	
    }
    

	
	
}
