package br.com.cinq.greet.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.cinq.greet.service.GreetService;

@Configuration
public class GreetServiceConfig extends ResourceConfig {
	public GreetServiceConfig() {
		register(GreetService.class);
	}
}