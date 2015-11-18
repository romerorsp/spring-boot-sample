package br.com.cinq.greet.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetServiceConfig extends ResourceConfig {
	public GreetServiceConfig() {
		packages("br.com.cinq.greet");
		property(ServletProperties.FILTER_FORWARD_ON_404, true);
	}
}