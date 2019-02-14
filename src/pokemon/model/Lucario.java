package pokemon.model;

public class Lucario extends Pokemon implements Fighting, Steel
{
		public Lucario()
		{
			super(448, "Lucario");
		}
		
		public Lucario(int number, String name)
		{
			super(number, name);
		}
		
		public void ironTail()
		{
			System.out.println("Lucario used Iron Tail! " + this.getAttackPoints());
		}
			
		public void closeCombat()
		{
			System.out.println("Lucario used CloseCombat!");
		}
	}
