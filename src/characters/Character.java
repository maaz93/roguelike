package characters;

import java.util.Observable;

import donjon.Case;
import donjon.Room;
import exceptions.OutOfBoundaryException;

@SuppressWarnings("deprecation")
public abstract class Character implements Cloneable{
	private String name;
	private int hp;
	private int force;
	private int defense;
	private int level;
	private Case position;
	//private Room room;
	
	
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
	
	public void getPositionXY(){
		System.out.println("X: "+position.getX()+ " Y: "+position.getY());
	}
	
	public int getPositionX() {
		return position.getX();
	}
	
	public int getPositionY() {
		return position.getY();
	}

	public boolean isAlive() {
		if(getHp() <=0 ) {
			return false;
		}
		return true;
	}
	
	
	public void move(char move,Room room) throws OutOfBoundaryException {
		int x_max = room.getLongueur()-1;
		int y_max = room.getHauteur()-1;
		int x = getPositionX();
		int y = getPositionY();
		switch(move) {
		//UP
		case 'z':
			if(y == 0) {
				throw new OutOfBoundaryException();
			}
			else {
				room.getPlateau().get(y).get(x).deleteAcharacter(this);
				room.getPlateau().get(y-1).get(x).addAcharacter(this);
				this.position = room.getPlateau().get(y-1).get(x);

			}
			break;
		//DOWN
		case's':
			if(y == y_max) {
				throw new OutOfBoundaryException();
			}
			else {
				room.getPlateau().get(y).get(x).deleteAcharacter(this);
				room.getPlateau().get(y+1).get(x).addAcharacter(this);
				this.position = room.getPlateau().get(y+1).get(x);
			}
			break;
		//RIGHT
		case 'd':
			if(x == x_max) {
				throw new OutOfBoundaryException();
			}
			else {
				room.getPlateau().get(y).get(x).deleteAcharacter(this);
				room.getPlateau().get(y).get(x+1).addAcharacter(this);
				this.position = room.getPlateau().get(y).get(x+1);
			}
			break;
		//LEFT
		case 'q':
			if(x == 0) {
				throw new OutOfBoundaryException();
			}
			else {
				room.getPlateau().get(y).get(x).deleteAcharacter(this);
				room.getPlateau().get(y).get(x-1).addAcharacter(this);
				this.position = room.getPlateau().get(y).get(x-1);
			}
			break;
		default:
			throw new OutOfBoundaryException();
		}
		
	
	}
	
	public int attack(Character c1) {
		return (int)(1+getForce()*2*Math.random()*2 / c1.getDefense());
	}
	
	public void takeDamage(int damage) {
		setHp(getHp()-damage);
	}
	
	public abstract void dropItem();
	public abstract void getSymbol();

	@Override
	public abstract Character clone() throws CloneNotSupportedException;

	
	
}
