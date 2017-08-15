package cl.ferosalgado.surbtc.model;

import java.util.List;

public class Ticker {
	
	private List<Object> last_price;
	private List<Object> min_ask;
	private List<Object> max_bid;
	private List<Object> volume;
	private Amount last_price_model;
	private Amount min_ask_model;
	private Amount max_bid_model;
	private Amount volume_model;
	private Double price_variation_24h;
	private Double price_variation_7d;
	
	public Ticker(){
		
		this.last_price_model = new Amount();
		this.min_ask_model = new Amount();
		this.max_bid_model = new Amount();
		this.volume_model = new Amount();
	}
	
	public Amount getLast_price() {
		if(null != this.last_price){
			if(this.last_price.size() > 1){
				this.last_price_model.setAmount(Double.parseDouble(
						this.last_price.get(0).toString()
					)
				);
				this.last_price_model.setCurrency(
					this.last_price.get(1).toString()
				);
			}
		}
		return last_price_model;
	}
	public void setLast_price(Amount last_price_model) {
		this.last_price_model = last_price_model;
	}
	public Amount getMin_ask() {
		if(null != this.min_ask){
			if(this.min_ask.size() > 1){
				this.min_ask_model.setAmount(Double.parseDouble(
						this.min_ask.get(0).toString()
					)
				);
				this.min_ask_model.setCurrency(
					this.min_ask.get(1).toString()
				);
			}
		}
		return min_ask_model;
	}
	public void setMin_ask(Amount min_ask_model) {
		this.min_ask_model = min_ask_model;
	}
	public Amount getMax_bid() {
		if(null != this.max_bid){
			if(this.max_bid.size() > 1){
				this.max_bid_model.setAmount(Double.parseDouble(
						this.max_bid.get(0).toString()
					)
				);
				this.max_bid_model.setCurrency(
					this.max_bid.get(1).toString()
				);
			}
		}
		return max_bid_model;
	}
	public void setMax_bid(Amount max_bid_model) {
		this.max_bid_model = max_bid_model;
	}
	public Amount getVolume() {
		if(null != this.volume){
			if(this.volume.size() > 1){
				this.volume_model.setAmount(Double.parseDouble(
						this.volume.get(0).toString()
					)
				);
				this.volume_model.setCurrency(
					this.volume.get(1).toString()
				);
			}
		}
		return volume_model;
	}
	public void setVolume(Amount volume_model) {
		this.volume_model = volume_model;
	}
	public Double getPrice_variation_24h() {
		return price_variation_24h;
	}
	public void setPrice_variation_24h(Double price_variation_24h) {
		this.price_variation_24h = price_variation_24h;
	}
	public Double getPrice_variation_7d() {
		return price_variation_7d;
	}
	public void setPrice_variation_7d(Double price_variation_7d) {
		this.price_variation_7d = price_variation_7d;
	}
}
