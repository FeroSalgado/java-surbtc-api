package client;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.client.ClientProtocolException;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import api.SURBTCServer;
import constant.CurrencyValues;
import constant.MarketValues;
import constant.Path;
import error.InvalidCurrencyException;
import error.InvalidMarketException;
import model.Balance;
import model.Balances;
import model.Market;
import model.Markets;
import model.OrderBook;
import model.Orders;
import model.Withdrawal;
import model.Ticker;
import util.HttpBase;
import util.Common;
import util.Server;

public class ClientAuth {
	
	private String ApiKey; 
	private String ApiSecret;
	private Server serverApi;
	
	
	private HttpBase httpBase;
	private static final String HMAC_SHA384_ALGORITHM = "HmacSHA384";
	
	public ClientAuth(String ApiKey, String ApiSecret){
		httpBase = new HttpBase();
		this.ApiKey = ApiKey;
		this.ApiSecret = ApiSecret;
		this.serverApi = SURBTCServer.server;
	}
	
	public ClientAuth(String ApiKey, String ApiSecret, Server serverApi){
		httpBase = new HttpBase();
		this.ApiKey = ApiKey;
		this.ApiSecret = ApiSecret;
		this.serverApi = serverApi;
	}
	
	public Ticker ticker(String market) 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidMarketException{
		
		if(!MarketValues.isMarket(market))
			throw new InvalidMarketException();
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.TICKER,market);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();
		Ticker ticker = gson.fromJson(response.get("ticker").toString()
				,Ticker.class);
		
		return ticker;
	}
	
	public OrderBook orderBook(String market) 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidMarketException{
		
		if(!MarketValues.isMarket(market))
			throw new InvalidMarketException();
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.ORDER_BOOK,market);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();
		OrderBook orderBook = gson.fromJson(response.get("order_book").toString()
				,OrderBook.class);
		
		return orderBook;
	}
	
	public Markets markets() 
			throws InvalidKeyException, NoSuchAlgorithmException, ClientProtocolException, IOException{
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.MARKETS,"");
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();
		Markets Markets = gson.fromJson(response.toJSONString()
				,Markets.class);
		
		return Markets;
	}
	
	public Market marketDetail(String market) 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidMarketException{
		
		if(!MarketValues.isMarket(market))
			throw new InvalidMarketException();
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.MARKET_DETAILS,market);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();
		Market marketDetail = gson.fromJson(response.get("market").toString()
				,Market.class);
		
		return marketDetail;
	}
	
	public Balances balances() 
			throws InvalidKeyException, NoSuchAlgorithmException, ClientProtocolException, IOException{
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.BALANCES,"");
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();
		Balances balances = gson.fromJson(response.toJSONString()
				,Balances.class);
		
		return balances;
	}
	
	public Balance balanceDetail(String currency) 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidCurrencyException{
		
		if(!CurrencyValues.isCurrency(currency))
			throw new InvalidCurrencyException();
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.BALANCE_DETAIL,currency);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();
		Balance balanceDetail = gson.fromJson(response.get("balance").toString()
				,Balance.class);
		
		return balanceDetail;
	}
	
	public Orders orders(String market)
		throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidMarketException{
		
		if(!MarketValues.isMarket(market))
			throw new InvalidMarketException();
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.ORDERS,market);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		Gson gson = new Gson();		
		Orders orders = gson.fromJson(response.toJSONString()
				,Orders.class);
		
		return orders;
	}
	
	public void depositHistory(String currency)
		throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidCurrencyException{
		
		if(!CurrencyValues.isCurrency(currency))
			throw new InvalidCurrencyException();
			
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.DEPOSITS,currency);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		System.out.println(response.toJSONString());
	}
	
	public void withdrawalHistory(String currency)
		throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidCurrencyException{
		
		if(!CurrencyValues.isCurrency(currency))
			throw new InvalidCurrencyException();
			
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.WITHDRAWAL,currency);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("GET", path);
		JSONObject response = httpBase.get(url,header);
		
		System.out.println(response.toJSONString());
	}
	
	public void receiveAddress(String currency)
		throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidCurrencyException{
		
		if(!CurrencyValues.isCurrency(currency))
			throw new InvalidCurrencyException();
		
		Map<String, Object> payload = new HashMap<String, Object>();
			
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.RECEIVE_ADDRESSES,currency);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("POST", path, payload);
		JSONObject response = httpBase.post(url,header,payload);
		
		System.out.println(url);
		System.out.println(response.toJSONString());
	}
	
	
	public Withdrawal simulateWithdrawal(String currency, float amount) 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException, InvalidCurrencyException{
		
		if(!CurrencyValues.isCurrency(currency))
			throw new InvalidCurrencyException();
		
		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put("currency", currency);
		payload.put("amount", Float.toString(amount));
		payload.put("simulate", true);
		payload.put("amount_includes_fee", true);
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.WITHDRAWAL, currency);
		String url = urlpath[0];
		String path = urlpath[1];
		
		Header header = signPayload("POST", path, payload);
		JSONObject response = httpBase.post(url,header,payload);
		
		Gson gson = new Gson();
		Withdrawal withdrawal = gson.fromJson(response.get("withdrawal").toString()
				,Withdrawal.class);
		
		return withdrawal;
	}
	
	@SuppressWarnings("unchecked")
	private Header signPayload(String method, String path, Map<String, Object> payload) 
			throws NoSuchAlgorithmException, InvalidKeyException{
		
		String nonce = Common.getNonce();
		String route = path;
		
		JSONObject jsonObject = new JSONObject();
			 
		for (Map.Entry<String, Object> entry : payload.entrySet()){
			jsonObject.put(entry.getKey(),entry.getValue());
		}
		
		byte[] encodedBody = Base64.encodeBase64(jsonObject.toString().getBytes());
		String msg = method + " " + route + " " + new String(encodedBody) + " " + nonce;
		 
		Key signingKey = new SecretKeySpec(ApiSecret.getBytes(), HMAC_SHA384_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA384_ALGORITHM);
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(msg.getBytes());
		char[] signature = Hex.encodeHex(rawHmac);
		 
		Header header = new Header();
		header.setX_SBTC_APIKEY(this.ApiKey);
		header.setX_SBTC_NONCE(nonce);
		header.setX_SBTC_SIGNATURE(String.valueOf(signature));
		 
		
		return header;
	}
	
	private Header signPayload(String method, String path) 
			throws NoSuchAlgorithmException, InvalidKeyException{
		
		String nonce = Common.getNonce();
		String route = path;
		
		String msg = method + " " + route + " " + nonce;
			 
		Key signingKey = new SecretKeySpec(ApiSecret.getBytes(), HMAC_SHA384_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA384_ALGORITHM);
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(msg.getBytes());
		char[] signature = Hex.encodeHex(rawHmac);
		 
		Header header = new Header();
		header.setX_SBTC_APIKEY(this.ApiKey);
		header.setX_SBTC_NONCE(nonce);
		header.setX_SBTC_SIGNATURE(String.valueOf(signature));
		 
		
		return header;
	}
}