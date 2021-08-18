package com.nagal.lbms.service;

import com.nagal.lbms.model.Book;
import com.nagal.lbms.model.BookItem;
import com.nagal.lbms.model.User;

import java.util.*;

public class Library {
	private String libraryID;
	private int numberOfRacks;
	BookItem racks[];   // bid in each rack, there are numberOfRacks;
	HashMap < User, LinkedList <BookItem> > issuedBooks;   // user to bid;
	List <BookItem> books;
	HashMap <String,Integer> booksRack;  // Map bid to it's rack number for O1 access;


	public Library(String libraryID, int numberOfRacks) {
		this.libraryID = libraryID;
		this.numberOfRacks = numberOfRacks;
		this.racks = new BookItem[numberOfRacks];
		this.issuedBooks = new HashMap < User, LinkedList <BookItem> >();
		this.books = new ArrayList<BookItem>();
		this.booksRack = new HashMap<String, Integer>();
	}

	boolean addBooks(String bookid, String title, List<String> authors, List <String> publishers, String[] bids){
		Book book=new Book(bookid,title,authors,publishers);
		for(String bid: bids){
			BookItem bookItem=new BookItem(bid,book);
			books.add(bookItem);
			return addBookToRack(bookItem);
		}
		return true;
	}

	boolean addBookToRack(BookItem bookItem){
		for(int rackNumber=0;rackNumber<racks.length;rackNumber++){
			if(racks[rackNumber]==null){
				racks[rackNumber]=bookItem;
				booksRack.put(bookItem.getBid(),rackNumber);
				return true;
			}
		}
		return false;
	}

	boolean removeBook(String bid) {
		if (booksRack.containsKey(bid)) {
			int rackIdx = booksRack.get(bid);
			racks[rackIdx]=null;
			return true;
		}
		else return false;
	}

	boolean borrowBook(String bid, String userId, Date date){
		int rackIdx = booksRack.get(bid);
		BookItem bookitem=racks[rackIdx];

		LinkedList<BookItem> bookForPerson=issuedBooks.get(new User(userId));
		if(bookForPerson==null){
			bookForPerson=new LinkedList<BookItem>();
			issuedBooks.put(new User(userId),bookForPerson);
		}
		issuedBooks.get(new User(userId)).add(bookitem);
		System.out.printf("Person %s is having total books as %d",userId,issuedBooks.get(new User(userId)).size());
		return removeBook(bid);
	}



}
