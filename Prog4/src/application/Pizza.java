package application;

import java.util.*;

public abstract class Pizza {

	protected String style;
	protected String size;
	protected ArrayList<String> toppings;
	public Pizza(String style, String size, ArrayList<String> toppings) { 
		style = this.style;
		size = this.size;
		toppings = this.toppings;
	}
	public String getStyle() {
		return style;
	}
	public String getSize() {
		return size;
	}
	public int getPrice() {
		return pizzaPrice();
	}
	public ArrayList<String> getToppings() {
		return toppings;
	}
	public Pizza(String style, String size) { 
		style = this.style;
		size = this.size;
	}
	public abstract int pizzaPrice();
	
	public String toString() {
		return style + " "+ size+ " "+ toppings.toString();
	}
}
