package item;

public class Epee extends Arme{
	public Epee() {
		super();
		super.setDescription("Epee");
	}
	
	public Epee(int force) {
		super();
		super.setForce(force);
		super.setDescription("Epee");

	}
	
	@Override
	public String toString() {
		return "Epee [Force : " + getForce() + "]";
	}

	@Override
	public Item clone() {
		// TODO Auto-generated method stub
		return new Epee(getForce());
	}

}
