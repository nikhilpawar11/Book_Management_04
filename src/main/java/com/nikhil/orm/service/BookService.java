package com.nikhil.orm.service;

import java.util.List;

import com.nikhil.orm.entity.Book;
import com.nikhil.orm.entity.User;

public interface BookService {
	
	public Book createBook(Book book, User user);
	
	public Book udateBook(Book book,int bookId);
	
	public void deleteBook(int bookId);
	
	public List<Book> getAllBook();
	
	public Book getBookById(int bookId);
	
	public Book likeBook(int bookId, User user);
	

}
