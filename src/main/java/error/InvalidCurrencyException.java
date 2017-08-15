package error;

public class InvalidCurrencyException extends Exception{
	
	private static final long serialVersionUID = -4084422898967107992L;

	public InvalidCurrencyException(){
		
		super("The currency value does not exist");		
	}
}
