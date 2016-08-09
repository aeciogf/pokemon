package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemsProperty {

	private SimpleStringProperty nome;
	private SimpleDoubleProperty forca;
	
	public ItemsProperty(String nome, double forca){
		this.nome = new SimpleStringProperty(nome);
		this.forca = new SimpleDoubleProperty(forca);
		
	}

	public String getNome() {
		return this.nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public double getForca() {
		return this.forca.get();
	}

	public void setForca(double forca) {
		this.forca.set(forca);
	}
	
}