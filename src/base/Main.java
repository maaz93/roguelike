package base;

import java.util.ArrayList;
import java.util.List;

import characters.Character;
import characters.FabriqueMonster;
import characters.Monster;
import donjon.Case;
import donjon.CaseEscalier;
import donjon.Donjon;
import donjon.DonjonBuilder;
import donjon.Plateau;
import donjon.Room;
import item.FabriqueItem;
import item.Inventaire;
import item.Item;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game();
		game.run();
		
	}

}
