package characters;

public class FabriqueMonster {
	public Monster getGobelin() {
		String name="Gobelin";
		int level = 1+ (int) (Math.random()*2);
		int hp=1+ ((int) (Math.random()*10)+1) * level;
		int force=1+ ((int) (Math.random()*10)+1) * level;
		int defense=1+ ((int) (Math.random()*10)+1) * level;		 
		Gobelin gobelin = new Gobelin(name,hp,force,defense,level);
		return gobelin;
	}
	
	public Monster getDragon() {
		String name="Dragon";
		int level = 5+ (int) (Math.random()*2);
		int hp=1+ ((int) (Math.random()*10)+5) * level;
		int force=1+ ((int) (Math.random()*10)+5) * level;
		int defense=1+ ((int) (Math.random()*10)+5) * level;		 
		Dragon dragon = new Dragon(name,hp,force,defense,level);
		return dragon;
	}
	
	public Monster getFantome() {
		String name="Fantome";
		int level = 2+ (int) (Math.random()*2);
		int hp=1+ ((int) (Math.random()*10)+2) * level;
		int force=1+ ((int) (Math.random()*10)+2) * level;
		int defense=1+ ((int) (Math.random()*10)+2) * level;
		Fantome fantome = new Fantome(name,hp,force,defense,level);
		return fantome;
	}
	
	public Monster getMonster(String monster) {
		switch (monster) {
		case "gobelin":
			return getGobelin();
		case "fantome":
			return getFantome();
		case "dragon":
			return getDragon();
		
		default:
		throw new IllegalArgumentException("Unexpected value: " + monster);
		}
	}
	
	public Monster getRandomMonster(int difficulte) {
		double r = Math.random();
		switch (difficulte) {
		case 1: {
			if (r < 0.8) {
				return getGobelin();
			}
			else {
				return getFantome();
			}
		}
		case 2: {
			if (r < 0.4) {
				return getGobelin();
			}
			else if(0.4 <= r && r < 0.8) {
				return getFantome();
			}
			else {
				return getDragon();
						
			}
		}
		case 3: {
			if (r < 0.15) {
				return getGobelin();
			}
			else if(0.15 <= r && r < 0.75) {
				return getFantome();
			}
			else {
				return getDragon();
						
			}
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + difficulte);
		}
	}
}
