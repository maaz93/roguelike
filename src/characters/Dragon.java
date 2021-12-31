package characters;

public class Dragon extends Monster {
	
	public Dragon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dragon(String name, int hp, int force, int defense, int level) {
		super(name,hp,force,defense,level);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCategorie() {
		// TODO Auto-generated method stub
		if (super.getCategorie()==null){
			super.setCategorie("Dragon");
		}
		return super.getCategorie();
	}

	@Override
	public void setCategorie(String categorie) {
		// TODO Auto-generated method stub
		super.setCategorie("Dragon");
	}

	@Override
	public void getSymbol() {
		// TODO Auto-generated method stub
		System.out.print("D");
	}

	@Override
	public Monster clone() {
		// TODO Auto-generated method stub
		return new Dragon(getName(), getHp(), getForce(), getDefense(), getLevel());
	}



	@Override
	public void dropItem() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
