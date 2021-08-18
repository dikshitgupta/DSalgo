package com.nagal.design.designPatterns.proxy;

// placeholder for another object to control access
/*
	Remote proxy

Virtual proxy that created sxpensive objects on demand.
e.g bookparser creating object is expensive but the methods are cheap.
you can create a method that will create bookparses object only when it need to call it's methods.

 */

public class ProxyDriver {

	public static void main(String [] args){

		ExpensiveObject object=new ExpensiveObjectProxy();
		object.process();
		object.process();
//		object.process();
//		object.process();

	}
}


//	To stand in place of an object that may be expensive to create and delay the object's creation till it is accessed
//
//		To cache queries or results from subject for clients