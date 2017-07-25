package model;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {
	
	List<Object> asks;
	List<Object> bids;
	List<MarketPlace> asks_model;
	List<MarketPlace> bids_model;
	
	public OrderBook() {
		this.asks_model = new ArrayList<MarketPlace>();
		this.bids_model = new ArrayList<MarketPlace>();
	}
	
	@SuppressWarnings("unchecked")
	public List<MarketPlace> getAsks() {
		for(Object ask : asks){
			
			List<Double> askDouble = (List<Double>) ask;
			if(askDouble.size() > 1){
				
				MarketPlace marketPlace = new MarketPlace();
				marketPlace.setAmount(askDouble.get(0));
				marketPlace.setPrice(askDouble.get(1));
				
				this.asks_model.add(marketPlace);
			}
		}
		return asks_model;
	}
	public void setAsks(List<MarketPlace> asks_model) {
		this.asks_model = asks_model;
	}
	@SuppressWarnings("unchecked")
	public List<MarketPlace> getBids() {
		for(Object bid : bids){
			
			List<Double> bidDouble = (List<Double>) bid;
			if(bidDouble.size() > 1){
				
				MarketPlace marketPlace = new MarketPlace();
				marketPlace.setAmount(bidDouble.get(0));
				marketPlace.setPrice(bidDouble.get(1));
				
				this.bids_model.add(marketPlace);
			}
		}
		return bids_model;
	}
	public void setBids(List<MarketPlace> bids_model) {
		this.bids_model = bids_model;
	}	
}