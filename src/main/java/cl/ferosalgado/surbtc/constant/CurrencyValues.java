package cl.ferosalgado.surbtc.constant;

public enum CurrencyValues {
	
	BTC("BTC"),
	CLP("CLP"),
	COP("COP"),
	ETH("ETH");
	
	private String currency;
	
	private CurrencyValues(String currency){
		this.currency = currency;		
	}
	
	public String getCurrency(){
		return this.currency;
	}
	
	public static boolean isCurrency(String currency){
		
		if(currency.toUpperCase().equals(BTC.getCurrency()))
			return true;
		else if(currency.toUpperCase().equals(CLP.getCurrency()))
			return true;
		else if(currency.toUpperCase().equals(COP.getCurrency()))
			return true;
		else if(currency.toUpperCase().equals(ETH.getCurrency()))
			return true;
		else
			return false;
	}
}
