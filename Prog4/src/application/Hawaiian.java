package application;

import java.util.ArrayList;

public class Hawaiian extends Pizza {
	private int price;
	public Hawaiian(String style, String size) {
		super(style, size);
		this.style = style;
		this.size = size;
		this.price = pizzaPrice();
	}
	
	public Hawaiian(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
		this.style = style;
		this.size = size;
		this.toppings = toppings;
		this.price = pizzaPrice();
	}

	@Override
	public int pizzaPrice() {
		final int SMALL = 8;
		final int MEDIUM = 10;
		final int LARGE = 12;
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
