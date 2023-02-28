package com.jllc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jllc.Entity.BookEntity;
import com.jllc.repository.BookRepository;

@Service
public class BookServiceImplementation implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookEntity> getBook() {
		return bookRepository.findAll();
	}

	@Override
	public void save(BookEntity bookEntity) {
		bookRepository.save(bookEntity);

	}

	@Override
	public void delete(BookEntity bookEntity) {
		bookRepository.delete(bookEntity);

	}

	@Override

	public BookEntity findById(int id) {

		return null;
	}

}
