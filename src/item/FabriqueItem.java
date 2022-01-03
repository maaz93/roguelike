package item;

import characters.Monster;

public class FabriqueItem {
	public Item getPotionhp() {
		int hp = 5+ (int) (Math.random()*10);
		Potionhp potionhp = new Potionhp(hp);
		return potionhp;
	}
	
	public Item getEpee(){
		int force = 5 + (int)(Math.random()*10);
		Epee epee = new Epee(force);
		return epee;
	}
	
	public Item getTalisman() {
		int defense = 5 + (int)(Math.random()*10);
		Talisman talisman = new Talisman(defense);
		return talisman;
	}
	
	public Item getItem(String item) {
		switch (item) {
		case "potionhp":
			return getPotionhp();
		case "epee":
			return getEpee();
		case "talisman":
			return getTalisman();
		
		default:
		throw new IllegalArgumentException("Unexpected value: " + item);
		}
	} 
}
