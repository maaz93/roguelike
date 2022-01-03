package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import base.Controller;
import donjon.Case;
import donjon.CaseEscalier;
import donjon.Donjon;
import donjon.Room;
import exceptions.MultipleMonsterNearException;
import exceptions.NoMonsterNearException;
import exceptions.NotOnStairsException;
import exceptions.OutOfBoundaryException;
import item.Armure;
import item.Epee;
import item.Inventaire;

public class Hero extends Character{
	private int maxHP;
	private static Hero myhero = null;
	private Inventaire inventaire;
	private Optional<Armure> armure;
	private Optional<Epee> epee;

	public Hero() {
		// TODO Auto-generated constructor stub
		maxHP=40;
		super.setHp(maxHP);
		super.setDefense(40);
		super.setForce(40);
		inventaire = new Inventaire();

	}

	
	public Hero(String name, int hp, int force, int defense) {
		super(name, hp, force, defense);
		inventaire = new Inventaire();
		maxHP=hp;
		armure = Optional.empty();
		epee = Optional.empty();
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

	public Optional<Armure> getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = Optional.of(armure);
	}

	public Optional<Epee> getEpee() {
		return epee;
	}

	public void setEpee(Epee epee) {
		this.epee = Optional.of(epee);
	}

	@Override
	  public Hero clone() throws CloneNotSupportedException {
	    throw new CloneNotSupportedException();
	}

	@Override
	public void getSymbol() {
		// TODO Auto-generated method stub
		if(isAlive()) {
			System.out.print("H");
		}
		else {
			System.out.print("#");
		}
		

	}


	@Override
	public void dropItem() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Case> canAttack(Room room) {
		List<Case> list = new ArrayList<Case>();
		int x_hero = this.getPositionX();
		int y_hero = this.getPositionY();
		
		//cherche tous les monstres attaquables
		if(room.getMonsters().size()>0) {
			for (Monster monster : room.getMonsters()) {
				int x_monster = monster.getPositionX();
				int y_monster = monster.getPositionY();
				if(Math.sqrt( Math.pow((x_hero-x_monster), 2) + Math.pow((y_hero-y_monster), 2) ) <= 1){
					list.add(monster.getPosition());
				}
			}
			
		}
		//new list without duplicate Case
		List<Case> newList = list.stream()
                .distinct()
                .collect(Collectors.toList());
		return newList;
	}

	public void attack1(Room room) throws NoMonsterNearException,MultipleMonsterNearException{
		List<Case> list = canAttack(room);
		
		if (list.size() == 0) {
			throw new NoMonsterNearException();
		}
		else if(list.size() == 1) {
			attack1(list.get(0));
		}
		else {
			throw new MultipleMonsterNearException(list.size());
		}
	}
	
	public void attack1(Case c) {
		for (Character c1 : c.getCharacters()) {
			if(c1 instanceof Monster) {
				this.attack(c1);
			}
		}
	}
	public void removeAnItem(int arg) {
		inventaire.remove(arg);
	}
	
	public void takeStairs(char etage,Room room, Donjon donjon) throws OutOfBoundaryException,NotOnStairsException{
		if (this.getPosition() instanceof CaseEscalier != true) {
			throw new NotOnStairsException();
		}
		else {
			int roomFloor = donjon.getRooms().indexOf(room);
			//Monter
			if (etage == 'p') {
				if(roomFloor+1 == donjon.getRooms().size()) {
					throw new OutOfBoundaryException("Vous ne pouvez pas monter plus haut");
				}
				else {
					room.findStairs().deleteAcharacter(this);
					donjon.getRooms().get(roomFloor+1).findStairs().addAcharacter(this);
					super.setPosition(donjon.getRooms().get(roomFloor+1).findStairs());
				}
			}
			//Descendre
			else {
				if(roomFloor == 0) {
					throw new OutOfBoundaryException("Vous ne pouvez pas descendre plus bas");
				}
				else {
					room.findStairs().deleteAcharacter(this);
					donjon.getRooms().get(roomFloor-1).findStairs().addAcharacter(this);
					super.setPosition(donjon.getRooms().get(roomFloor-1).findStairs());
				}
			}
		}
	}
	@Override
	public String toString() {
		return "Hero [ level : "+this.getLevel()+", MaxHP : "+this.getMaxHP()+", HP : "+this.getHp()+", Force : "
		+this.getForce()+", Defense : "+this.getDefense() +"]";
	}
	
	
	
	
}
