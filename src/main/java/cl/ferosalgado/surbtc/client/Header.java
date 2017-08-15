package cl.ferosalgado.surbtc.client;

public class Header {

	private String X_SBTC_APIKEY;
	private String X_SBTC_NONCE;
	private String X_SBTC_SIGNATURE;
	private static String Content_Type = "application/json";
	private static String Accept = "application/json";
	
	public String getX_SBTC_APIKEY() {
		return X_SBTC_APIKEY;
	}
	
	public void setX_SBTC_APIKEY(String x_SBTC_APIKEY) {
		X_SBTC_APIKEY = x_SBTC_APIKEY;
	}
	
	public String getX_SBTC_NONCE() {
		return X_SBTC_NONCE;
	}
	
	public void setX_SBTC_NONCE(String x_SBTC_NONCE) {
		X_SBTC_NONCE = x_SBTC_NONCE;
	}
	
	public String getX_SBTC_SIGNATURE() {
		return X_SBTC_SIGNATURE;
	}
	
	public void setX_SBTC_SIGNATURE(String x_SBTC_SIGNATURE) {
		X_SBTC_SIGNATURE = x_SBTC_SIGNATURE;
	}
	
	public static String getContent_Type() {
		return Content_Type;
	}
	
	public static void setContent_Type(String content_Type) {
		Content_Type = content_Type;
	}

	public static String getAccept() {
		return Accept;
	}

	public static void setAccept(String accept) {
		Accept = accept;
	}
}
