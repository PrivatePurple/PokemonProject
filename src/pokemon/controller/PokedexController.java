package pokemon.controller;

import java.util.ArrayList;
import pokemon.model.Pokemon;
import pokemon.view.PokedexFrame;
import pokemon.view.PokedexPanel;
import pokemon.model.*;
import javax.swing.*;
import java.io.*;

public class PokedexController
{
	private String saveFile = "backup.pokemon";
	private PokedexFrame appFrame;
	private ArrayList<Pokemon> pokemonList; 
	public PokedexController()
	{
		appFrame = new PokedexFrame(this);
		pokemonList = new ArrayList<Pokemon>(6);
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
		if (data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
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

	public boolean isInt(String maybeInt)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(maybeInt);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "You need to type in a whole number! :D");	
		}
		
		return isValid;
	}
	
	public boolean isDouble(String maybeDouble)
	{
		boolean isValid = false;
		try
		{
			Double.parseDouble(maybeDouble);
			isValid = true;
		}
		catch (NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "One more time, please. (No decimals this time.");
		}
		return isValid;
	}
	
	public void savePokedex()
	{
		try
		{
		FileOutputStream saveStream = new FileOutputStream(saveFile);
				ObjectOutputStream output = new ObjectOutputStream(saveStream);
				output.writeObject(pokemonList);
				output.close();
				saveStream.close();
	}
	catch(IOException error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
	}
}
}


