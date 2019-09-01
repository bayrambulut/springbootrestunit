package com.example.springbootrestunit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id;
	
	private String name;
	
	private String author;

	public Book() {
		
	}
	
	public Book(Long id, String name, String author) {
		
		this.id = id;
		this.name = name;
		this.author = author;
	
	}
	
	public Book(String name, String author) {
		
		this.name = name;
		this.author = author;
	
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return this.id + ":" + this.name + ":" + this.author;
	}
	
	@Override
	public int hashCode() {
		return this.id.intValue();
	}
	
    // Overriding equals() to compare two Complex objects 
    @Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Book or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Book)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Book c = (Book) o; 
          
        // Compare the data members and return accordingly  
        if(c.getId() != null && this.getId() != null) {
        	return c.getId().equals(this.getId());
        }
        
        return false;
        
    } 
}
