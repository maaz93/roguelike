package base;

import characters.Character;
import characters.Hero;
import characters.Monster;
import donjon.Room;
import exceptions.OutOfBoundaryException;

public class AImonster {
	private Hero hero;
	private Monster monster;
	private Room room;
	
	public AImonster(Monster monster, Hero hero, Room room) {
		super();
		this.hero = hero;
		this.monster = monster;
		this.room = room;
	}

	public void jouerTour() throws OutOfBoundaryException {
		if(canAttack() == true) {
			attack();
		}
		else {
			movetowardsHero();
			if(canAttack() == true) {
				attack();
			}
		}
	}
	
	public boolean canAttack() {
		int x_hero = hero.getPositionX();
		int y_hero = hero.getPositionY();
		int x_monster = monster.getPositionX();
		int y_monster = monster.getPositionY();
		
		if(Math.sqrt( Math.pow((x_hero-x_monster), 2) + Math.pow((y_hero-y_monster), 2) ) <= 1){
			return true;
		}
		return false;
	}
	
	public void movetowardsHero() throws OutOfBoundaryException{
		int x_hero = hero.getPositionX();
		int y_hero = hero.getPositionY();
		
		//LEFT
		if (x_hero < monster.getPositionX()) {
			monster.move('q',room);
		}
		//RIGHT
		else if (x_hero > monster.getPositionX()) {
			monster.move('d',room);
		}
		//UP
		else if (y_hero < monster.getPositionY()) {
			monster.move('z',room);
		}
		//DOWN
		else if (y_hero > monster.getPositionY()) {
			monster.move('s',room);
		}
	}
	
	public void attack() {
		monster.attack(hero);
	}
	
}
