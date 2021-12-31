package exceptions;

public class OutOfBoundaryException extends RuntimeException{

	public OutOfBoundaryException() {
		super("Out of boundary ");
		// TODO Auto-generated constructor stub
	}
	public OutOfBoundaryException(String msg) {
		super("Out of boundary "+msg);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}


}
