package com.dikshit.foodkart.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
	String name;
	List<String> servicedPincodes;
	List <RestaurantRating> customerRatingsList;
	String foodItemName;

	public void setName(String name) {
		this.name = name;
	}

	int price;
	int quantity;
	int intRating;

	public String getName() {
		return name;
	}

	public void update_quantity(int quantity){
		this.quantity=quantity + this.quantity;
	}

	public void addRating(int rating,String comment){
		if(rating > 5 || rating <1){
			System.out.println("Invalid rating Entered, Try with valid rating from 1 to 5");
			return;
		}
		RestaurantRating customerRating=new RestaurantRating(rating,comment);
		customerRatingsList.add(customerRating);
		intRating=(intRating*(customerRatingsList.size()-1) + rating)/customerRatingsList.size();
		System.out.printf("New Rating for the restaurant is %d",intRating);
		System.out.println(customerRatingsList);
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public Restaurant(String name, List<String> servicedPincodes, String foodItemName, int price, int quantity) {
		this.name = name;
		this.servicedPincodes = servicedPincodes;
		this.foodItemName = foodItemName;
		this.price = price;
		this.quantity = quantity;
		this.customerRatingsList=new ArrayList<>();
	}

	public List<String> getServicedPincodes() {
		return servicedPincodes;
	}

	public boolean bookOrder(int qty) {
		if(this.quantity<qty){
			System.out.println("Ordered Quantity more than total stock");
			return false;
		}
		else{
			this.quantity=this.quantity-qty;
			System.out.println("Order Booked at Restaurant  " +  name);
			return true;
		}
	}

	public static int sortByRating(Restaurant r1,Restaurant r2){
		return r2.intRating - r1.intRating;
	}

	public static int sortByPrice(Restaurant r1,Restaurant r2){
		return r2.price - r1.price;
	}


	public void UpdateLocation(String newLocation) {
		String [] pincodes=newLocation.split("/");
		List<String > pinList=new ArrayList<>(Arrays.asList(pincodes));
		this.servicedPincodes=pinList;
	}
}
