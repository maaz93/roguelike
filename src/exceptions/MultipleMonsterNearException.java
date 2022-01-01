package exceptions;

public class MultipleMonsterNearException extends RuntimeException{
	
	public MultipleMonsterNearException(int i) {
		super("Multiple Monster Near : "+i);
		// TODO Auto-generated constructor stub
	}
}
