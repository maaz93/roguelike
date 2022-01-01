package base;

import java.util.List;

import characters.Hero;
import donjon.Donjon;
import donjon.DonjonBuilder;
import donjon.Room;
import view.HeroPrinter;
import view.InventairePrinter;
import view.RoomPrinter;

public class Game {
	private static Game game;
	private Room currentRoom;
	private Hero hero;
	private List<AImonster> AImonsters;
	
	public Game() {
		super();
		game = this;
	}

	public static Game getInstance() {
		return game;
	}
	public List<AImonster> getAImonsters() {
		return AImonsters;
	}

	public void setAImonsters(List<AImonster> aImonsters) {
		AImonsters = aImonsters;
	}

	public void startGame() {
		hero = new Hero();
		DonjonBuilder DB = new DonjonBuilder();
		Donjon donjon = DB.build();
		donjon.getRooms().get(0).getPlateau().get(0).get(0).addAcharacter(hero);
		this.currentRoom= donjon.getRooms().get(0);
	}
	
	public void run() {
		startGame();
		loop();
	}
	
	public void loop() {
		while (hero.isAlive()) {
			int arg = Controller.getKey(hero,currentRoom);
			notifyPrinters(arg);
			
		}
	}
	
	public void notifyPrinters(int arg) {
		switch (arg) {
		case 0:
			RoomPrinter.update(currentRoom);
			HeroPrinter.update(hero);
			break;
		case 1:
			RoomPrinter.update(currentRoom);
			HeroPrinter.update(hero);
			InventairePrinter.update(hero.getInventaire());
			break;
			
		}
		System.out.println();	
	}
	
	public void monstersTurn() {
		if(currentRoom.getMonsters().size() > 0) {
			
		}
	}

}
