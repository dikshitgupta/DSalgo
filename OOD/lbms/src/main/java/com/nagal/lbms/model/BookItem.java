package com.nagal.lbms.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BookItem extends Book{

	private String barCode= UUID.randomUUID().toString();
	private Date issueDate;
	private String Bid;
	private int rackNumber;

	public BookItem(String bid,Book book) {
		super(book.getBookId(), book.getTitle(), book.getAuthors(), book.getPublishers());
		Bid = bid;
	}

}

