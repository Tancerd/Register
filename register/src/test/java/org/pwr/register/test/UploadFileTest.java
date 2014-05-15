package org.pwr.register.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

public class UploadFileTest {
	private WebResource webResource;
	private Client client;
	// private static final String QUEST_URI =
	// "http://virt2.iiar.pwr.wroc.pl:8080/register/commonPanel/doneQuest/";
	private static final String QUEST_URI = "http://virt2.iiar.pwr.wroc.pl:8080/register/adminPanel/upload/";

	@Before
	public void prepareConnection() {
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		client.addFilter(new LoggingFilter());

	}

	@Test
	public void sentDoneTest() {
		webResource = client.resource(QUEST_URI);
		client.addFilter(new HTTPBasicAuthFilter("adm", "ini"));
		ClientResponse response = webResource.type(
				MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,
				createInstance());
		assertEquals(200, response.getStatus());
	}

	private FormDataMultiPart createInstance() {
		File f = new File("C:/Users/Tancerd/Downloads/LoW_Pack_vs_11.zip");
		FileDataBodyPart fdp = new FileDataBodyPart("file", f,
				MediaType.APPLICATION_OCTET_STREAM_TYPE);

		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();

		formDataMultiPart.bodyPart(fdp);
		return formDataMultiPart;
	}
}
