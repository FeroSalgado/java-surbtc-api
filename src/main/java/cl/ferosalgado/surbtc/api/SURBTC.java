package cl.ferosalgado.surbtc.api;

import cl.ferosalgado.surbtc.client.ClientAuth;
import cl.ferosalgado.surbtc.util.Server;

public final class SURBTC {
	
	public static ClientAuth Auth(String ApiKey, String ApiSecret){
		
		return new ClientAuth(ApiKey, ApiSecret);
	}
	
	public static ClientAuth Auth(String ApiKey, String ApiSecret, Server serverApi){
		
		return new ClientAuth(ApiKey, ApiSecret, serverApi);
	}
}
