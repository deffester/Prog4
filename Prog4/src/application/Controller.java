package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
	public static ArrayList<Pizza> orderList = new ArrayList<Pizza>();
	public ObservableList<Pizza> Piz  = FXCollections.observableArrayList();
	private secondController con2;
	private Parent root;
	final private String[] toppings = {"Pepperoni", "Mushrooms", "Onions", "Sausage", "Bacon", "Extra cheese", "Black olives",
			"Green peppers", "Pineapple", "Spinach", "Beef", "Ham", "Chicken"};
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> pizzaItems = FXCollections.observableArrayList("Build Your Own", "Deluxe", "Hawaiian");
		pizzas.getItems().addAll(pizzaItems);
		ObservableList<String> sizeItems = FXCollections.observableArrayList("Large", "Medium", "Small");
		sizes.getItems().addAll(sizeItems);
		ObservableList<String> toppingItems = FXCollections.observableArrayList(toppings);
		toppingItems = toppingItems.sorted();
		allTops.getItems().addAll(toppingItems);
	}
	
	public void menuSettings() {
		if(pizzas.getValue().equals("Build Your Own")) {
			clearToppings();
			ObservableList<String> toppingItems = FXCollections.observableArrayList(toppings);
			toppingItems = toppingItems.sorted();
			allTops.getItems().addAll(toppingItems);
			Image photo = new Image(getClass().getResource("Cheese.jpg").toExternalForm());
			pizzaPhoto.setImage(photo);
		}
		else if(pizzas.getValue().equals("Deluxe")) {
			onSwitchDel();
			Image photo = new Image(getClass().getResource("Deluxe.jpg").toExternalForm());
			pizzaPhoto.setImage(photo);
		}
		else {
			onSwitchHaw();
			Image photo = new Image(getClass().getResource("Hawaiian.jpg").toExternalForm());
			pizzaPhoto.setImage(photo);
		}
	}
	
	public void addToOrder() {
		if(pizzas.getValue().equals("Build Your Own")){
			BuildYourOwn BYO = null;
			if(selectedTops.getItems().size() > 0 && selectedTops.getItems().size() < 7) {
				BYO = new BuildYourOwn(pizzas.getValue(), sizes.getValue(), 
						new ArrayList(selectedTops.getItems()));
			}
			else{
				display.appendText("ERROR: Please make sure you've selected at least 1 "
						+ "topping and have no more than 6\n");
				return;
			}
			orderList.add(BYO);
			display.appendText("SUCCESS your custom pizza: "+BYO.toString()+". was added to the order!!\n");
		}
		else if(pizzas.getValue().equals("Deluxe")){
			Deluxe Del = new Deluxe(pizzas.getValue(), sizes.getValue(), new ArrayList(selectedTops.getItems()));
			orderList.add(Del);
			display.appendText("SUCCESS your Deluxe pizza: "+ Del.toString()+".  was added to the order!!\n");
		}
		else{
			Hawaiian Haw = new Hawaiian(pizzas.getValue(), sizes.getValue(), new ArrayList(selectedTops.getItems()));
			orderList.add(Haw);
			display.appendText("SUCCESS your Hawaiian pizza: "+Haw.toString()+".  was added to the order!!\n");
		}
	}
	
	public void displayOrder(ActionEvent event) throws IOException {	
		if(orderList.size() > 0){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
			root = (Parent) loader.load();
			con2 = loader.getController();
			con2.getList(orderList);
			Scene orderDisplay = new Scene(root);
			Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
			window.setScene(orderDisplay);
			window.show();
		}
		else {
			display.appendText("ERROR: You haven't added a pizza yet\n");
		}
	}
	
	public void addTopping(){
		if(!pizzas.getValue().equals("Build Your Own")) {
			display.appendText("ERROR: You can't customize the Hawaiian or Deluxe pizzas\n");
			return;
		}
		if(allTops.getItems().size() == 0) {
			display.appendText("ERROR: You can't add anymore toppings, the list is empty\n");
			return;
		}
		if(selectedTops.getItems().size() == 6) {
			display.appendText("ERROR: You can't add anymore toppings\n");
			return;
		}
		if(allTops.getSelectionModel().getSelectedItems() != null) {
			ObservableList<String> items = allTops.getSelectionModel().getSelectedItems();
			selectedTops.getItems().addAll(items);
			allTops.getItems().removeAll(items); //remove item from the listview
		}
		else {
			display.appendText("You haven't selected a topping yet\n");
		}
	}
	
	public void removeTopping() {
		if(!pizzas.getValue().equals("Build Your Own")) {
			display.appendText("ERROR: You can't customize the Hawaiian or Deluxe pizzas\n");
			return;
		}
		if(selectedTops.getItems().size() == 0) {
			display.appendText("ERROR: You can't remove anymore toppings, the list is empty\n");
			return;
		}
		if(selectedTops.getSelectionModel().getSelectedItems() != null) {
			ObservableList<String> items = selectedTops.getSelectionModel().getSelectedItems();
			allTops.getItems().addAll(items);
			selectedTops.getItems().removeAll(items); //remove item from the listview
		}
		else {
			display.appendText("You haven't selected a topping yet\n");
		}
		ObservableList<String> toppingItems = FXCollections.observableArrayList(allTops.getItems());
		toppingItems = toppingItems.sorted();
		allTops.getItems().clear();
		allTops.getItems().addAll(toppingItems);
	}
	
	public void clearToppings() {		
		if(!pizzas.getValue().equals("Build Your Own")) {
			display.appendText("ERROR: You can't customize the Hawaiian or Deluxe pizzas\n");
			return;
		}
		if(selectedTops.getItems().size() > 0) {
		ObservableList<String> items = selectedTops.getItems();
		allTops.getItems().addAll(items);
		ObservableList<String> toppingItems = FXCollections.observableArrayList(allTops.getItems());
		toppingItems = toppingItems.sorted();
		allTops.getItems().clear();
		allTops.getItems().addAll(toppingItems);
		selectedTops.getItems().clear();
		}
		else {
			display.appendText("The list is already empty\n");
		}
	}
	
	private void onSwitchHaw() {
		if(selectedTops.getItems().size() > 0) {
			ObservableList<String> items = selectedTops.getItems();
			allTops.getItems().addAll(items);
			ObservableList<String> toppingItems = FXCollections.observableArrayList(allTops.getItems());
			toppingItems = toppingItems.sorted();
			allTops.getItems().clear();
			allTops.getItems().addAll(toppingItems);
			selectedTops.getItems().clear();
			}
		ObservableList<String> items = FXCollections.observableArrayList("Pineapple", "Ham");
		selectedTops.getItems().addAll(items);
		allTops.getItems().clear(); //remove item from the listview
	}
	
	private void onSwitchDel() {
		if(selectedTops.getItems().size() > 0) {
			ObservableList<String> items = selectedTops.getItems();
			allTops.getItems().addAll(items);
			ObservableList<String> toppingItems = FXCollections.observableArrayList(allTops.getItems());
			toppingItems = toppingItems.sorted();
			allTops.getItems().clear();
			allTops.getItems().addAll(toppingItems);
			selectedTops.getItems().clear();
			}
		ObservableList<String> items = FXCollections.observableArrayList("Pepperoni", "Mushroom", "Onion", "Sausage", "Green peppers");
		selectedTops.getItems().addAll(items);
		allTops.getItems().clear(); //remove item from the listview
	}

	public void getList(ArrayList<Pizza> order) {
		orderList = order;
	}

}
