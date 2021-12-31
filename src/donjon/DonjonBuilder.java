package donjon;

import java.util.ArrayList;
import java.util.List;

public class DonjonBuilder {

	private List<Room> rooms;
	
	public DonjonBuilder reset() {
		// TODO Auto-generated method stub
		this.rooms = new ArrayList<Room>();
		return this;
	}

	/*
	 * Permet de choisir le nombre de salles voulues dans le donjon
	 */
	public DonjonBuilder nbRooms(int nb) {
		for (int i=0 ; i<nb ; i++) {
			Room room = new RoomBuilder().build();
			this.rooms.add(room);
		}
		return this;
	}

	public DonjonBuilder clone(Donjon donjon) {
		this.reset();
		RoomBuilder Rb = new RoomBuilder();
		for (Room room : donjon.getRooms()) {
			this.rooms.add(Rb.clone(room).build());
		}
		return this;
	}
	/*
	 * Permet d'obtenir le donjon
	 * Si seulement cette fonction est utilisé 
	 * Renvoie un donjon par défaut avec 3 salles
	 */
	public Donjon build() {
		if (this.rooms == null || this.rooms.size()==0) {
			this.rooms = new ArrayList<Room>();
			this.nbRooms(3);
		}
		return new Donjon(rooms);
	}
	
}
