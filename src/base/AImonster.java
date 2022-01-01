package base;

import characters.Character;
import donjon.Room;

public class AImonster {
	private Character hero;
	private Character monster;
	private Room room;
	
	public AImonster(Character monster, Character hero, Room room) {
		super();
		this.hero = hero;
		this.monster = monster;
		this.room = room;
	}

	public void jouerTour() {
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
	
	public void movetowardsHero(){
		int x_hero = hero.getPositionX();
		int y_hero = hero.getPositionY();
		
		//RIGHT
		if (x_hero < monster.getPositionX()) {
			monster.move('d',room);
		}
		//LEFT
		else if (x_hero > monster.getPositionX()) {
			monster.move('q',room);
		}
		//DOWN
		if (y_hero < monster.getPositionY()) {
			monster.move('s',room);
		}
		//UP
		else if (y_hero > monster.getPositionY()) {
			monster.move('z',room);
		}
	}
	
	public void attack() {
		monster.attack(hero);
	}
	
}
