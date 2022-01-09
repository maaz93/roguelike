package donjon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import item.Item;
import characters.Character;

public class Case {
	private String description;
	private String name;
	private List<Item> items;
	private List<Character> characters;
	private int coorX;
	private int coorY;
	//private Room room;
	
	
	public Case() {
		this.description = "case vide";
		this.items = new ArrayList<Item>();
		this.characters = new ArrayList<Character>();
	}

	public Case(String description, String name, List<Item> items, List<Character> characters,int coorX, int coorY) {
		super();
		this.description = description;
		this.name = name;
		this.items = items;
		this.characters = characters;
		this.coorX = coorX;
		this.coorY = coorY;
	}
	
	public Case(int coorX, int coorY) {
		this();
		this.coorX = coorX;
		this.coorY = coorY;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public void addAnItem(Item item) {
		this.items.add(item);
	}
	public void deleteAnItem(Item item) {
		this.items.remove(item);
	}
	public void deleteItems(List<Item> items) {
		this.items.removeAll(items);
	}
	public List<Character> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
	public void addAcharacter(Character character) {
		this.characters.add(character);
		character.setPosition(this);
	}
	public void deleteAcharacter(Character character) {
		this.characters.remove(character);
		character.setPosition(null);
	}
	public int getX() {
		return coorX;
	}

	public void setX(int coorX) {
		this.coorX = coorX;
	}

	public int getY() {
		return coorY;
	}

	public void setY(int coorY) {
		this.coorY = coorY;
	}


	@Override
	public String toString() {
		return "Case [coorX= " + coorX +", coorY= " + coorY +", name=" + name + ", items=" + items + ", characters=" + characters
				+ "]" ;
	}

	public void draw() {
		if(this.characters.size() > 0) {
			if(this.items.size()>0) {
				System.out.print("M");
			}
			else if(this.characters.size() !=1) {
				System.out.print("M");
				//System.out.println(toString());
			}
			else {
				characters.get(0).getSymbol();
			}	
		}
		else if(this.items.size() > 0){
			if(this.characters.size()>0) {
				System.out.print("M");
			}
			else if(this.items.size() !=1) {
				System.out.print("M");
			}
			else {
			items.get(0).getSymbol();
			}
		}
		else {
			System.out.print(" ");
		}
		
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
		
		return new Case(getDescription(),getName(),cloneListItem,cloneListCharacter,getX(),getY());
	}
	
	
}
