package com.nagal.design.proxy;

public class ProxyDriver {

	public static void main(String [] args){

		ExpensiveObject object=new ExpensiveObjectProxy();
		object.process();
		object.process();
		object.process();
		object.process();
	}

}
