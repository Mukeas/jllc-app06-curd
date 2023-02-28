package com.jllc.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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

import com.jllc.Entity.BookEntity;
import com.jllc.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	private static Logger logger = Logger.getLogger("console");

	@Autowired(required = false)
	private BookService bookService;

	@GetMapping("/book")
	public ResponseEntity<?> getAll() {
		logger.info("----------------getAll-------------");

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<BookEntity> list = bookService.getBook();
		if (!list.isEmpty()) {
			logger.info("----------------IF-------------");
			map.put("Status", 1);
			map.put("data", list);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			logger.info("----------------ELSE-------------");
			map.clear();
			map.put("status", 0);
			map.put("Massage", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/save")
	public ResponseEntity<?> saveBook(@RequestBody BookEntity bookEntity) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		logger.info("-------------------saveBook----------------------");
		bookService.save(bookEntity);
		logger.info("-------------------service excuted----------------------");
		map.put("Status", 1);
		map.put("Massage", "Record is saved saccessfully!");

		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<?> betBookById(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			BookEntity bookEntity = bookService.findById(id);
			map.putIfAbsent("Status", 1);
			map.putIfAbsent("data", bookEntity);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("Status", 0);
			map.put("massage", "Data is not found!");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			BookEntity bookEntity = bookService.findById(id);
			bookService.delete(bookEntity);
			map.putIfAbsent("Status", 1);
			map.put("Massage", "Record deleted seccessfully!");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("Status", 0);
			map.put("Message", "Data not found!");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBookById(@PathVariable Integer id, @RequestBody BookEntity bookEntity) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			BookEntity bookEntity2 = bookService.findById(id);
			bookEntity2.setBookName(bookEntity.getBookName());
			bookEntity2.setBookAuther(bookEntity.getBookAuther());
			bookEntity2.setBookPrice(bookEntity.getBookPrice());
			bookService.save(bookEntity2);
			map.putIfAbsent("Status", 1);
			map.put("data", bookService.findById(id));
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("Status", 0);
			map.put("massage", "Data is not found!");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
}
