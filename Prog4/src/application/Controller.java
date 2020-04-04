package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller implements Initializable{
	
	@FXML
	private TextArea display;
	@FXML
	private ComboBox<String> pizzas;
	@FXML
	private ComboBox<String> sizes;
	@FXML
	private ImageView pizzaPhoto;
	@FXML
	private Button addTops;
	@FXML
	private Button removeTops;
	@FXML
	private Button clearTops;
	@FXML
	private ListView<String> allTops;
	@FXML
	private ListView<String> selectedTops;
	@FXML
	private Button addToOrder;
	@FXML
	private Button showOrder;
	final private String[] toppings = {"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra cheese", "Black olives" + 
			"Green peppers", "Pineapple", "Spinach"};
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items = FXCollections.observableArrayList("Build Your Own", "Deluxe", "Hawaiian");
		pizzas.getItems().addAll(items);
	}
	
	public void changePhoto() {
		display.appendText(pizzas.getValue()+"\n");
		if(pizzas.getValue().equals("BYO")) {
			Image photo = new Image("..\\..\\Cheese.jpg");
			pizzaPhoto.setImage(photo);
		}
		else if(pizzas.getValue().equals("Deluxe")) {
			Image photo = new Image("..\\..\\Deluxe.jpg");
			pizzaPhoto.setImage(photo);
		}
		else {
			Image photo = new Image("..\\..\\Hawaiian.jpg");
			pizzaPhoto.setImage(photo);
		}
	}
	
	
	
	
	
}
