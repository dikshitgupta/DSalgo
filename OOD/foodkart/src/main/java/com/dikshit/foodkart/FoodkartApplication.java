package com.dikshit.foodkart;

import com.dikshit.foodkart.model.Restaurant;
import com.dikshit.foodkart.model.Student;
import com.dikshit.foodkart.service.RestaurantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FoodkartApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FoodkartApplication.class, args);
		RestaurantService restaurantService=new RestaurantService();
		restaurantService.register_user("Pralove", "M", "phoneNumber-1", "HSR");
		restaurantService.register_user("Nitesh", "M", "phoneNumber-2", "BTM");
		restaurantService.register_user("Vatsal", "M",  "phoneNumber-3", "BTM");

		restaurantService.login_user("phoneNumber-1");
		restaurantService.register_restaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5);
		restaurantService.register_restaurant("Food Court-2", "BTM", "Burger", 120, 3);

		restaurantService.login_user("phoneNumber-2");
		restaurantService.register_restaurant("Food Court-3", "HSR", "SI Thali", 150, 1);

		restaurantService.login_user("phoneNumber-3");
		restaurantService.showRestaurant("price");

		restaurantService.place_order("Food Court-1",2);

		restaurantService.place_order("Food Court-2",7);

		restaurantService.rate_restaurant("Food Court-2",3,"good Burger");
		restaurantService.rate_restaurant("Food Court-1",3,"good North food");

		restaurantService.login_user("phoneNumber-1");

		restaurantService.update_quantity("Food Court-2",5);

		restaurantService.update_location("Food Court-2","BTM/HSR");

		restaurantService.showRestaurant("price");


//		Student dikshit = new Student(1, "di");
//		Student kartik = new Student(23, "kti");
//		Student vineet = new Student(2, "vineet");
//
//		Student[] students = new Student[]{kartik, vineet, dikshit};
//
//		Arrays.sort(students, Student::compareTo);
//
//		for (Student student : students) {
//			System.out.println(student);
//		}

	}
}
