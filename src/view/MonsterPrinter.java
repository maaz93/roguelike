package view;

import java.util.List;

import characters.Character;
import characters.Monster;

public class MonsterPrinter {
	public static void update(List<Monster> list) {
		for (Character character : list) {
			System.out.println(character);
		}
		
	}
}
