package org.pwr.register.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.pwr.register.dto.DoneQuestDTO;
import org.pwr.register.dto.QuestDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class DoneQuestTest {

	private WebResource webResource;
	private Client client;
	private static final String QUEST_URI = "http://virt2.iiar.pwr.wroc.pl:8080/register/commonPanel/doneQuest/";
	//private static final String QUEST_URI = "http://localhost:8080/register/commonPanel/doneQuest/";

	@Before
	public void prepareConnection()
	{
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		client.addFilter(new LoggingFilter());
		
	}
	
	@Test
	public void sentDoneTest()
	{
		webResource = client.resource(QUEST_URI);
		client.addFilter(new HTTPBasicAuthFilter("Krzysiek", "test"));
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, createInstance());
		assertEquals(202, response.getStatus());
	}
	
	public DoneQuestDTO createInstance()
	{
		DoneQuestDTO doneQuestDTO = new DoneQuestDTO();
		doneQuestDTO.setDoneTime(new Date());
		doneQuestDTO.setExtraPoints(11);
		
		QuestDTO questDTO = new QuestDTO();
		questDTO.setDefaultPoints(20);
		questDTO.setDefaultTime(new Date());
		questDTO.setName("POSTQuest11");
		doneQuestDTO.setQuestDTO(questDTO);
		
		return doneQuestDTO;
	}
}
