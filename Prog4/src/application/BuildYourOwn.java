package application;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
	private int price;
	public BuildYourOwn(String style, String size) {
		super(style, size);
		this.style = style;
		this.size = size;
		this.price = pizzaPrice();
	}
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) { 
		super(style, size, toppings);
		this.style = style;
		this.size = size;
		this.toppings = toppings;
		this.price = pizzaPrice();
	}
	@Override
	public int pizzaPrice() {
		int price = 0;
		final int TPRICE = 2;
		final int SMALL = 5;
		final int MEDIUM = 7;
		final int LARGE = 9;
		if(size.equals("Small")){
			price = SMALL + (TPRICE*toppings.size());
			return price;
		}
		else if(size.equals("Medium")){
			price = MEDIUM + (TPRICE*toppings.size());
			return price;
		}
		price = LARGE + (TPRICE*toppings.size());
		return price;
	}
	@Override
	public String toString() {
		return this.style + ", "+ this.size+ ","
				+ " with these toppings: "+ toppings.toString() + ", and it costs this much $"+ this.price;
	}
}
