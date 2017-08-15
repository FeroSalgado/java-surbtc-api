package cl.ferosalgado.surbtc.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.internal.LinkedTreeMap;

public class Markets {

	Object markets;
	List<Market> markets_model;
	
	public Markets(){
		this.markets_model = new ArrayList<Market>();
	}

	@SuppressWarnings("unchecked")
	public List<Market> getMarkets() {
			
		List<Market> listMarkets = (List<Market>) markets;
		
		for(Object objectMarket : listMarkets){
			
			LinkedTreeMap<String,Object>  market = (LinkedTreeMap<String,Object>) objectMarket;
			
			Market newMarket = new Market();
			newMarket.setId(market.get("id").toString());
			newMarket.setName(market.get("name").toString());
			newMarket.setBase_currency(market.get("base_currency").toString());
			newMarket.setQuote_currency(market.get("quote_currency").toString());
			
			List<Object> amount = (List<Object>) market.get("minimum_order_amount");
			Amount minimum_order_amount = new Amount();			
			minimum_order_amount.setAmount(Double.parseDouble(amount.get(0).toString()));
			minimum_order_amount.setCurrency(amount.get(1).toString());
			
			newMarket.setMinimum_order_amount(minimum_order_amount);
			
			this.markets_model.add(newMarket);
		}
		return markets_model;
	}

	public void setMarkets(List<Market> markets_model) {
		this.markets_model = markets_model;
	}
}
