package model;

import java.util.List;

public class Market {
	
	private String id;
	private String name;
	private String base_currency;
	private String quote_currency;
	private List<Object> minimum_order_amount;
	private Amount minimum_order_amount_model;
	
	public Market(){
		this.minimum_order_amount_model = new Amount();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBase_currency() {
		return base_currency;
	}
	public void setBase_currency(String base_currency) {
		this.base_currency = base_currency;
	}
	public String getQuote_currency() {
		return quote_currency;
	}
	public void setQuote_currency(String quote_currency) {
		this.quote_currency = quote_currency;
	}
	public Amount getMinimum_order_amount() {
		if(null != this.minimum_order_amount){
			if(this.minimum_order_amount.size() > 1){
				this.minimum_order_amount_model.setAmount(Double.parseDouble(
						this.minimum_order_amount.get(0).toString()
					)
				);
				this.minimum_order_amount_model.setCurrency(
					this.minimum_order_amount.get(1).toString()
				);
			}
		}
		return minimum_order_amount_model;
	}
	public void setMinimum_order_amount(Amount minimum_order_amount_model) {
		this.minimum_order_amount_model = minimum_order_amount_model;
	}
}
