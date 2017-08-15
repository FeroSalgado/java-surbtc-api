package cl.ferosalgado.surbtc.constant;

public enum MarketValues {

	BTC_CLP("BTC-CLP"),
	BTC_COP("BTC-COP"),
	ETH_CLP("ETH-CLP");
	
	private String market;
	
	private MarketValues(String market){		
		this.market = market;
	}
	
	public String getMarket(){
		return this.market;
	}
	
	public static boolean isMarket(String market){
		
		if(market.toUpperCase().equals(BTC_CLP.getMarket()))
			return true;
		else if(market.toUpperCase().equals(BTC_COP.getMarket()))
			return true;
		else if(market.toUpperCase().equals(ETH_CLP.getMarket()))
			return true;
		else
			return false;
	}
}
