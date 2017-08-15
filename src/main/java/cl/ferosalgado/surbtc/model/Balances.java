package cl.ferosalgado.surbtc.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.internal.LinkedTreeMap;

public class Balances {
	
	Object balances;
	List<Balance> balances_model;
	
	public Balances(){
		this.balances_model = new ArrayList<Balance>();
	}
	
	@SuppressWarnings("unchecked")
	public List<Balance> getBalances() {
			
		List<Balance> listBalances = (List<Balance>) balances;
		
		for(Object objectBalance : listBalances){
			
			LinkedTreeMap<String,Object>  balance = (LinkedTreeMap<String,Object>) objectBalance;
			
			Balance newBalance = new Balance();
			newBalance.setId(balance.get("id").toString());
			
			List<Object> amountObject = (List<Object>) balance.get("amount");
			Amount amount = new Amount();			
			amount.setAmount(Double.parseDouble(amountObject.get(0).toString()));
			amount.setCurrency(amountObject.get(1).toString());			
			newBalance.setAmount(amount);
			
			amountObject = (List<Object>) balance.get("available_amount");
			Amount available_amount = new Amount();			
			available_amount.setAmount(Double.parseDouble(amountObject.get(0).toString()));
			available_amount.setCurrency(amountObject.get(1).toString());			
			newBalance.setAvailable_amount(available_amount);
			
			amountObject = (List<Object>) balance.get("frozen_amount");
			Amount frozen_amount = new Amount();			
			frozen_amount.setAmount(Double.parseDouble(amountObject.get(0).toString()));
			frozen_amount.setCurrency(amountObject.get(1).toString());			
			newBalance.setFrozen_amount(frozen_amount);
			
			amountObject = (List<Object>) balance.get("pending_withdraw_amount");
			Amount pending_withdraw_amount = new Amount();			
			pending_withdraw_amount.setAmount(Double.parseDouble(amountObject.get(0).toString()));
			pending_withdraw_amount.setCurrency(amountObject.get(1).toString());			
			newBalance.setPending_withdraw_amount(pending_withdraw_amount);
			
			newBalance.setAccount_id(balance.get("account_id").toString());
			
			this.balances_model.add(newBalance);
		}
		return balances_model;
	}	
}
