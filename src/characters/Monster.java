package characters;

public abstract class Monster extends Character {
	private String categorie;
	

	public Monster(String name, int hp, int force, int defense, int level) {
		super(name, hp, force, defense, level);
		// TODO Auto-generated constructor stub
	}

	public Monster() {
		// TODO Auto-generated constructor stub
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Monster [categorie=" + this.getCategorie() + ", level : "+this.getLevel()+", HP : "+this.getHp()+", Force : "
				+this.getForce()+", Defense : "+this.getDefense() +"]";
	}

	@Override
	public abstract Monster clone();
		// TODO Auto-generated method stub	


	
	
	
}
