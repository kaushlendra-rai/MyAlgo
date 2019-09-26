package com.kausha.design.onlineReservation;

import java.util.List;
import java.util.Map;

public class Order {
	String orderId;
	Table table;
	User user;
	Map<Dish, Integer> dishes;
}
