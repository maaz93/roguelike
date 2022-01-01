package base;
import java.util.List;
import java.util.Scanner;

import characters.Character;
import characters.Hero;
import donjon.Case;
import donjon.Room;
import exceptions.MultipleMonsterNearException;
import exceptions.NoMonsterNearException;
import exceptions.OutOfBoundaryException;


public class Controller {
	static Scanner sc = new Scanner(System.in);
	
	public static int getKey(Hero hero,Room currentRoom) {
		int arg = 0;
        System.out.print("Votre tour de jouer: ");
        char event = sc.next().charAt(0);
        switch (event) {
        case 'z': case 'q': case 's': case 'd': 
        	try {
        		hero.move(event,currentRoom);
			} catch (OutOfBoundaryException e) {
				System.out.println(e.getMessage());
				Game.getInstance().notifyPrinters(0);
				getKey(hero,currentRoom);
			}
        	break;
        case 'i':
			arg= 1;
			break;
        case 'a':
        	try {
        		hero.attack1(currentRoom);
			} catch (NoMonsterNearException e) {
				System.out.println(e.getMessage());
				Game.getInstance().notifyPrinters(0);
				getKey(hero,currentRoom);
			} catch(MultipleMonsterNearException e) {
				System.out.println(e.getMessage());
				Game.getInstance().notifyPrinters(0);
				chooseCase(hero, currentRoom);
        	}
        	break;
        default:
        	break;
        }
		return arg;
	}
	
	public static void chooseCase(Hero hero,Room currentRoom) {
		List<Case> list = hero.canAttack(currentRoom);
		for (Case c1 : list) {
			System.out.println(c1);
		}
		System.out.print("Quelle case voulez vous attaquer?: ");
		int choix = sc.nextInt()+1;
		if(choix <= list.size()) {
			hero.attack1(list.get(choix));
		}
		else {
			chooseCase(hero,currentRoom);
		}
		
	}
}
