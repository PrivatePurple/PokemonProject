package pokemon.model;

public class Absol extends Pokemon implements Dark
{
	public Absol()
	{
		super(359, "Absol");
	}
	
	public Absol(int number, String name)
	{
		super(number, name);
	}
	
	public void darkPulse()
	{
		System.out.println("Absol used Dark Pulse! " + this.getAttackPoints());
	}
		
	public void nightSlash()
	{
		System.out.println("Absol cuts into their foe with Night Slash!");
	}
}
