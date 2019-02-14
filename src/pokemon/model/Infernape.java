package pokemon.model;

public class Infernape extends Pokemon implements Fire, Fighting
{
	public Infernape()
	{
		super(392, "Infernape");
	}
	
	public Infernape(int number, String name)
	{
		super(number, name);
	}
	
	public void flamethrower()
	{
		System.out.println("Absol used Dark Pulse! " + this.getAttackPoints());
	}
		
	public void closeCombat()
	{
		System.out.println("Infernape used CloseCombat!");
	}
}
