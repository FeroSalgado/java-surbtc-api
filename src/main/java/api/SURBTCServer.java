package api;

import util.Server;

public final class SURBTCServer {

	public static String PROTOCOL = "https";
	public static String HOST = "www.surbtc.com";
	public static String PORT = "";
	public static String PATH = "api";
	public static String VERSION = "v2";
	public static Server server = new Server(PROTOCOL,HOST,PORT,PATH,VERSION);
}
