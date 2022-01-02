package base;

import java.util.List;

import characters.Hero;
import donjon.Donjon;
import donjon.DonjonBuilder;
import donjon.Room;
import view.HeroPrinter;
import view.InventairePrinter;
import view.MonsterPrinter;
import view.RoomPrinter;

public class Game {
	private static Game game;
	private Room currentRoom;
	private Hero hero;
	
	public Game() {
		super();
		game = this;
	}

	public static Game getInstance() {
		return game;
	}

	public void startGame() {
		hero = new Hero();
		DonjonBuilder DB = new DonjonBuilder();
		Donjon donjon = DB.build();
		donjon.getRooms().get(0).getPlateau().get(0).get(0).addAcharacter(hero);
		this.currentRoom= donjon.getRooms().get(0);
		notifyPrinters(0);
	}
	
	public void run() {
		startGame();
		loop();
	}
	
	public void loop() {
		while (hero.isAlive()) {
			int arg = Controller.getKey(hero,currentRoom);
			if(arg != 0) {
				notifyPrinters(arg);
			}
			else {
				currentRoom.removeDeadMonsters();
				monstersTurn();
				notifyPrinters(arg);
			}
			
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
