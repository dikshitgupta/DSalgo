package com.dikshit.foodkart.service;

import com.dikshit.foodkart.model.Gender;
import com.dikshit.foodkart.model.Restaurant;
import com.dikshit.foodkart.model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.sort;

public class RestaurantService {

	List<User> userList;
	List<Restaurant> restaurantList;
	User activeUser;
	HashMap<String,User> phoneUser; // hashmap maps PhoneNumber to user
	HashMap<Integer,User> userIdUser; // hashmap maps userId to user.
	HashMap<String,Restaurant> nameRestaurantMapping; // restaurant names to restaurants

	public RestaurantService() {
		this.userList = new ArrayList<>();
		this.restaurantList = new ArrayList<>();
		this.phoneUser = new HashMap<>();
		this.userIdUser = new HashMap<>();
		this.nameRestaurantMapping = new HashMap<>();
	}

	public void register_user(String name, String gender, String phoneNumber, String pinCode){
		Gender eGender= gender.equals("M") ? Gender.M : Gender.F;
		User user=new User(name,eGender,phoneNumber,pinCode);
		userList.add(user);
		phoneUser.put(phoneNumber,user);
		userIdUser.put(user.getUserId(),user);
	}

	public void login_user(String phoneNumber){
		User user=phoneUser.get(phoneNumber);
		activeUser=user;
	}

	public void update_quantity(String restaurantName,int quantity){
		Restaurant restaurant=nameRestaurantMapping.get(restaurantName);
		restaurant.update_quantity(quantity);
	}

	public void register_restaurant(String restaurantName, String pincodeString, String foodItemName,int foodItemPrice, int quantity){
		String [] pincodes=pincodeString.split("/");
		List<String > pinList=new ArrayList<>(Arrays.asList(pincodes));
		Restaurant restaurant=new Restaurant(restaurantName,pinList,foodItemName,foodItemPrice,quantity);
		restaurantList.add(restaurant);
		nameRestaurantMapping.put(restaurant.getName(),restaurant);
	}

	public void rate_restaurant(String restaurantName,int rating,String comment){
		Restaurant restaurant=nameRestaurantMapping.get(restaurantName);
		restaurant.addRating(rating,comment);
	}

	public boolean place_order(String restaurantName,int quantity){
		if(!nameRestaurantMapping.containsKey(restaurantName)) {
			System.out.println("Restaurant name is wrong try with correct name");
			return false;
		}
		Restaurant restaurant=nameRestaurantMapping.get(restaurantName);
		return restaurant.bookOrder(quantity);
	}

	public void update_location(String restaurantName,String newLocation){
		if(!nameRestaurantMapping.containsKey(restaurantName)) {
			System.out.println("Restaurant name is wrong try with correct name");
			return;
		}
		Restaurant restaurant=nameRestaurantMapping.get(restaurantName);
		restaurant.UpdateLocation(newLocation);

	}


	public void showRestaurant(String flag){
		String pincode=activeUser.getPincode();
		if(flag.equals("rating")){
			sort(restaurantList,Restaurant::sortByRating);
			for(Restaurant restaurant : restaurantList){
				if(restaurant.getServicedPincodes().contains(pincode)){
					System.out.printf("Restaurant Name: %s  Dish is %s \n",restaurant.getName(), restaurant.getFoodItemName());
				}
			}
		}
		else {
			sort(restaurantList, Restaurant::sortByPrice);
			for (Restaurant restaurant : restaurantList) {
				if (restaurant.getServicedPincodes().contains(pincode)) {
					System.out.printf("Restaurant Name: %s  Dish is %s \n",restaurant.getName(), restaurant.getFoodItemName());
				}
			}
		}
	}

}
