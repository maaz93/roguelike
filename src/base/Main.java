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
		
		System.out.println("test clonage case");
		Case c3 = new Case();
		c3.setAcharacter(g2);
		Case c4 = c3.clone();
		g2.setDefense(10);
		c3.setAcharacter(d2);
		System.out.println(c3);
		System.out.println(c4);
		
		DonjonBuilder DB = new DonjonBuilder();
		Donjon donjon = DB.build();
		Plateau<Case> pla = donjon.getRooms().get(0).getPlateau().clone();
		donjon.getRooms().get(1).setPlateau(pla);
		
		donjon.getRooms().get(1).getPlateau().get(2).get(1).setAcharacter(d1);
		donjon.getRooms().get(0).draw();
		donjon.getRooms().get(0).affiche();
		
		donjon.getRooms().get(1).draw();
		donjon.getRooms().get(1).affiche();
		
		/*System.out.println();
		Donjon donjonclone = new DonjonBuilder().clone(donjon).build();
		System.out.println(donjon.getRooms().get(0).getPlateau().get(0).size());

		donjon.getRooms().get(0).draw();
		donjon.getRooms().get(0).affiche();
		
		donjonclone.getRooms().get(0).draw();
		donjonclone.getRooms().get(0).affiche();
		donjonclone.getRooms().get(0).getPlateau().get(2).get(2).setAcharacter(d1);
		System.out.println(donjon.hashCode());
		System.out.println(donjonclone.hashCode());
		donjon.getRooms().get(0).draw();
		donjon.getRooms().get(0).affiche();
		
		donjonclone.getRooms().get(0).draw();
		donjonclone.getRooms().get(0).affiche();*/
		/*System.out.println(g);
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(p);
		System.out.println(ep);
		System.out.println(t);
		
		List<Character> characters= new ArrayList<Character>();
		characters.add(f1);
		characters.add(g);
		System.out.println(characters);*/
	}

}
