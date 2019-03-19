package com.learning.java.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.java.demo.Entity.Book;
import com.learning.java.demo.Service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping(value = "/books/{id}")
	public Optional<Book> getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping(value = "/books")
	public void addBook(@RequestBody(required = true) Book book) {
		bookService.addBook(book);
	}
	
	@PutMapping(value = "/books")
	public void updateBook(@RequestBody(required = true) Book book) {
		bookService.updateBook(book);
	}
	
	@DeleteMapping(value = "/books")
	public void deleteBook(@RequestBody(required = true) Book book) {
		bookService.deleteBook(book);
	}
}
