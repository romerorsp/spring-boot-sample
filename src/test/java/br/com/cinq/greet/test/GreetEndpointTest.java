package br.com.cinq.greet.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import br.com.cinq.greet.Application;
import br.com.cinq.greet.bean.GreetMessage;
import br.com.cinq.greet.bean.GreetRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebIntegrationTest(randomPort = true)
public class GreetEndpointTest {
	
	@Value("${local.server.port}")
	private int port;
	
	private URI uri;

	private RestTemplate rest;
	
	public @Before void setup() {
		 rest = new TestRestTemplate();
		 try {
			uri = new URI(String.format("http://localhost:%d/greet", port));
		} catch (URISyntaxException e) {
			Assert.fail("Your URI should be in a good syntax.");
		}
	}
	
	public @Test void retrieveGreetTest() {
		Assert.assertEquals("The status code should be OK!", HttpStatus.OK, rest.getForEntity(uri, GreetMessage.class).getStatusCode());
	}
	
	public @Test void configureGreetTest() {
		GreetRequest request = new GreetRequest();
		request.setGreet("Won't be used...");
		Assert.assertEquals("The status code should be CREATED!", HttpStatus.CREATED, rest.postForEntity(uri, request, GreetMessage.class).getStatusCode());
	}
	

	
	public @Test void greetTest() {
		GreetRequest request = new GreetRequest();
		String unique = String.format("Hello Test! I have this ticket: %s", UUID.randomUUID());
		request.setGreet(unique);
		Assert.assertEquals("The status code should be CREATED!", HttpStatus.CREATED, rest.postForEntity(uri, request, GreetMessage.class).getStatusCode());
		ResponseEntity<GreetMessage> result = rest.getForEntity(uri, GreetMessage.class);
		Assert.assertEquals("The status code should be OK!", HttpStatus.OK, result.getStatusCode());
		Assert.assertEquals("The greeting should match, but it isn't", unique, result.getBody().getGreet());
	}
}
