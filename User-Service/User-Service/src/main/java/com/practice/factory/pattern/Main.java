package com.practice.factory.pattern;

public class Main {
	
	public static void main(String [] args) {
		HotDrink drink=HotDrinkFactory.getDrink("Tea");
		drink.prepare();
	}

}
