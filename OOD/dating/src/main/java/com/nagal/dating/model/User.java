package com.nagal.dating.model;


public class User {
	int userid;
	String name;
	int xCoordinates;
	int yCoordinates;
	int age;
	Gender gender;

	@Override
	public String toString() {
		return "User{" +
				"userid=" + userid +
				", name='" + name + '\'' +
				", xCoordinates=" + xCoordinates +
				", yCoordinates=" + yCoordinates +
				", age=" + age +
				", gender=" + gender +
				'}';
	}

	public String getName() {
		return name;
	}

	public User(String name, int xCoordinates, int yCoordinates, int age, Gender gender) {
		this.name = name;
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;
		this.age = age;
		this.gender = gender;
		this.userid= IDgenerator.getID();
	}

	public static int diffScore(User a, User b){
		int totalScore=0;
		int genderScore = (a.gender != b.gender ? 1000 : 0);
		int proximityScore=  (int) (Math.pow(a.xCoordinates-b.xCoordinates,2) + Math.pow(a.yCoordinates-b.yCoordinates,2));
		proximityScore= (int) (100/ ( Math.sqrt(proximityScore)==0 ? 1 :  Math.sqrt(proximityScore)   )  )  ;
		int ageScore=(int) 100/(Math.abs(a.age-b.age) == 0 ? 1 : Math.abs(a.age-b.age))  ;
		totalScore=genderScore + proximityScore + ageScore;
		return totalScore;
	}

}
