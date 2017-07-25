package client;

import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import api.SURBTC;
import model.Balance;
import model.Balances;
import model.Market;
import model.Markets;
import model.OrderBook;
import model.Orders;
import model.SimulateWithdrawal;
import model.Ticker;
import util.Server;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.core.Is.*;

public class ClientAuthTest {
	
    @Rule
    public WireMockRule wm = new WireMockRule();
    
	@Test
	public void tickerTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/markets/BTC-CLP/ticker"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("ticker.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			Ticker ticker = clientAuth.ticker("BTC-CLP");
			
            assertThat(ticker.getPrice_variation_24h(),
                    is(0.048));
	}
	
	@Test
	public void orderBookTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/markets/BTC-CLP/order_book"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("order_book.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			OrderBook orderBook = clientAuth.orderBook("BTC-CLP");
			
            assertThat(orderBook.getAsks().get(0).getAmount(),
                    is(1803799.9));
	}
	
	@Test
	public void marketsTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/markets"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("markets.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			Markets markets = clientAuth.markets();
			
            assertThat(markets.getMarkets().get(0).getName(),
                    is("btc-clp"));
	}
	
	@Test
	public void marketDetailTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/markets/BTC-CLP"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("market.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			Market market = clientAuth.marketDetail("BTC-CLP");
			
            assertThat(market.getName(),
                    is("btc-clp"));
	}
	
	@Test
	public void balancesTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/balances"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("balances.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			Balances balances = clientAuth.balances();
			
            assertThat(balances.getBalances().get(0).getAmount().getCurrency(),
                    is("BTC"));
	}
	
	@Test
	public void balanceDetailTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/balances/BTC"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("balance.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			Balance balance = clientAuth.balanceDetail("BTC");
			
            assertThat(balance.getId(),
                    is("BTC"));
	}
	
	@Test
	public void ordersTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(get(urlEqualTo("/api/v2/markets/BTC-CLP/orders"))
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("orders.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			Orders orders = clientAuth.orders("BTC-CLP");
			
            assertThat(orders.getOrders().get(0).getType(),
                    is("Bid"));
	}
	
	@Test
	public void simulateWithdrawalTest() 
			throws InvalidKeyException, NoSuchAlgorithmException, IOException{
		
			wm.stubFor(post(urlEqualTo("/api/v2/currencies/BTC/withdrawals"))			
			.willReturn(aResponse()
			.withHeader("Content-Type", "application/json")
			.withHeader("Accept", "application/json")
			.withBodyFile("withdrawal.json")));
			
			wm.getOptions();
			Server serverApi = new Server("http",
					"localhost",
					String.valueOf(wm.getOptions().portNumber()),
					"api",
					"v2");

			ClientAuth clientAuth = SURBTC.Auth("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", serverApi);
			SimulateWithdrawal simulateWithdrawal = clientAuth.simulateWithdrawal("BTC",100000);
			
            assertThat(simulateWithdrawal.getFee().getAmount(),
                    is(0.00085));
	}
}
