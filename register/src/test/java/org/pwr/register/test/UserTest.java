package org.pwr.register.test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.pwr.register.dto.UserDTO;
import org.pwr.register.model.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class UserTest {
	private WebResource webResource;
	private Client client;
	private static final String BASE_URI = "http://virt2.iiar.pwr.wroc.pl:8080/kurwa_mac/adminPanel/createUser/";
	
	@Before
	public void prepareConnection()
	{
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		client.addFilter(new LoggingFilter());
		webResource = client.resource(BASE_URI);
	}
	
	@Test
	public void correctLoginAdmin()
	{
		client.addFilter(new HTTPBasicAuthFilter("adm", "ini"));
		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
		assertEquals(204, response.getStatus());
	}
	
	@Test
	public void post()
	{
		client.addFilter(new HTTPBasicAuthFilter("adm", "ini"));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(
				ClientResponse.class, creatTestUser());
	/*
		client.addFilter(new HTTPBasicAuthFilter("test", "test"));
		ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
                */
		//assertEquals(409, response.getStatus()); //Conflict
		assertEquals(201, response.getStatus()); //CREATED
	}
	
	private UserDTO creatTestUser() {
		UserDTO user = new UserDTO();
		user.setLogin("Krzysiek");
		user.setPassword("test");
		return user;
	}

}
