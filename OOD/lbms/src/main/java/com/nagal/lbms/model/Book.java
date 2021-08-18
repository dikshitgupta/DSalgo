package com.nagal.lbms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Book {

	private String bookId;
	private String title;
	private List<String> authors;
	private List<String> publishers;

}
