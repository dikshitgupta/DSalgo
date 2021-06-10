package com.nagal.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {

	private String id;
	private String name;
	private String email;
	private String mobile;

}
