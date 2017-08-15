package cl.ferosalgado.surbtc.client;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

import cl.ferosalgado.surbtc.api.SURBTCServer;
import cl.ferosalgado.surbtc.constant.Path;
import cl.ferosalgado.surbtc.model.Ticker;
import cl.ferosalgado.surbtc.util.HttpBase;
import cl.ferosalgado.surbtc.util.Server;

public class ClientPublic {
	
	private HttpBase httpBase;
	private Server serverApi;
	
	public ClientPublic(){
		httpBase = new HttpBase();
		this.serverApi = SURBTCServer.server;
	}
	
	public ClientPublic(Server serverApi){
		httpBase = new HttpBase();
		this.serverApi = serverApi;
	}
	
	public Ticker ticker(String market) 
			throws ClientProtocolException, IOException{
		
		String urlpath[] = httpBase.urlPathFor(this.serverApi.getUrl(),Path.TICKER,market);
		String url = urlpath[0];
		
		JSONObject response = httpBase.get(url);
		
		Gson gson = new Gson();
		Ticker ticker = gson.fromJson(response.get("ticker").toString()
				,Ticker.class);
		
		return ticker;
	}
	
	public static void main(String Args[]) 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
		ClientPublic clientPublic = new ClientPublic();
		clientPublic.ticker("BTC-CLP");
	}
}
