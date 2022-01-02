package donjon;

import java.util.ArrayList;
import java.util.stream.Collectors;

import exceptions.NoStairsFoundException;


public class Plateau<T> extends ArrayList<ArrayList<Case>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Plateau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plateau(int longueur,int hauteur) {
		for (int i = 0; i < hauteur; i++) {
			ArrayList<Case> e = new ArrayList<Case>();
			for (int j = 0; j < longueur; j++) {
				e.add(new Case(j,i));
			}
			this.add(e);
		}
	}

	public Case findStairs() throws NoStairsFoundException{
		for (ArrayList<Case> arrayList : this) {
			for (Case case1 : arrayList) {
				if(case1 instanceof CaseEscalier) {
					return case1;
				}
			}
		}
		throw new NoStairsFoundException();
	}

	@Override
	public Plateau<T> clone() {
		// TODO Auto-generated method stub
		Plateau<T> newplat = new Plateau<T>();
		for (ArrayList<Case> arrayList : this) {
			newplat.add(arrayList.stream().map(c -> c.clone()).collect(Collectors.toCollection(ArrayList::new)));
		}
		return newplat;
	}
	
}
