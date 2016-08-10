package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class ItemsProperty {

	private SimpleStringProperty name;
	private SimpleDoubleProperty strenght;
	
	public ItemsProperty(String nome, double forca){
		this.name = new SimpleStringProperty(nome);
		this.strenght = new SimpleDoubleProperty(forca);
		
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String nome) {
		this.name.set(nome);
	}

	public double getStrenght() {
		return this.strenght.get();
	}

	public void setStrenght(double forca) {
		this.strenght.set(forca);
	}
	
}