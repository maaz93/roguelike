package characters;

public class Fantome extends Monster{
	
	public Fantome() {
		super.setCategorie("Fantome");
	}
	public Fantome(String name, int hp, int force, int defense, int level) {
		super(name,hp,force,defense,level);
		super.setCategorie("Fantome");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getSymbol() {
		// TODO Auto-generated method stub
		System.out.print("F");
	}
	@Override
	public Monster clone() {
		// TODO Auto-generated method stub
		return new Fantome(getName(), getHp(), getForce(), getDefense(), getLevel());
	}
	
	@Override
	public void dropItem() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
