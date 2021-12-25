package item;

public abstract class Arme extends Item {
	private int force;

	public Arme() {
		super();
	}
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}
}
