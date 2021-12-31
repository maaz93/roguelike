package item;

public class Potionhp extends Consommable {

	public Potionhp() {
		super();
		super.setDescription("PotionHP");
		// TODO Auto-generated constructor stub
	}

	public Potionhp(int hp) {
		super();
		super.setHp(hp);
		super.setDescription("PotionHP");

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Potionhp [Hp : " + getHp() + "]";
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new Potionhp(getHp());
	}
	
	@Override
	public void getSymbol() {
		// TODO Auto-generated method stub
		System.out.println("p");
	}
	
}
