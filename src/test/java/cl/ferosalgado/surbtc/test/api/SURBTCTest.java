package cl.ferosalgado.surbtc.test.api;

import org.junit.Test;

import cl.ferosalgado.surbtc.api.SURBTC;
import cl.ferosalgado.surbtc.client.ClientAuth;

import org.junit.Assert;

public class SURBTCTest {
	
	@Test
	public void getNotNullClientAuth(){
		
		Assert.assertNotNull(SURBTC.Auth("", ""));
	}
	
	@Test
	public void getEqualsClassNameClientAuth(){
		
		Assert.assertEquals(SURBTC.Auth("", "").getClass().getName(),
				ClientAuth.class.getName());
	}
}
