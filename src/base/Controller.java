package base;
import java.util.Scanner;

import characters.Character;
import characters.Hero;
import donjon.Room;
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
				System.out.println("Mouvement impossible");
				System.out.println("Veuillez réessayer");
				Game.getInstance().notifyPrinters(0);
				getKey(hero,currentRoom);
			}
        	break;
        case 'i':
			arg= 1;
        default:
        	break;
        }
		return arg;
	}
}
