package donjon;

import java.util.Arrays;

public class Room {
	private Plateau<Case> plateau;
	private int longueur;
	private int hauteur;
	private int nbmonster;
	private int difficulte;

	public Room() {
		this.hauteur = 5;
		this.longueur = 5;
		this.plateau = new Plateau<Case>(longueur,hauteur);
	}
	
	public Room(int hauteur, int longueur) {
		this.hauteur = hauteur;
		this.longueur = longueur;
		this.plateau = new Plateau<Case>(longueur,hauteur);
	
		
	}

	public Room(Plateau<Case> plateau2, int nbmonster, int difficulte) {
		// TODO Auto-generated constructor stub
		this.plateau = plateau2;
		this.hauteur = plateau2.size();
		this.longueur = plateau2.get(0).size();
		this.setNbmonster(nbmonster);
		this.setDifficulte(difficulte);
		
	}



	public Plateau<Case> getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau<Case> plateau) {
		this.plateau = plateau;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	

	public int getNbmonster() {
		return nbmonster;
	}

	public void setNbmonster(int nbmonster) {
		this.nbmonster = nbmonster;
	}

	public int getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}
	
	public void affiche() {
		System.out.println("plateau : " +plateau.hashCode()+" room:"+hashCode());
		for (int i = 0; i < longueur ; i++) {
			for (int j = 0; j < hauteur; j++) {
				System.out.println(plateau.get(j).get(i));
			}
		}
	}

	@Override
	public String toString() {
		return "Room [longueur=" + longueur + ", hauteur=" + hauteur
				+ ", nbmonster=" + nbmonster + ", difficulte=" + difficulte + "]";
	}
	
	public void draw() {
		for (int j = 0; j < hauteur; j++) {
			System.out.print("  ");
			if(j==0) {
				for (int i = 0; i < longueur; i++) {
					System.out.print("  "+i+" ");
				}
				System.out.println();
				System.out.print("  ");
			}
			System.out.println(" -".repeat(longueur*2));
			for (int i = 0; i < longueur; i++) {
				if(i==0) {
					System.out.print(j+" | ");
					plateau.get(j).get(i).draw();
					System.out.print(" |");
				}
				else {
					System.out.print(" ");
					plateau.get(j).get(i).draw();
					System.out.print(" |");
				}
				
			}
			System.out.println();
		}
		System.out.print("  ");
		System.out.println(" -".repeat(longueur*2));
		/*for (int i = 0; i < longueur; i++) {
			System.out.print("  ");
			if(i==0) {
				for (int j = 0; j < hauteur; j++) {
					System.out.print("  "+j+" ");
				}
				System.out.println();
				System.out.print("  ");
			}
			
			System.out.println(" -".repeat(longueur*2));
			for (int j = 0; j < hauteur; j++) {
				if(j==0) {
					System.out.print(i+" | ");
					plateau.get(j).get(i).draw();
					System.out.print(" |");
				}
				else {
					System.out.print(" ");
					plateau.get(j).get(i).draw();
					System.out.print(" |");
				}
				
			}
			System.out.println();
		}*/
	}
	
}
