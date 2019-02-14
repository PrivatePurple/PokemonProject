package pokemon.controller;

import java.util.ArrayList;
import pokemon.view.PokedexFrame;
import pokemon.view.PokedexPanel;
import pokemon.model.*;
import javax.swing.*;

public class PokedexController
{
	private PokedexFrame appFrame = new PokedexFrame(this);
	private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>(6);
	public PokedexController()
	{
		
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
	}
	
	public PokedexFrame getFrame()
	{
		return appFrame;
	}
	
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0])); 
		}
	}
	
	public String[] buildPokedexTest()
	{
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
}


