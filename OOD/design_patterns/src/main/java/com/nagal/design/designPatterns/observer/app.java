package com.nagal.design.designPatterns.observer;

public class app {

	public static void main(String[] args) {
		Channel abc=new Channel();
		Subscriber s1=new Subscriber("Ragi");
		Subscriber s2=new Subscriber("Akash");
		Subscriber s3=new Subscriber("Shivani");
		Subscriber s4=new Subscriber("Sakshi");

		abc.subscribe(s1);
		abc.subscribe(s2);
		abc.subscribe(s3);
		abc.subscribe(s4);

		s1.subscribeChannel(abc);
		s2.subscribeChannel(abc);
		s3.subscribeChannel(abc);
		s4.subscribeChannel(abc);

		abc.upload("Porier vs Conor");

	}
}
