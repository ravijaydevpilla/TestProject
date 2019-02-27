package com.learning.java.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.java.demo.Entity.Book;
import com.learning.java.demo.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;

	}

	public Optional<Book> getBookById(Integer id) {

		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		List<Book> books = getAllBooks();
		boolean bookPresent = false;
		for(Book b:books) {
			if(b.getName().equalsIgnoreCase(book.getName())) {
				bookPresent = true;
			}					
		}
		if(bookPresent == false) {
			bookRepository.save(book);
		}
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}

}
