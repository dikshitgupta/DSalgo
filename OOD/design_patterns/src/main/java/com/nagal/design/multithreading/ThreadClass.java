package com.nagal.design.multithreading;

class MyThread1 extends Thread{
	@Override
	public void run() {
		int a=1000;
		while (a--!=0)
			System.out.println("thread 1 running");
	}
}

class MyThread2 extends Thread{
	@Override
	public void run() {
		int a=1000;
		while (a--!=0)
			System.out.println("second thread running");
	}
}

public class ThreadClass {
	public static void main(String[] args) {
	MyThread1 t1=new MyThread1();
	MyThread2 t2=new MyThread2();
	t1.start();
	t2.start();
	}
}

