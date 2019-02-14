package pokemon.model;

public class Sylveon extends Pokemon implements Fairy
{
	public Sylveon()
	{
		super(700, "Sylveon");
	}
	
	public Sylveon(int number, String name)
	{
		super(number, name);
	}
	
	public void wish()
	{
		System.out.println("Sylveon used Wish! " + this.getAttackPoints());
	}
		
	public void hyperVoice()
	{
		System.out.println("Sylveon used Hyper Voice!");
	}
}
