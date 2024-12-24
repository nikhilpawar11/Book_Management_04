package com.nikhil.orm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.orm.entity.Book;
import com.nikhil.orm.entity.User;
import com.nikhil.orm.exception.ResourceNotFoundException;
import com.nikhil.orm.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepo;
	

	@Override
	public Book createBook(Book book, User user) {
		
		Book books = new Book();
		books.setTitle(book.getTitle());
		books.setDescription(book.getDescription());
		books.setDateTime(LocalDateTime.now());
		books.setUser(user);
		
		Book savedBook = bookRepo.save(books);
		
		return savedBook;
	}

	@Override
	public Book udateBook(Book book,int bookId) {
		
		Book bookById = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found by given id !!"));
		
		bookById.setTitle(book.getTitle());
		bookById.setDescription(book.getDescription());
		
		Book updatedbook = bookRepo.save(bookById);
		
		return updatedbook;
	}

	@Override
	public void deleteBook(int bookId) {
		
		Book bookById = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found by given id !!"));
		
		bookRepo.delete(bookById);
		
	}

	@Override
	public List<Book> getAllBook() {
		
		List<Book> allBooks = bookRepo.findAll();
		
		return allBooks;
	}

	@Override
	public Book getBookById(int bookId) {
		
		Book bookById = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found by given id !!"));
		
		return bookById;
	}

	@Override
	public Book likeBook(int bookId, User user) {
		
		Book bookById = bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found by given id !!"));
		
		if(bookById.getLikes().contains(user.getId())) {
			bookById.getLikes().remove(user.getId());
		} else {
			bookById.getLikes().add(user.getId());
		}
		
		Book likeBooks = bookRepo.save(bookById);
		
		return likeBooks;
	}

}
