package item;

public abstract class Armure extends Item {
	private int hp;
	private int defense;
	
	public Armure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
}
