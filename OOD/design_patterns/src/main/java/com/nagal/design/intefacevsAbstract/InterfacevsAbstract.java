package com.nagal.design.intefacevsAbstract;

import lombok.AllArgsConstructor;

import java.net.spi.URLStreamHandlerProvider;
import java.util.ArrayList;
import java.util.Arrays;

//class Shape{
//	void draw(){
//		System.out.println("draw method in shape");
//	}
//}

//abstract class Shape{
//	Shape(){
//		System.out.println("constructor of abstract class");
//	}
//	abstract void draw();
//}

interface Shape{
	void draw();
}

/*
class Circle extends Shape{
	void draw(){
		System.out.println("draw method in Circle");
	}
}

class Rectange extends Shape{    // Object to Objcet inheritance
	void draw(){
		System.out.println("draw method in Rectangle");
	}
}
*/

class Circle implements Shape{
	public void draw(){
		System.out.println("draw method in Circle");
	}
}

class Rectange implements Shape{    // Object to Objcet inheritance
	@Override
	public void draw(){
		System.out.println("draw method in Rectangle");
	}
}

@AllArgsConstructor
class Car{
	String name;
	int price;

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}

	public static int sorter(Car a, Car b){
		return a.price-b.price;
	}
}


public class InterfacevsAbstract {

	public static void main(String[] args) {

		Car a=new Car("a",100);
		Car b=new Car("b",50000);
		Car c=new Car("c",400);
		Car d=new Car("d",1000);

		ArrayList<Car> arr=new ArrayList<>(Arrays.asList(a,b,c,d));
//		Arrays.sort(arr,Car::sorter);
		arr.sort(Car::sorter);     // collections interface java
		System.out.println(arr);

		Car [] cars=new Car[]{a,b,c,d};
		Arrays.sort(cars,Car::sorter);
		System.out.println(cars);

//		Shape s;
//		s=new Circle();   // polymorphic statement
//		s.draw();
//
//		s=new Rectange();
//		s.draw();


	}
}
