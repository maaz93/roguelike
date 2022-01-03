package base;

import java.util.List;

import characters.Hero;
import donjon.Donjon;
import donjon.DonjonBuilder;
import donjon.DonjonBuilderXML;
import donjon.Room;
import view.HeroPrinter;
import view.InventairePrinter;
import view.MonsterPrinter;
import view.RoomPrinter;

public class Game {
	private static Game game;
	private Donjon donjon;
	private Room currentRoom;
	private Hero hero;
	
	public Game() {
		super();
		game = this;
	}

	public static Game getInstance() {
		return game;
	}

	public void startRandomGame() {
		hero = new Hero();
		DonjonBuilder DB = new DonjonBuilder();
		this.donjon = DB.build();
		donjon.getRooms().get(0).getPlateau().get(0).get(0).addAcharacter(hero);
		this.currentRoom= donjon.getRooms().get(0);
		notifyPrinters(0);
	}
	
	public void startGame() {
		DonjonBuilderXML DB = new DonjonBuilderXML();
		donjon = DB.build(System.getProperty("user.dir")+"/src/ressources/donjon1.xml");
		hero = DB.getHero();
		currentRoom = DB.getCurrentRoom();
		notifyPrinters(0);
	}
	
	public void run() {
		startGame();
		loop();
	}
	
	public void loop() {
		while (hero.isAlive()) {
			if(!donjon.NoMonstersLeft()) {
				int arg = Controller.getKey(hero,currentRoom,donjon);

				//si la room doit être change
				if(arg == 2) {
					System.out.println(donjon.getRooms().indexOf(currentRoom)-1);
					currentRoom = donjon.getRooms().get(donjon.getRooms().indexOf(currentRoom)-1);
					notifyPrinters(0);
				}
				else if (arg == 3) {
					System.out.println(donjon.getRooms().indexOf(currentRoom)+1);
					currentRoom = donjon.getRooms().get(donjon.getRooms().indexOf(currentRoom)+1);
					notifyPrinters(0);
				}
				else if(arg==1) {
					notifyPrinters(1);
				}
				else {
					currentRoom.removeDeadMonsters();
					monstersTurn();
					notifyPrinters(0);
				}
			}else {
				System.out.println("Felicitations ! Vous avez gagne");
				break;
			}
		}
		if(!hero.isAlive()) {
			System.out.println("Vous etes mort! Vous avez perdu");
		}
		
	}
	
	public void notifyPrinters(int arg) {
		switch (arg) {
		
		case 0:
			RoomPrinter.update(currentRoom);
			MonsterPrinter.update(currentRoom.getMonsters());
			HeroPrinter.update(hero);
			break;
			
		case 1:
			RoomPrinter.update(currentRoom);
			MonsterPrinter.update(currentRoom.getMonsters());
			HeroPrinter.update(hero);
			InventairePrinter.update(hero.getInventaire());
			break;
			
		}
		System.out.println();	
	}
	
	public void monstersTurn() {
		
		if(currentRoom.getMonsters().size() > 0) {
			currentRoom.getMonsters().forEach(m -> new AImonster(m,hero,currentRoom).jouerTour());
		}

	}
	

}
