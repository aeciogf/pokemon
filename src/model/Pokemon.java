package model;

public class Pokemon {
	private String nome;
	private double forca;
	
	public Pokemon(String nome, double forca){
		this.nome = nome;
		this.forca = forca; 
	}

	public String getNome(){
		return this.nome;
	}
	
	public double getForca(){
		return this.forca;
	}
}
