package characters;

public class Hero extends Character{
	private static Hero myhero = null;


	public Hero() {
		// TODO Auto-generated constructor stub
	}

	public static Hero getInstance() {
		if (myhero == null) {
			myhero = new Hero();
		}
		return myhero;
	}

	@Override
	  public Hero clone() throws CloneNotSupportedException {
	    throw new CloneNotSupportedException();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print("H");

	}
	
}
