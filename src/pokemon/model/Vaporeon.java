package pokemon.model;

public class Vaporeon extends Pokemon implements Water
{
	public Vaporeon(int number, String name)
	{
		super(number, name);
	}
	
	public void surf()
	{
		System.out.println("Vaporeon used surf! " + this.getAttackPoints());
	}
	
	public void becomeWater()
	{
		System.out.println("Vaporeon jumped into a pool of water and vanished!");
	}
}
