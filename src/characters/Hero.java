package characters;

import item.Inventaire;

public class Hero extends Character{
	private int maxHP;
	private static Hero myhero = null;
	private Inventaire inventaire;

	public Hero() {
		// TODO Auto-generated constructor stub
		maxHP=40;
		super.setHp(maxHP);
		super.setDefense(4);
		super.setForce(20);
	}

	public static Hero getInstance() {
		if (myhero == null) {
			myhero = new Hero();
		}
		return myhero;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	@Override
	  public Hero clone() throws CloneNotSupportedException {
	    throw new CloneNotSupportedException();
	}

	@Override
	public void getSymbol() {
		// TODO Auto-generated method stub
		System.out.print("H");

	}


	@Override
	public void dropItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hero [ level : "+this.getLevel()+", MaxHP : "+this.getMaxHP()+", HP : "+this.getHp()+", Force : "
		+this.getForce()+", Defense : "+this.getDefense() +"]";
	}
	
	
	
	
}
