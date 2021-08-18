package com.nagal.design.solid;

public class InterfaceSegregation {


}

/*
Dependency of one class on another should depend on Smallest possible interface.
*/

/*

Animal:
	feed()
	groom()

Dog implements animal:
	feed()
	groom()

Tiger implements animal()
	feed()
	groom()  // we have to add dummy implementation

 */