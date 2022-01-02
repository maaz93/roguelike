package donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import characters.Character;
import item.Item;

public class CaseEscalier extends Case {

	public CaseEscalier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseEscalier(int coorX, int coorY) {
		super(coorX, coorY);
		// TODO Auto-generated constructor stub
	}

	public CaseEscalier(String description, String name, List<Item> items, List<Character> characters, int coorX,
			int coorY) {
		super(description, name, items, characters, coorX, coorY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.print("/");
	}

	@Override
	public String toString() {
		return "CaseEscalier [coorX= " + super.getX() +", coorY= " + super.getY() +", name=" + super.getName() + ", items=" + super.getItems() + ", characters=" + super.getCharacters()
				+ "]" ;
	}
	
	@Override
	public Case clone(){
		List<Character> cloneListCharacter  = new ArrayList<Character>();
		for (Character character : getCharacters()) {
			try {
				cloneListCharacter.add(character.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Item> cloneListItem  = getItems().stream().map(i -> i.clone() )
				.collect(Collectors.toCollection(ArrayList::new));
		
		return new CaseEscalier(getDescription(),getName(),cloneListItem,cloneListCharacter,getX(),getY());
	}
}
