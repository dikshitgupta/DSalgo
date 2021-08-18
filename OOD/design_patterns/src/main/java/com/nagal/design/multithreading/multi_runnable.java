package com.nagal.design.multithreading;

 class thread1 implements Runnable{
	public void run() {
		int a = 500;
		while (a-- > 0) {
			System.out.println("first");
		}
	}
 }

class thread2 implements Runnable{
	public void run() {
		int a = 500;
		while (a-- > 0) {
			System.out.println("second");
		}
	}
}


public class multi_runnable {
	public static void main(String[] args) {

		thread1 t1=new thread1();
		thread2 t2=new thread2();

		Thread gun1=new Thread(t1);
		Thread gun2=new Thread(t2);

		gun1.start();
		gun2.start();

	}
}
