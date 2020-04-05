package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class secondController implements Initializable{

@FXML private Button back;
@FXML private Button clear;
@FXML private TextArea priceDisplay;
@FXML private TableView<Pizza> orderDisplay;
@FXML private TableColumn Style;
@FXML private TableColumn Size;
@FXML private TableColumn Toppings;
@FXML private TableColumn Price;
private Controller con1;
private static ArrayList<Pizza> orderList;
public ObservableList<Pizza> Piz = FXCollections.observableArrayList();

public secondController() throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
	Parent root = (Parent) loader.load();
	con1 = loader.getController();
}

@Override
public void initialize(URL location, ResourceBundle resources) {
	Style.setCellValueFactory(new PropertyValueFactory<Pizza, String>("style"));
	Size.setCellValueFactory(new PropertyValueFactory<Pizza, String>("size"));
	Toppings.setCellValueFactory(new PropertyValueFactory<Pizza, ArrayList<String>>("toppings"));
	Price.setCellValueFactory(new PropertyValueFactory<Pizza, Integer>("price"));
}
	public void getPizzas(ArrayList<Pizza> pizzas){
		Piz.addAll(pizzas);
		orderDisplay.getItems().addAll(Piz);	
	}
	
	public void clearList() {
		int empty = 0;
		orderDisplay.getItems().clear();
		orderList.clear();
		priceDisplay.clear();
		priceDisplay.appendText("$"+empty);
	}
	public void addPrice() {
		int tPrice = 0;
		for(int i = 0; i < orderDisplay.getItems().size(); i++) {
			tPrice += orderDisplay.getItems().get(i).pizzaPrice();
		}		
		priceDisplay.appendText("$"+tPrice);
	}
	
	public void getList(ArrayList<Pizza> order) {
		orderList = order;
		getPizzas(orderList);
		addPrice();
	}
	
	public void goBack(ActionEvent event) throws IOException{
		Parent view2 = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene orderDisplay = new Scene(view2);
		con1.getList(orderList);
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(orderDisplay);
		window.show();
	}
}
