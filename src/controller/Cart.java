package controller;

import model.Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	private static List<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	public void addToCart(Pokemon... ps){
		for (Pokemon p: ps){
			this.pokemons.add(p);
		}
	}
	
	public List<Pokemon> getFromCart(){
		return this.pokemons;
	}
}
