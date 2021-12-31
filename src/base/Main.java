package base;

import java.util.ArrayList;
import java.util.List;

import characters.Character;
import characters.FabriqueMonster;
import donjon.Case;
import donjon.Donjon;
import donjon.DonjonBuilder;
import donjon.Plateau;
import donjon.Room;
import item.FabriqueItem;
import item.Inventaire;
import item.Item;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FabriqueMonster F = new FabriqueMonster();
		FabriqueItem I = new FabriqueItem();
		Character g = F.getGobelin();
		Character g1 = F.getGobelin();
		Character g2 = F.getGobelin();
		Character d1 = F.getDragon();
		Character d2 = F.getDragon();
		Character f1 = F.getFantome();
		Character f2 = F.getFantome();
		Item p = I.getPotionhp();
		Item ep = I.getEpee();
		Item t = I.getTalisman();
		Case c1 = new Case();
		Case c2 = new Case();
		Case c3 = new Case();
		Case c4 = new Case();
		Case c5 = new Case();
		Case c6 = new Case();
		
		c1.getCharacters().add(d1);
		try {
			c2.getCharacters().add(d1.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c1.getCharacters().add(f1);
		//System.out.println(c1);
		//System.out.println(c2);
		d1.setDefense(2);
		//System.out.println(c1);
		//System.out.println(c2);
		
		/*System.out.println("test clonage case");
		Case c3 = new Case();
		c3.setAcharacter(g2);
		Case c4 = c3.clone();
		g2.setDefense(10);
		c3.setAcharacter(d2);
		System.out.println(c3);
		System.out.println(c4);*/
		
		System.out.println("test clonage plateau");
		DonjonBuilder DB = new DonjonBuilder();
		Donjon donjon = DB.build();
		Plateau<Case> pla = donjon.getRooms().get(0).getPlateau().clone();
		donjon.getRooms().get(1).setPlateau(pla);
		
		donjon.getRooms().get(1).getPlateau().get(2).get(1).addAcharacter(d1);
		donjon.getRooms().get(0).draw();
		donjon.getRooms().get(0).affiche();
		
		donjon.getRooms().get(1).draw();
		donjon.getRooms().get(1).affiche();
		
		System.out.println("test clonage donjon");
		Donjon donjon1 = DB.reset().build();
		donjon1.getRooms().get(0).draw();
		donjon1.getRooms().get(0).affiche();

		Donjon donjonC = DB.clone(donjon1).build();
		donjonC.getRooms().get(0).setPlateau(pla);

		donjonC.getRooms().get(0).draw();
		donjonC.getRooms().get(0).affiche();

		Inventaire inv = new Inventaire();
		inv.add(p);
		inv.add(t);
		System.out.println(inv);
		int Force = 80;
		int Def = 40;
		for (int j = 0; j < 10; j++) {
			System.out.println((int)(1+Force*2*Math.random()*2 / Def));
		}
		
		Game game = new Game();
		game.run();
		
	}

}
