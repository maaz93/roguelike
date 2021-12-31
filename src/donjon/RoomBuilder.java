package donjon;

import characters.FabriqueMonster;
import characters.Character;

public class RoomBuilder {
	private Plateau<Case> plateau;
	private int hauteur;
	private int longueur;
	private int nbmonster;
	private int difficulte;
	private boolean clonage = false;
	
	public RoomBuilder reset() {
		this.plateau = null;
		this.clonage=false;
		return this;
	}
	public RoomBuilder dimension(int longueur , int hauteur) {
		this.plateau = new Plateau<Case>(longueur,hauteur);
		this.longueur=longueur;
		this.hauteur=hauteur;
		return this;
	}
	
	public RoomBuilder nbMonster(int nbmonster) {
		this.nbmonster = nbmonster;
		return this;
	}
	public RoomBuilder difficulte(int difficulte) {
		this.difficulte = difficulte;
		return this;
	}
	
	public RoomBuilder clone(Room room) {
		this.clonage=true;
		this.plateau = room.getPlateau();
		this.hauteur = room.getHauteur();
		this.longueur = room.getLongueur();
		this.nbmonster = room.getNbmonster();
		this.difficulte = room.getDifficulte();
		return this;
	}
	public Room build() {
		if(clonage == true) {
			return new Room(plateau,nbmonster,difficulte);
		}
		if (plateau == null) {
			dimension(5,5);
		}
		if(nbmonster == 0 ) {
			nbmonster = 3;
		}
		if(difficulte == 0) {
			difficulte = 1;
		}
		FabriqueMonster F = new FabriqueMonster();
		int x = 0;
		int y = 0;
		for (int i = 0; i < nbmonster; i++) {
			x = (int)(Math.random()*longueur);
			y = (int)(Math.random()*hauteur);
			if (this.plateau.get(y).get(x).getCharacters().size() == 0) {
				Character c = F.getRandomMonster(difficulte);
				this.plateau.get(y).get(x).addAcharacter(c);
				
			}
			else {
				i--;
			}
		}
		
		return new Room(plateau,nbmonster,difficulte);
	}
}
