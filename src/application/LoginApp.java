package application;
	
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class LoginApp extends Application {
	
	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txPassword;
	private Button btEntrar, btSair;
	private static Stage stage;
	
	public void initComponents(){
		
		this.pane = new AnchorPane();
		this.pane.setPrefSize(400, 300);
		this.pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
		
		this.txLogin = new TextField("Digite aqui seu login");
		this.txPassword = new PasswordField();
		this.txPassword.setPromptText("Digite sua senha");
		
		this.btEntrar = new Button("Entrar");
		this.btSair = new Button("Sair");
		
		this.pane.getChildren().addAll(txLogin, txPassword, btEntrar, btSair);
	}
	
	public void initLayout(){
		this.btEntrar.setLayoutX((this.pane.getWidth() - this.btEntrar.getWidth())/2);
		this.btEntrar.setLayoutY(150);
		
		this.btSair.setLayoutX((this.pane.getWidth() - this.btSair.getWidth())/2);
		this.btSair.setLayoutY(200);
		
		this.txLogin.setLayoutX((this.pane.getWidth() - this.txLogin.getWidth())/2);
		this.txLogin.setLayoutY(50);
		
		this.txPassword.setLayoutX((this.pane.getWidth() - this.txPassword.getWidth())/2);
		this.txPassword.setLayoutY(100);
	}
	
	public void initListeners(){
		this.btSair.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				fecharApp();
			}
		});
		
		this.btEntrar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				logarApp();
			}
		});
	}
	
	public void fecharApp(){
		System.out.println("Até a próxima.");
		System.exit(0);
	}
	
	public void logarApp(){
		if (txLogin.getText().equals("admin") && txPassword.getText().equals("123"))
			System.out.println("Login realizado");
		else
			JOptionPane.showMessageDialog(null, "Credenciais inválidas", "Erro", JOptionPane.ERROR_MESSAGE);
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
			initLayout();
			LoginApp.stage = stage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
