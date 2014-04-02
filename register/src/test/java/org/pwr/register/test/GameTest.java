package org.pwr.register.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.pwr.register.dto.UserGameDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class GameTest {
	private WebResource webResource;
	private Client client;
	private static final String GAME_URI = "http://localhost:8080/register/adminPanel/game/michal";
	private static final String NEWGAME_URI = "http://localhost:8080/register/adminPanel/newGame/michal";
	
	@Before
	public void prepareConnection()
	{
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		client.addFilter(new LoggingFilter());
		
	}
	
	@Test
	public void createNewGame()
	{
		webResource = client.resource(NEWGAME_URI);
		client.addFilter(new HTTPBasicAuthFilter("test2", "test2"));
		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
		assertEquals(204, response.getStatus());
	}
	
	@Test
	public void deleteGame()
	{
		webResource = client.resource(GAME_URI);
		client.addFilter(new HTTPBasicAuthFilter("test2", "test2"));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).delete(
				ClientResponse.class);

		assertEquals(204, response.getStatus()); 
	}
	
	@Test
	public void getGame() {
		webResource = client.resource(GAME_URI);
		client.addFilter(new HTTPBasicAuthFilter("test2", "test2"));
		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
		assertEquals(200, response.getStatus());
		assertNotNull(response.getEntity(UserGameDTO.class));
	}
}
