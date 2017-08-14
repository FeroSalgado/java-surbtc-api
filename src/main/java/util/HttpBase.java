package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import client.Header;

public class HttpBase {
	
	public static final String APIURLPATTERN = "%s/%s";
	
	private String urlFor(String ulrApi,String pathArg){
		
		String url = String.format(APIURLPATTERN,
				ulrApi,
				pathArg);
				
		return url;
	}
	
	public String[] urlPathFor(String ulrApi,String path,String pathArg) 
			throws MalformedURLException{
		
		String[] urlpath = new String[2];
		
		String urlString = urlFor(ulrApi,String.format(path, pathArg));
		URL url = new URL(urlString);		
		String pathString = url.getPath();
		urlpath = new String[]{urlString,pathString};
		
		return urlpath;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject post(String url, Header header, Map<String, Object> data) 
			throws ClientProtocolException, IOException{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		
		JSONObject jsonObject = new JSONObject();
		 
		for (Map.Entry<String, Object> entry : data.entrySet()){
			jsonObject.put(entry.getKey(),entry.getValue());
		}
		
		StringEntity StringEntity = new StringEntity(jsonObject.toJSONString());
		StringEntity.setContentType(Header.getContent_Type());
		
		post.addHeader("X-SBTC-APIKEY",header.getX_SBTC_APIKEY());
		post.addHeader("X-SBTC-NONCE",header.getX_SBTC_NONCE());
		post.addHeader("X-SBTC-SIGNATURE",header.getX_SBTC_SIGNATURE());
		post.addHeader("Accept",Header.getAccept());
		
		post.setEntity(StringEntity);
		HttpResponse response = client.execute(post);
		
		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		HashMap<String,Object> hasMapResult =
		        new ObjectMapper().readValue(result.toString(), HashMap.class);
		
		JSONObject jsonObjectResult = new JSONObject(hasMapResult);
		
		return jsonObjectResult;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject put(String url, Header header, Map<String, Object> data) 
			throws ClientProtocolException, IOException{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut put = new HttpPut(url);
		
		JSONObject jsonObject = new JSONObject();
		 
		for (Map.Entry<String, Object> entry : data.entrySet()){
			jsonObject.put(entry.getKey(),entry.getValue());
		}
		
		StringEntity StringEntity = new StringEntity(jsonObject.toJSONString());
		StringEntity.setContentType(Header.getContent_Type());
		
		put.addHeader("X-SBTC-APIKEY",header.getX_SBTC_APIKEY());
		put.addHeader("X-SBTC-NONCE",header.getX_SBTC_NONCE());
		put.addHeader("X-SBTC-SIGNATURE",header.getX_SBTC_SIGNATURE());
		put.addHeader("Accept",Header.getAccept());
		
		put.setEntity(StringEntity);
		HttpResponse response = client.execute(put);
		
		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		HashMap<String,Object> hasMapResult =
		        new ObjectMapper().readValue(result.toString(), HashMap.class);
		
		JSONObject jsonObjectResult = new JSONObject(hasMapResult);
		
		return jsonObjectResult;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject get(String url) 
			throws ClientProtocolException, IOException{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		
		HttpResponse response = client.execute(get);
		
		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		HashMap<String,Object> hasMapResult =
		        new ObjectMapper().readValue(result.toString(), HashMap.class);
		
		JSONObject jsonObjectResult = new JSONObject(hasMapResult);
		
		return jsonObjectResult;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject get(String url, Header header) 
			throws ClientProtocolException, IOException{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		
		get.addHeader("X-SBTC-APIKEY",header.getX_SBTC_APIKEY());
		get.addHeader("X-SBTC-NONCE",header.getX_SBTC_NONCE());
		get.addHeader("X-SBTC-SIGNATURE",header.getX_SBTC_SIGNATURE());
		get.addHeader("Accept",Header.getAccept());
		
		HttpResponse response = client.execute(get);
		
		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		HashMap<String,Object> hasMapResult =
		        new ObjectMapper().readValue(result.toString(), HashMap.class);
		
		JSONObject jsonObjectResult = new JSONObject(hasMapResult);
		
		return jsonObjectResult;
	}
}
