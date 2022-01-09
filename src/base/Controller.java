package base;
import java.util.List;
import java.util.Scanner;

import characters.Character;
import characters.Hero;
import donjon.Case;
import donjon.Donjon;
import donjon.Room;
import exceptions.MultipleMonsterNearException;
import exceptions.NoItemOnCaseException;
import exceptions.NoMonsterNearException;
import exceptions.NoStairsFoundException;
import exceptions.NotOnStairsException;
import exceptions.OutOfBoundaryException;


public class Controller {
	static Scanner sc = new Scanner(System.in);
	
	public static int getKey(Hero hero,Room currentRoom, Donjon donjon) {
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
				arg=getKey(hero,currentRoom,donjon);
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
				arg=getKey(hero,currentRoom,donjon);
				break;
			} catch(MultipleMonsterNearException e) {
				System.out.println(e.getMessage());
				Game.getInstance().notifyPrinters(0);
				chooseCase(hero, currentRoom);
        	}
        	break;
        	
        //Descendre ds le donjon
        case'o':
        	try {
        		hero.takeStairs(event,currentRoom,donjon);
        		arg=2;
        	}
        	catch (OutOfBoundaryException e) {
        		System.out.println(e.getMessage());
        		Game.getInstance().notifyPrinters(0);
				arg=getKey(hero,currentRoom,donjon);
        	}
        	catch (NotOnStairsException e) {
        		System.out.println(e.getMessage());
        		Game.getInstance().notifyPrinters(0);
				arg=getKey(hero,currentRoom,donjon);
        	}
        	break;
        //Monter ds le donjon 	
        case'p':
        	try {
        		hero.takeStairs(event,currentRoom,donjon);
        		arg=3;
        	}
        	catch (OutOfBoundaryException e) {
        		System.out.println(e.getMessage());
        		Game.getInstance().notifyPrinters(0);
				arg=getKey(hero,currentRoom,donjon);
        	}
        	catch (NotOnStairsException e) {
        		System.out.println(e.getMessage());
        		Game.getInstance().notifyPrinters(0);
				arg=getKey(hero,currentRoom,donjon);
        	}
        	break;
        case't':
        	try {
				hero.takeItem(currentRoom);
			} catch (NoItemOnCaseException e) {
				System.out.println(e.getMessage());
        		Game.getInstance().notifyPrinters(0);
				arg=getKey(hero,currentRoom,donjon);
			}
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
		int choix = 0;
		if (sc.hasNextInt()) {
		    choix = sc.nextInt();
		} else {
		    sc.next();   // get the inputted non integer from scanner
		    choix = -1;
		}
		
		if(choix == -1 ) {
			System.out.println("Entrez un entier valides");
			chooseCase(hero,currentRoom);
		}
		else if(choix < list.size()) {
			hero.attack1(list.get(choix));
		}
		else {
			chooseCase(hero,currentRoom);
		}
		
	}
}
