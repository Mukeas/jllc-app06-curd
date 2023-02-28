package com.jllc.service;

import java.util.List;

import com.jllc.Entity.BookEntity;

public interface BookService {

	public List<BookEntity> getBook();

	public void save(BookEntity bookEntity);

	public void delete(BookEntity bookEntity);

	public BookEntity findById(int id);
}
