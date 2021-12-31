package donjon;

import java.util.ArrayList;
import java.util.List;

public class Donjon {
	private List<Room> rooms;

	
	public Donjon() {
		this.rooms = new ArrayList<Room>();
	}

	public Donjon(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
		
}
