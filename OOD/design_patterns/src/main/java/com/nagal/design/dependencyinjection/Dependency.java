package com.nagal.design.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

class Employee{
	String name;
	Integer age;
	Address address;

	public Employee(Address address) {   // constructor injection
		this.address = address;
	}

	void setAddress(Address ad){  // seetter injection
		this.address=ad;
	}
}

@Component
class Address{

	public void Hello(){
		System.out.println("hello adress");
	}
}

// IOC container Manages beans.
// beans create a instance of address;
// give

@Component("fooFormatter")
class FooFormatter {
	public String format() {
		return "foo";
	}
}


@Component
public class Dependency {
	public static void main(String[] args) {
//
//	@Autowired
//	Address address;
//
//	System.out.println(address.Hello());
	}
}

