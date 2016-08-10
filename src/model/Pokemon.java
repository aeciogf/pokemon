package model;

public class Pokemon {
	private String name;
	private double strength;
	
	public Pokemon(String nome, double forca){
		this.name = nome;
		this.strength = forca; 
	}

	public String getName(){
		return this.name;
	}
	
	public double getStrength(){
		return this.strength;
	}
}
