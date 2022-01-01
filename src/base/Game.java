package base;

import characters.Hero;
import donjon.Donjon;
import donjon.DonjonBuilder;
import donjon.Room;
import view.HeroPrinter;
import view.RoomPrinter;

public class Game {
	private static Game game;
	private Room currentRoom;
	private Hero hero;
	
	public Game() {
		super();
		game = this;
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
			Controller.getKey(hero,currentRoom);
			notifyPrinters();
		}
	}
	
	public void notifyPrinters() {
		RoomPrinter.update(currentRoom);
		HeroPrinter.update(hero);
	}
	

}
