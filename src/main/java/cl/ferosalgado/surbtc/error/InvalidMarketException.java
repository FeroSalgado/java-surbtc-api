package cl.ferosalgado.surbtc.error;

public class InvalidMarketException extends Exception{
	
	private static final long serialVersionUID = -7749156149585132862L;

	public InvalidMarketException(){
		
		super("The market value does not exist");
	}
}
