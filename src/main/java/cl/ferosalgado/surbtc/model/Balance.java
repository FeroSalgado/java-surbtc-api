package cl.ferosalgado.surbtc.model;

import java.util.List;

public class Balance {
	
	private String id;
	private List<Object> amount;
	private Amount amount_model;
	private List<Object> available_amount;
	private Amount available_amount_model;
	private List<Object> frozen_amount;
	private Amount frozen_amount_model;
	private List<Object> pending_withdraw_amount;
	private Amount pending_withdraw_amount_model;
	private String account_id;
	
	public Balance(){
		this.amount_model = new Amount();
		this.available_amount_model = new Amount();
		this.frozen_amount_model = new Amount();
		this.pending_withdraw_amount_model = new Amount();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Amount getAvailable_amount() {
		if(null != this.available_amount){
			if(this.available_amount.size() > 1){
				this.available_amount_model.setAmount(Double.parseDouble(
						this.available_amount.get(0).toString()
					)
				);
				this.available_amount_model.setCurrency(
					this.available_amount.get(1).toString()
				);
			}
		}
		return available_amount_model;
	}
	public void setAvailable_amount(Amount available_amount_model) {
		this.available_amount_model = available_amount_model;
	}
	public Amount getFrozen_amount() {
		if(null != this.frozen_amount){
			if(this.frozen_amount.size() > 1){
				this.frozen_amount_model.setAmount(Double.parseDouble(
						this.available_amount.get(0).toString()
					)
				);
				this.frozen_amount_model.setCurrency(
					this.available_amount.get(1).toString()
				);
			}
		}
		return frozen_amount_model;
	}
	public void setFrozen_amount(Amount frozen_amount_model) {
		this.frozen_amount_model = frozen_amount_model;
	}
	public Amount getPending_withdraw_amount() {
		if(null != this.pending_withdraw_amount){
			if(this.pending_withdraw_amount.size() > 1){
				this.pending_withdraw_amount_model.setAmount(Double.parseDouble(
						this.pending_withdraw_amount.get(0).toString()
					)
				);
				this.pending_withdraw_amount_model.setCurrency(
					this.pending_withdraw_amount.get(1).toString()
				);
			}
		}
		return pending_withdraw_amount_model;
	}
	public void setPending_withdraw_amount(Amount pending_withdraw_amount_model) {
		this.pending_withdraw_amount_model = pending_withdraw_amount_model;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}	
}
