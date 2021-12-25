package item;

public class Talisman extends Armure {

	public Talisman() {
		super();
		super.setDescription("Talisman");
		// TODO Auto-generated constructor stub
	}
	
	public Talisman(int defense) {
		super();
		super.setDescription("Talisman");
		super.setDefense(defense);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Talisman [Defense : " + getDefense() + "]";
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new Talisman(getDefense());
	}
	
	
}
