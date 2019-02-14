package pokemon.view;

import pokemon.controller.PokedexController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JComboBox pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhancementLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		
		this.appLayout = new SpringLayout();
		
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/vaporeon.png"));
		
		numberField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, numberField, -111, SpringLayout.EAST, this);
		nameField = new JTextField("My Pokename");
		appLayout.putConstraint(SpringLayout.EAST, nameField, -156, SpringLayout.EAST, this);
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -86, SpringLayout.EAST, this);
		attackField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, 105, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 183, SpringLayout.NORTH, this);
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.SOUTH, enhancementField, -270, SpringLayout.SOUTH, this);
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.EAST, healthField, -111, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -6, SpringLayout.NORTH, healthField);
		
		healthLabel = new JLabel("This Pokemon's health is");
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -166, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 36, SpringLayout.EAST, healthLabel);
		numberLabel = new JLabel("This Pokemon's Pokedex Number is");
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, -243, SpringLayout.WEST, this);
		
		evolveLabel = new JLabel("This Pokemon can evolve");
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 5, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, 0, SpringLayout.EAST, nameField);
		attackLabel = new JLabel("This Pokemon's attack level is");
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -151, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 21, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 188, SpringLayout.NORTH, this);
		nameLabel = new JLabel("This Pokemon's name is");
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 37, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 41, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 119, SpringLayout.WEST, this);
		imageLabel = new JLabel("Pokemon goes here!", pokemonIcon, JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 106, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -82, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 31, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -527, SpringLayout.EAST, this);
		enhancementLabel = new JLabel("This pokemon's enhancement level is");
		appLayout.putConstraint(SpringLayout.EAST, enhancementLabel, -136, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 6, SpringLayout.EAST, enhancementLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -23, SpringLayout.NORTH, enhancementLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementLabel, 154, SpringLayout.NORTH, this);
		changeButton = new JButton("Click here to change the pokevalues");
		
		setupDropdown();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexTest());
		pokedexDropdown.setModel(temp);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					sendDataToController();
				}
			});
	}
	
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 21, SpringLayout.SOUTH, imageLabel);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 54, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, 206, SpringLayout.WEST, this);
		this.add(pokedexDropdown);
		this.add(nameField);
		this.add(numberField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(imageLabel);
		this.add(enhancementLabel);
		this.add(healthLabel);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
		
		private void sendDataToController()
		{
			int index = pokedexDropdown.getSelectedIndex();
				
				if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
			{
					String [] data = new String[5];
					
					//insert code here
					app.updatePokemon(index, data);
			}
		}
		
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "vaporeon";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
}
