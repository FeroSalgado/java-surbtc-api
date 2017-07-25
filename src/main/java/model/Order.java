package model;

import java.util.List;

public class Order {
	
	private String id;
	private String type;
	private String state;
	private String created_at;
	private String market_id;
	private String account_id;
	private String fee_currency;
	private String price_type;
	private String limit;
	private List<Object> amount;
	private Amount amount_model;
	private List<Object> original_amount;
	private Amount original_amount_model;
	private List<Object> traded_amount;
	private Amount traded_amount_model;
	private List<Object> total_exchanged;
	private Amount total_exchanged_model;
	private List<Object> paid_fee;
	private Amount paid_fee_model;
	
	public Order(){
		
		this.amount_model = new Amount();
		this.original_amount_model = new Amount();
		this.traded_amount_model = new Amount();
		this.total_exchanged_model = new Amount();
		this.paid_fee_model = new Amount();		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getMarket_id() {
		return market_id;
	}
	public void setMarket_id(String market_id) {
		this.market_id = market_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getFee_currency() {
		return fee_currency;
	}
	public void setFee_currency(String fee_currency) {
		this.fee_currency = fee_currency;
	}
	public String getPrice_type() {
		return price_type;
	}
	public void setPrice_type(String price_type) {
		this.price_type = price_type;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public Amount getAmount() {
		if(null != this.amount){
			if(this.amount.size() > 1){
				this.amount_model.setAmount(Double.parseDouble(
						this.amount.get(0).toString()
					)
				);
				this.amount_model.setCurrency(
					this.amount.get(1).toString()
				);
			}
		}
		return amount_model;
	}
	public void setAmount(Amount amount_model) {
		this.amount_model = amount_model;
	}
	public Amount getOriginal_amount() {
		if(null != this.original_amount){
			if(this.original_amount.size() > 1){
				this.original_amount_model.setAmount(Double.parseDouble(
						this.original_amount.get(0).toString()
					)
				);
				this.original_amount_model.setCurrency(
					this.original_amount.get(1).toString()
				);
			}
		}
		return original_amount_model;
	}
	public void setOriginal_amount(Amount original_amount_model) {
		this.original_amount_model = original_amount_model;
	}
	public Amount getTraded_amount() {
		if(null != this.traded_amount){
			if(this.traded_amount.size() > 1){
				this.traded_amount_model.setAmount(Double.parseDouble(
						this.traded_amount.get(0).toString()
					)
				);
				this.traded_amount_model.setCurrency(
					this.traded_amount.get(1).toString()
				);
			}
		}
		return traded_amount_model;
	}
	public void setTraded_amount(Amount traded_amount_model) {
		this.traded_amount_model = traded_amount_model;
	}
	public Amount getTotal_exchanged() {
		if(null != this.total_exchanged){
			if(this.total_exchanged.size() > 1){
				this.total_exchanged_model.setAmount(Double.parseDouble(
						this.total_exchanged.get(0).toString()
					)
				);
				this.total_exchanged_model.setCurrency(
					this.total_exchanged.get(1).toString()
				);
			}
		}
		return total_exchanged_model;
	}
	public void setTotal_exchanged(Amount total_exchanged_model) {
		this.total_exchanged_model = total_exchanged_model;
	}
	public Amount getPaid_fee() {
		if(null != this.paid_fee){
			if(this.paid_fee.size() > 1){
				this.paid_fee_model.setAmount(Double.parseDouble(
						this.paid_fee.get(0).toString()
					)
				);
				this.paid_fee_model.setCurrency(
					this.paid_fee.get(1).toString()
				);
			}
		}
		return paid_fee_model;
	}
	public void setPaid_fee(Amount paid_fee_model) {
		this.paid_fee_model = paid_fee_model;
	}
}
