package com.jllc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jllc.Entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
