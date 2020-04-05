package application;

import java.util.ArrayList;

public class Deluxe extends Pizza {
	private int price;
	public Deluxe(String style, String size) {
		super(style, size);
		this.style = style;
		this.size = size;
		this.price = pizzaPrice();
	}
	public Deluxe(String style, String size, ArrayList<String> toppings) { 
		super(style, size, toppings);
		this.style = style;
		this.size = size;
		this.toppings = toppings;
		this.price = pizzaPrice();
	}
	@Override
	public int pizzaPrice() {
		final int SMALL = 14;
		final int MEDIUM = 16;
		final int LARGE = 18;
		if(size.equals("Small")){
			return SMALL;
		}
		else if(size.equals("Medium")){
			return MEDIUM;
		}
		return LARGE;
	}
	@Override
	public String toString() {
		return this.style + ", "+ this.size+ ", "
				+ "with these toppings: "+ toppings.toString() + ", and it costs this much $"+ this.price;
	}
}
