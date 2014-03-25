package org.pwr.register.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class LoginTest  {

	private WebResource webResource;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/register/login/";
	
	@Before
	public void prepareConnection()
	{
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		client.addFilter(new LoggingFilter());
		webResource = client.resource(BASE_URI);
	}
	
	@Test
	public void correctLogin()
	{
		client.addFilter(new HTTPBasicAuthFilter("test", "test"));
		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
		assertEquals(204, response.getStatus()); //no content
	}
	
	@Test
	public void wrongLogin()
	{
		client.addFilter(new HTTPBasicAuthFilter("test", "test123"));
		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
		assertEquals(401, response.getStatus()); //authentication is possible but has failed
	}
}
