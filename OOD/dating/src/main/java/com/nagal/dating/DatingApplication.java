package com.nagal.dating;

import com.nagal.dating.Service.Tinder;
import com.nagal.dating.model.Gender;
import com.nagal.dating.model.User;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static com.nagal.dating.model.Gender.Female;
import static com.nagal.dating.model.Gender.Male;

public class DatingApplication {

	public static void main(String[] args) {

		Tinder tinder=new Tinder();

		tinder.create_account("user_A",  2, 3, 23, Male);
		tinder.create_account("user_B",  3, 4, 45, Female);
		tinder.create_account("user_C",  4, 6, 32, Female);
		tinder.create_account("user_D",  7, 8, 23, Male);
		tinder.create_account("user_E",  8, 12, 23, Female);

//		tinder.potential_match("user_A");
		tinder.like("user_A","user_B");
		tinder.like("user_A","user_C");
//		tinder.potential_match("user_B");
//
		tinder.like("user_B","user_A");

		tinder.showMatches("user_A");

		tinder.showAllMatches();

		tinder.like("user_E","user_D");

//		tinder.potential_match("user_D");

		tinder.like("user_D","user_E");

		tinder.like("user_C","user_A");

		tinder.showAllMatches();




	}
}


//	List<Person> persons = new ArrayList<>(Arrays.asList(
//			new Person("John", 15),
//			new Person("Sam", 25),
//			new Person("Will", 20),
//			new Person("Dan", 20),
//			new Person("Joe", 10)
//	));
//
//        Collections.sort(persons, new Comparator<Person>() {
//@Override
//public int compare(Person p1, Person p2) {
//		return p1.getAge() - p2.getAge();
//		}
//		});
//   Returns in ascending order.