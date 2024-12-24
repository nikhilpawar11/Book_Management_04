package com.nikhil.orm.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.orm.entity.Book;
import com.nikhil.orm.entity.User;
import com.nikhil.orm.exception.ApiResponseMessage;
import com.nikhil.orm.service.BookService;
import com.nikhil.orm.service.UserService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/createBook/user/{userId}")
	public ResponseEntity<Book> createBook(@RequestBody Book book, @PathVariable int userId){
		
		User userById = userService.getUserById(userId);
		
		Book savedBook = bookService.createBook(book, userById);
		
		return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/updateBook/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable int bookId){
		
		Book updatedBook = bookService.udateBook(book, bookId);
		
		return new ResponseEntity<>(updatedBook, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<ApiResponseMessage> deleteBook(@PathVariable int bookId){
		
		ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().message("Book delete successfully !!").success(true).status(HttpStatus.OK).build();
		
		bookService.deleteBook(bookId);
		
		return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getAllBook")
	public ResponseEntity<List<Book>> getAllBook(){
		
		List<Book> allBooks = bookService.getAllBook();
		
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/bookById/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId){
		
		Book bookById = bookService.getBookById(bookId);
		
		return new ResponseEntity<>(bookById, HttpStatus.OK);
		
	}
	
	@PutMapping("/likeBooks/{bookId}/user/{userId}")
	public ResponseEntity<Book> likeBooks(@PathVariable int bookId, @PathVariable int userId){
		
		User userById = userService.getUserById(userId);
		
		Book likeBooks = bookService.likeBook(bookId, userById);
		
		return new ResponseEntity<>(likeBooks, HttpStatus.OK);
		
	}
	

}
