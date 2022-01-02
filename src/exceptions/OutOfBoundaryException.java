package exceptions;

public class OutOfBoundaryException extends RuntimeException{

	public OutOfBoundaryException() {
		super("Mouvement impossible\nVeuillez Reessayer ");
		// TODO Auto-generated constructor stub
	}
	public OutOfBoundaryException(String msg) {
		super("Out of boundary \n"+msg);
		// TODO Auto-generated constructor stub
	}


}
