package com.dikshit.foodkart.model;

public class Student {
	int marks;
	String name;

	public Student(int marks, String name) {
		this.marks = marks;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static int compareTo(Student a, Student b){
		return  a.getName().length() - b.getName().length();
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student{" +
				"marks=" + marks +
				", name='" + name + '\'' +
				'}';
	}
}
