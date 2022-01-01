package donjon;

import characters.FabriqueMonster;
import characters.Monster;

import java.util.ArrayList;
import java.util.List;

import characters.Character;

public class RoomBuilder {
	private Plateau<Case> plateau;
	private int hauteur;
	private int longueur;
	private List<Monster> monsters;
	private int nbMonster;
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
		nbMonster = nbmonster;
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
		this.monsters = room.getMonsters();
		this.difficulte = room.getDifficulte();
		return this;
	}
	public Room build() {
		if(clonage == true) {
			return new Room(plateau,monsters,difficulte);
		}
		if (plateau == null) {
			dimension(5,5);
		}
		if(monsters == null) {
			monsters = new ArrayList<Monster>();
		}
		if(nbMonster == 0 ) {
			nbMonster = 3;
		}
		if(difficulte == 0) {
			difficulte = 1;
		}
		FabriqueMonster F = new FabriqueMonster();
		int x = 0;
		int y = 0;
		for (int i = 0; i < nbMonster; i++) {
			x = (int)(Math.random()*longueur);
			y = (int)(Math.random()*hauteur);
			if (this.plateau.get(y).get(x).getCharacters().size() == 0) {
				Monster m = F.getRandomMonster(difficulte);
				this.plateau.get(y).get(x).addAcharacter(m);
				monsters.add(m);
				
			}
			else {
				i--;
			}
		}
		
		return new Room(plateau,monsters,difficulte);
	}
}
