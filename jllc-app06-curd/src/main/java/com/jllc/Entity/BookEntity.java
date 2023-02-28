package com.jllc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_Details")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private int BookId;
	@Column(name = "BOOK_NAME")
	private String BookName;
	@Column(name = "BOOK_AUTHER")
	private String BookAuther;
	@Column(name = "BOOK_PRICE")
	private double BookPrice;

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookAuther() {
		return BookAuther;
	}

	public void setBookAuther(String bookAuther) {
		BookAuther = bookAuther;
	}

	public double getBookPrice() {
		return BookPrice;
	}

	public void setBookPrice(double bookPrice) {
		BookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "BookEntity [BookId=" + BookId + ", BookName=" + BookName + ", BookAuther=" + BookAuther + ", BookPrice="
				+ BookPrice + "]";
	}

}
