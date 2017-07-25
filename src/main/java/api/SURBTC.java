package api;

import client.ClientAuth;
import util.Server;

public final class SURBTC {
	
	public static ClientAuth Auth(String ApiKey, String ApiSecret){
		
		return new ClientAuth(ApiKey, ApiSecret);
	}
	
	public static ClientAuth Auth(String ApiKey, String ApiSecret, Server serverApi){
		
		return new ClientAuth(ApiKey, ApiSecret, serverApi);
	}
}
