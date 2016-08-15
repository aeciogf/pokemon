package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pokemon;

public class CarrinhoApp extends Application {
	private AnchorPane pane;
	private TableView<Pokemon> tbCart;
	private TableColumn<Pokemon, String> columnItem;
	private TableColumn<Pokemon, Double> columnPrize;
	private Button btDelete, btBackToVitrine, btConfirm;
	private static ObservableList<Pokemon> listItems = FXCollections.observableArrayList();
	private static Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
