package com.kausha.design.onlineReservation;

import java.util.Date;
import java.util.List;

public class Restaurant {
	String restaurantId;
	
	// Filter restaurants to show popular restaurants in teh city of user.
	String city;
	int pincode;
	
	// To be used to show nearby restaurants in 1 km range of user.
	double latitude;
	double longitude;
	
	List<String> contactNumbers;
	List<FoodType> foodTypes;
	List<Table>  tables;
	Date openingTime;
	Date closingTime;
	
	Menu menu;
	
	// Helpful while displaying restaurants in recommendations and search.
	// A rough average rating is good enough in most cases.
	float averageRating;
}
