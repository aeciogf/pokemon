package application;

import javax.swing.JOptionPane;

import controller.Cart;
import controller.Vitrine;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pokemon;

public class VitrineApp extends Application {
	
	private AnchorPane pane;
	private TextField txSearch;
	private TableView<ItemsProperty> tbVitrine;
	private TableColumn<ItemsProperty, String> columnItem;
	private TableColumn<ItemsProperty, Double> columnPrize;
	private static ObservableList<ItemsProperty> listItems = FXCollections.observableArrayList();
	private static Cart cart;
	private static Stage stage;


	public void initComponents(){
		this.pane = new AnchorPane();
		this.pane.setPrefSize(800, 600);
		this.pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100%"
							+ " 100%, silver 0%, silver 100%)");
		
		this.txSearch = new TextField();
		this.txSearch.setPromptText("Busca por");
		this.tbVitrine = new TableView<ItemsProperty>();
		this.tbVitrine.setPrefSize(600, 550);
		
		this.columnItem = new TableColumn<ItemsProperty, String>("Pokemon");
		this.columnItem.setCellValueFactory(new PropertyValueFactory<ItemsProperty, String>("Name"));
		
		
		this.columnPrize = new TableColumn<ItemsProperty, Double>("Forca");
		this.columnPrize.setCellValueFactory(new PropertyValueFactory<ItemsProperty, Double>("Strenght"));
		
		this.tbVitrine.getColumns().addAll(columnItem, columnPrize);
		
		this.pane.getChildren().addAll(txSearch, tbVitrine);
		
		this.cart = new Cart();
		
		initItems();
	}
	
	public void initItems(){
		Vitrine vitrine = new Vitrine();
		vitrine.addToCart(new Pokemon("Pikachu", 12.00), 
						  new Pokemon("Charmander", 19.00),
						  new Pokemon("Zubat", 9.00),
						  new Pokemon("Ratata", 11.00),
						  new Pokemon("Pidgey", 10.00));
		
		for (Pokemon p: vitrine.getFromCart())
			listItems.add(new ItemsProperty(p.getName(), p.getStrength()));
		
		this.tbVitrine.setItems(listItems);
	}
	
	private ObservableList<ItemsProperty> findItems(){
		ObservableList<ItemsProperty> foundItems = FXCollections.observableArrayList();
		for (ItemsProperty items: this.listItems)
			if (items.getName().contains(this.txSearch.getText()))
				foundItems.add(items);
		return foundItems;
	}
	
	public void initListeners(){
		this.txSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event){
				if (!txSearch.getText().equals(""))
					tbVitrine.setItems(findItems());
				else 
					tbVitrine.setItems(listItems);
			}
		});
	}
	
	@Override
	public void start(Stage stage) {
		try {
			initComponents();
			initListeners();
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Login");
			stage.show();
			// initLayout();
			VitrineApp.stage = stage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

