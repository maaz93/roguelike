package exceptions;

public class NoStairsFoundException extends RuntimeException{

	public NoStairsFoundException() {
		super("Pas d'escaliers trouvee, lien entre 2 etages impossible");
		// TODO Auto-generated constructor stub
	}

}
