package base;
import java.util.Scanner;

import characters.Character;
import characters.Hero;
import donjon.Room;
import exceptions.OutOfBoundaryException;


public class Controller {
	static Scanner sc = new Scanner(System.in);
	
	public static void getKey(Hero hero,Room currentRoom) {
		
        System.out.print("Votre tour de jouer: ");
        char event = sc.next().charAt(0);
        switch (event) {
        case 'z': case 'q': case 's': case 'd': 
        	try {
        		hero.move(event,currentRoom);
			} catch (OutOfBoundaryException e) {
				System.out.println("veuillez réessayer");
				getKey(hero,currentRoom);
			}
        	break;
        	
        default:
        	break;
        }
	}
}
