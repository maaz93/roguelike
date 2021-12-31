package item;

import java.util.ArrayList;
import java.util.Collection;

public class Inventaire extends ArrayList<Item> {


	private int MaxCapacity;
	public Inventaire() {
		super();
		MaxCapacity=9;
		// TODO Auto-generated constructor stub
	}
	

	public Inventaire(int maxCapacity) {
		super();
		MaxCapacity = maxCapacity;
	}

	@Override
	public boolean add(Item e) {
		// TODO Auto-generated method stub
		if (this.size() == MaxCapacity) {
			return false;
		}
		return super.add(e);
	}
	
	
	@Override
	public boolean addAll(Collection<? extends Item> c) {
		// TODO Auto-generated method stub
		if (c.size() + this.size()>MaxCapacity) {
			return false;
		}
		return super.addAll(c);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}

}
