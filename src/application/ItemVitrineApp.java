package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pokemon;

public class ItemVitrineApp extends Application {

	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbStrengh, lbName;
	private Button btAddToCart;
	private static Stage stage;
	private static Pokemon pokemon;
	private static int index;
	private static String imgPokemons[];
	
	@Override
	public void start(Stage stage) throws Exception {
		
		initComponents();
		initListeners();
		Scene scene = new Scene(this.pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Detalhe");
		stage.show();
		ItemVitrineApp.stage = stage;
		initLayout();
		
		
	}

	private void initItems(){
		imgPokemons = new String [] {
			"http://im.ziffdavisinternational.com/t/ign_br/blogroll/p/pokemon-go/pokemon-go-developer-discuss-the-new-game-at-gdc_bnmm.1920.png",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR565wTyoGPtBdgGgjHExj1TU_PymvSOZvX9CnrHuVVU_eKMXGjp6ruRQ",
			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSB7muGqWJ_4Bv6ndAGFM8CqeTEoOmHNqmRjgU-bHPH4JMyIa-Wsv1ElZBu",
			"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ1eA-8HN3ev6Iwmu688IdzOLHriWyVI6zl-WYzAR3hTEYa1iyvEI0vOBqJOg",
			"http://vignette1.wikia.nocookie.net/pokemon/images/9/9c/016Pidgey_AG_anime.png/revision/latest?cb=20140912055118",
			
		};
	}
	
	public void initComponents() {
		this.pane = new AnchorPane();
		this.pane.setPrefSize(600, 400);
		
		initItems();
		
		this.imgItem = new ImageView(imgPokemons[index]);
		
		this.lbStrengh = new Label("Força: " + pokemon.getStrength());
		this.lbName = new Label("Nome: " + pokemon.getName());
		
		this.btAddToCart = new Button("Add ao carrinho");
		
		this.pane.getChildren().addAll(this.imgItem, this.lbName, this.lbStrengh, this.btAddToCart);
		
		
	}
	
	public static Stage getStage(){
		return stage;
	}

	public static void setPokemon(Pokemon pokemon){
		ItemVitrineApp.pokemon = pokemon;
	}
	
	public static void setIndex(int index){
		ItemVitrineApp.index = index;
	}
	
	public void initListeners() {
		
		
	}

	public void initLayout() {
		// TODO Auto-generated method stub
		
	}

}
