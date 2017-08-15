package cl.ferosalgado.surbtc.util;

import cl.ferosalgado.surbtc.constant.Path;

public class Server {
	
	private String protocol;
    private String host;
    private String port;
    private String path;
    private String version;
    private String url;

    public Server(String protocol,String host,String port,String path, String version){
    	
    	this.protocol = protocol;
    	this.host = host;
    	this.port = port;
    	this.path = path;
    	this.version = version;
    	
    	if(port.equals(""))
    		this.url = String.format(Path.URLPATTERN,protocol,host,path,version);
    	else
    		this.url = String.format(Path.URLPATTERNWITHPORT,protocol,host,port,path,version);
    }

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
