package characters;

public class Gobelin extends Monster {

	public Gobelin() {
		super();
		super.setCategorie("Gobelin");
		// TODO Auto-generated constructor stub
	}

	public Gobelin(String name, int hp, int force, int defense, int level) {
		super(name,hp,force,defense,level);
		super.setCategorie("Gobelin");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getSymbol() {
		// TODO Auto-generated method stub
		System.out.print("G");
	}

	@Override
	public Monster clone() {
		// TODO Auto-generated method stub
		return new Gobelin(getName(), getHp(), getForce(), getDefense(), getLevel());
	}

	@Override
	public void dropItem() {
		// TODO Auto-generated method stub
		
	}

	

	
}
