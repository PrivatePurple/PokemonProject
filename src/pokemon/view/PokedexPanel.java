package pokemon.view;

import pokemon.controller.PokedexController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	private SpringLayout appLayout;
	
	private JButton saveButton;
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
		nameField = new JTextField("My Pokename");
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 82, SpringLayout.SOUTH, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 55, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, -108, SpringLayout.EAST, this);
		evolveField = new JTextField("false");
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -86, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, evolveField);
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.SOUTH, enhancementField, -157, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 19, SpringLayout.SOUTH, enhancementField);
		healthField = new JTextField("0");
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, -24, SpringLayout.NORTH, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, healthField, -111, SpringLayout.EAST, this);
		
		healthLabel = new JLabel("This Pokemon's health is");
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -156, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 26, SpringLayout.EAST, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, healthField);
		numberLabel = new JLabel("This Pokemon's Pokedex Number is");
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -26, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, numberField);
		
		evolveLabel = new JLabel("This Pokemon can evolve");
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -156, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 26, SpringLayout.EAST, evolveLabel);
		attackLabel = new JLabel("This Pokemon's attack level is");
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -156, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 26, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 42, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 5, SpringLayout.NORTH, attackField);
		nameLabel = new JLabel("This Pokemon's name is");
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -24, SpringLayout.WEST, nameField);
		imageLabel = new JLabel("Pokemon goes here!", pokemonIcon, JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.NORTH, imageLabel, 34, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 30, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, imageLabel, -517, SpringLayout.EAST, this);
		enhancementLabel = new JLabel("This pokemon's enhancement level is");
		appLayout.putConstraint(SpringLayout.EAST, enhancementLabel, -156, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 26, SpringLayout.EAST, enhancementLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementLabel, 5, SpringLayout.NORTH, enhancementField);
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
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
			};
		});
	}
	
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -37, SpringLayout.NORTH, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 395, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 58, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -527, SpringLayout.EAST, this);
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
