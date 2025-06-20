package com.practice.factory.pattern;

public class HotDrinkFactory {

	public static HotDrink getDrink(String type) {
		if ("Tea".equalsIgnoreCase(type)) {
			return new Tea();
		} else if ("Coffee".equalsIgnoreCase(type)) {
			return new Coffee();
		}
		return null;
	}

}
