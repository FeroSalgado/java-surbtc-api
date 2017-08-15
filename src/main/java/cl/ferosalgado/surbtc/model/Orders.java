package cl.ferosalgado.surbtc.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.internal.LinkedTreeMap;

public class Orders {
	
	Object orders;
	List<Order> orders_model;
	Meta meta;
	
	public Orders(){
		this.orders_model = new ArrayList<Order>();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		
		List<Order> listOrders = (List<Order>) orders;
		
		for(Object objectOrder : listOrders){
			
			LinkedTreeMap<String,Object>  order = (LinkedTreeMap<String,Object>) objectOrder;
			
			Order newOrder = new Order();
			newOrder.setId(order.get("id").toString());
			newOrder.setType(order.get("type").toString());
			newOrder.setState(order.get("state").toString());
			newOrder.setCreated_at(order.get("created_at").toString());
			newOrder.setMarket_id(order.get("market_id").toString());
			newOrder.setAccount_id(order.get("account_id").toString());
			newOrder.setFee_currency(order.get("fee_currency").toString());
			newOrder.setPrice_type(order.get("price_type").toString());
			newOrder.setLimit((null != order.get("limit"))?order.get("limit").toString():"");	
			
			List<Object> amountObject = (List<Object>) order.get("amount");
			Amount amount = new Amount();			
			amount.setAmount(Double.parseDouble(amountObject.get(0).toString()));
			amount.setCurrency(amountObject.get(1).toString());
			newOrder.setAmount(amount);
			
			List<Object> original_amount = (List<Object>) order.get("original_amount");
			amount = new Amount();			
			amount.setAmount(Double.parseDouble(original_amount.get(0).toString()));
			amount.setCurrency(original_amount.get(1).toString());
			newOrder.setOriginal_amount(amount);
			
			List<Object> traded_amount = (List<Object>) order.get("traded_amount");
			amount = new Amount();			
			amount.setAmount(Double.parseDouble(traded_amount.get(0).toString()));
			amount.setCurrency(traded_amount.get(1).toString());
			newOrder.setTraded_amount(amount);
			
			List<Object> total_exchanged = (List<Object>) order.get("total_exchanged");
			amount = new Amount();			
			amount.setAmount(Double.parseDouble(total_exchanged.get(0).toString()));
			amount.setCurrency(total_exchanged.get(1).toString());
			newOrder.setTotal_exchanged(amount);
			
			List<Object> paid_fee = (List<Object>) order.get("paid_fee");
			amount = new Amount();			
			amount.setAmount(Double.parseDouble(paid_fee.get(0).toString()));
			amount.setCurrency(paid_fee.get(1).toString());
			newOrder.setPaid_fee(amount);
			
			this.orders_model.add(newOrder);
		}
		
		return orders_model;
	}
	public void setOrders(List<Order> orders_model) {
		this.orders_model = orders_model;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
}
