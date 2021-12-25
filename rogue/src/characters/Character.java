package characters;

import donjon.Case;

public abstract class Character implements Cloneable{
	private String name;
	private int hp;
	private int force;
	private int defense;
	private int level;
	private Case position;
	
	
	public Character() {
	}
	
	public Character(String name, int hp, int force, int defense, int level) {
		super();
		this.name = name;
		this.hp = hp;
		this.force = force;
		this.defense = defense;
		this.level = level;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}
	
	public boolean isAlive() {
		return false;
	}

	public abstract void draw();

	@Override
	public abstract Character clone() throws CloneNotSupportedException;


	
	
	
}
