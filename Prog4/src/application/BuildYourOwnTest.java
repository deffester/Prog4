package application;

import java.util.*;
import static org.junit.Assert.*;

public class BuildYourOwnTest{

	public void testPizzaPrice() {

			ArrayList<String> Toppings = new ArrayList<String>();
			Toppings.add("Ham");

			Pizza p = new BuildYourOwn("Build your own", "Small", Toppings);

			assertEquals( 7 , p.pizzaPrice() );

			p = new BuildYourOwn("Build your own", "Medium", Toppings);

			assertEquals( 9 , p.pizzaPrice() );

			p = new BuildYourOwn("Build your own", "Large", Toppings);

			assertEquals( 11 , p.pizzaPrice() );

			Toppings.add("Mushrooms");
			Toppings.add("Pepperoni");
			Toppings.add("Swiss Cheese");


			p = new BuildYourOwn("Build your own", "Small", Toppings);

			assertEquals( 13 , p.pizzaPrice() );

			p = new BuildYourOwn("Build your own", "Medium", Toppings);

			assertEquals( 15 , p.pizzaPrice() );

			p = new BuildYourOwn("Build your own", "Large", Toppings);
	
			assertEquals( 17 , p.pizzaPrice() );

			Toppings.add("Tomatoes");
			Toppings.add("Broccoli");

			p = new BuildYourOwn("Build your own", "Small", Toppings);

			assertEquals( 17 , p.pizzaPrice() );

			p = new BuildYourOwn("Build your own", "Medium", Toppings);

			assertEquals( 19 , p.pizzaPrice() );

			p = new BuildYourOwn("Build your own", "Large", Toppings);

			assertEquals( 21 , p.pizzaPrice() );
		}
	}

