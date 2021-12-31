package base;

import characters.Hero;

public class HeroObserver {
	private static HeroObserver instance;
	private Hero hero;
	
	public HeroObserver(Hero hero) {
		instance = this;
		this.hero = hero;
	}
	
	
}
