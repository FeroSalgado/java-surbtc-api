package model;

import java.util.Date;
import java.util.List;

public class Withdrawal {
	private Long id;
	private Date created_at;
	private String currency;
	private WithdrawalData withdrawal_data;
	private List<Object> amount;
	private List<Object> fee;
	private Amount amount_model;
	private Amount fee_model;
	private String state;
	
	public Withdrawal(){
		
		this.amount_model = new Amount();
		this.fee_model = new Amount();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public WithdrawalData getWithdrawal_data() {
		return withdrawal_data;
	}
	public void setWithdrawal_data(WithdrawalData withdrawal_data) {
		this.withdrawal_data = withdrawal_data;
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
		return this.amount_model;
	}
	public void setAmount(Amount amount_model) {
		this.amount_model = amount_model;
	}
	public Amount getFee() {
		if(null != this.fee){
			if(this.fee.size() > 1){
				this.fee_model.setAmount(Double.parseDouble(
						this.fee.get(0).toString()
					)
				);
				this.fee_model.setCurrency(
					this.fee.get(1).toString()
				);
			}
		}
		return this.fee_model;
	}
	public void setFee(Amount fee_model) {
		this.fee_model = fee_model;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
